package steps;

import org.jbehave.core.annotations.Then;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class GoogleAssertsSteps extends BaseSteps {

    public GoogleAssertsSteps(SharedData share) {
        super(share);
    }

    @Then("I get google as result")
    public void checkSearchResult() {
        share.pageFactoryUtils.getGoogleHomePage().assertSearchedResult();
    }

}
