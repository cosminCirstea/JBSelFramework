package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleHomePage extends LoadableComponent<GoogleHomePage> {

    private WebDriver driver;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();
    private final WebDriverWait wait;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    @FindBy(name = "q")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@id='result-stats']")
    private WebElement searchResults;
    @FindBy(css = "iframe[src^='https://consent.google.com']")
    private WebElement iFrameConsent;
    @FindBy(xpath = "//div[@id='introAgreeButton']")
    private WebElement agreeButton;

    public void setSearch(String searchedText) {
        elementToBeClickable(searchBar).sendKeys(searchedText);
        searchBar.submit();
    }

    public void assertSearchedResult() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        assertTrue(wait.until(ExpectedConditions.visibilityOf(searchResults)).isDisplayed());
    }

    public void acceptGoogleCookies() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameConsent)
                        .andThen(ExpectedConditions.elementToBeClickable(agreeButton))).click();
        driver.switchTo().defaultContent();
    }

    private WebElement elementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Override
    protected void load() {
        driver.get(dataFromPropertyFile.getGoogleHomePage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(dataFromPropertyFile.getGoogleHomePage(), driver.getCurrentUrl());
    }
}
