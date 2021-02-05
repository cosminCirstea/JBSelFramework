package steps.setup;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import pages.utils.PageFactoryUtils;
import utilities.SharedData;

public class StoryBasic extends BaseSteps {

    public StoryBasic(SharedData share) {
        super(share);
    }

    @BeforeStory
    public void setup() {
        share.driver = share.selenium.getCachedWebDriver();
        share.pageFactoryUtils = new PageFactoryUtils(share.driver);
    }

    @AfterStory
    public void teardown() {
        share.selenium.quitDriver();
    }

}
