package utilities;

import org.openqa.selenium.WebDriver;
import pages.utils.PageFactoryUtils;
import steps.setup.Selenium;
import utilities.pojos.User;

public class SharedData {

    public WebDriver driver;
    public Selenium selenium;
    public PageFactoryUtils pageFactoryUtils;
    public JsonUtilities jsonUtilities;
    public String response;
    public User actualUserTestDataVehicle;
    public User expectedUserTestDataVehicle;
}
