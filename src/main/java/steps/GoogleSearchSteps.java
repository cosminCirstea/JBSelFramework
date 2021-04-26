package steps;

import org.jbehave.core.annotations.When;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class GoogleSearchSteps extends BaseSteps {

    public GoogleSearchSteps(SharedData share) {
        super(share);
    }

    @When("I search google for google")
    public void searchGoogle() {
        share.pageFactoryUtils.getGoogleHomePage().setSearch("Google");
    }

}
