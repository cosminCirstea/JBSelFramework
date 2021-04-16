package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import pages.GoogleHomePage;
import pages.utils.PageFactoryUtils;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class GoogleSearchSteps extends BaseSteps {

    private GoogleHomePage googleHomePage;
    private String searchedText = "Google";

    public GoogleSearchSteps(SharedData share) {
        super(share);
    }

    @Given("the google home page")
    public void getGooglePage() {
        googleHomePage = share.pageFactoryUtils.newGoogleHomePage();
        googleHomePage.get();
    }

    @When("I search google for google")
    public void searchGoogle() {
        googleHomePage.setSearch(searchedText);
    }

    @Then("I get google as result")
    public void checkSearchResult() {
        googleHomePage.assertSearchedResult();
    }

}
