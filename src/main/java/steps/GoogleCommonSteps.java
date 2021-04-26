package steps;

import org.jbehave.core.annotations.Given;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class GoogleCommonSteps extends BaseSteps {

    public GoogleCommonSteps(SharedData share) {
        super(share);
    }

    @Given("the google home page")
    public void getGooglePage() {
        share.pageFactoryUtils.instantiateGoogleHomePage();
        share.pageFactoryUtils.getGoogleHomePage().get();
    }

}
