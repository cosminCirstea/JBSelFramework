package rest;

import org.junit.Assert;
import utilities.HttpRequestEngine;
import utilities.JsonUtilities;
import utilities.pojos.User;

import java.io.IOException;

public class UserApi {
    private static final String userServiceBaseUrl = "https://reqres.in/api/users";

    public static String createUser(User user, int statusCode, JsonUtilities jsonUtilities) {
        HttpRequestEngine httpRequestEngine = new HttpRequestEngine(userServiceBaseUrl);
        try {
            httpRequestEngine.sendHttpPost(jsonUtilities.pojoToJson(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(statusCode, httpRequestEngine.getResponseCode());
        return httpRequestEngine.getPayload();
    }


    public static String getUserById(int statusCode, String id) {
        HttpRequestEngine httpRequestEngine = new HttpRequestEngine(userServiceBaseUrl + "/" + id);
        try {
            httpRequestEngine.sendHttpGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(statusCode, httpRequestEngine.getResponseCode());
        return httpRequestEngine.getPayload();
    }
}
