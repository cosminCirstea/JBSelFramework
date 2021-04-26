package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.GoogleHomePage;

public class PageFactoryUtils {

    private WebDriver driver;

    private GoogleHomePage googleHomePage;

    public PageFactoryUtils(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleHomePage instantiateGoogleHomePage() {
        return googleHomePage = PageFactory.initElements(driver, GoogleHomePage.class);
    }

    public GoogleHomePage getGoogleHomePage() {
        return googleHomePage;
    }

}
