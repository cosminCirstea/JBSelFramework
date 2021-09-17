package utilities;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SuppressWarnings({"AccessOfSystemProperties", "UseOfSystemOutOrSystemErr", "HardcodedFileSeparator"})
public class HttpRequestEngine {

    private static final PoolingHttpClientConnectionManager poolingClientConnectionManager;

    static {
        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }
        assert sslContext != null;
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        Registry<ConnectionSocketFactory> socketFactoryRegistry =
                RegistryBuilder.<ConnectionSocketFactory> create()
                        .register("https", sslsf)
                        .register("http", new PlainConnectionSocketFactory())
                        .build();
        poolingClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        poolingClientConnectionManager.setDefaultMaxPerRoute(20);
    }

    private String url;
    private HttpResponse response;
    private final HttpClient httpClient;
    private String responsePayload;

    public HttpRequestEngine(String url) {
        this.url = url;

        httpClient = HttpClients.custom().
                setConnectionManager(poolingClientConnectionManager).
                setRedirectStrategy(new DefaultRedirectStrategy() {
                    @SuppressWarnings({"MethodReturnAlwaysConstant", "RefusedBequest"})
                    @Override
                    public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context) {
                        return false;
                    }
                }).build();
    }

    public void sendHttpPost(String json) throws IOException {
        HttpPost postMethod = new HttpPost(url);

        try {
            StringEntity entity;
            entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            postMethod.setEntity(entity);
            response = httpClient.execute(postMethod);
        } finally {
            after(postMethod);
        }
    }

    public void sendHttpGet() throws IOException {
        HttpGet getMethod = new HttpGet(url);
        try {
            response = httpClient.execute(getMethod);
        } catch (HttpHostConnectException e) {
            e.printStackTrace();
        } finally {
            after(getMethod);
        }
    }

    public int getResponseCode() {
        int responseCode = -1;
        if ((response != null) && (response.getStatusLine() != null)) {
            responseCode = response.getStatusLine().getStatusCode();
        }
        return responseCode;
    }

    private void after(HttpRequestBase httpRequestBase) throws IOException {
        responsePayload = null;
        if (response != null && response.getEntity() != null && response.getEntity().getContent() != null) {
            responsePayload = convertStreamtoString(response.getEntity().getContent());
            EntityUtils.consume(response.getEntity());
        }
        httpRequestBase.releaseConnection();
    }

    private String convertStreamtoString(InputStream inputStream) {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public String getPayload() {
        return responsePayload;
    }
}

