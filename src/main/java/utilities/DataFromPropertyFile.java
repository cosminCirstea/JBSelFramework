package utilities;

public class DataFromPropertyFile {

    private final String ENV_PROPERTIES_FILENAME = "data";
    private final ReadProperties envProperties = new ReadProperties(ENV_PROPERTIES_FILENAME);
    private final String geckoDriverLocationWin = envProperties.getProperty("gecko.driver.location");
    private final String chromeDriverLocationWin = envProperties.getProperty("chrome.driver.location");

    private final String googleHomePage= envProperties.getProperty("google.home.page");

    public String getGoogleHomePage() {
        return googleHomePage;
    }

    public String getChromeDriverLocationWin() {
        return chromeDriverLocationWin;
    }

    public String getGeckoDriverLocationWin() {
        return geckoDriverLocationWin;
    }
}
