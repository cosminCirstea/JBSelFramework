package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.GoogleHomePage;

public class PageFactoryUtils {

    private WebDriver driver;

    public PageFactoryUtils(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleHomePage newGoogleHomePage() {
        return PageFactory.initElements(driver, GoogleHomePage.class);
    }

}
