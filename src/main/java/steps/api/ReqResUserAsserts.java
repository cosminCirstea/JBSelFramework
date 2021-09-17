package steps.api;

import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class ReqResUserAsserts extends BaseSteps {

    public ReqResUserAsserts(SharedData share) {
        super(share);
    }

    @Then("the data of the new user is fetched")
    public void getUserDataIsFetched() {
        Assert.assertEquals(share.expectedUserTestDataVehicle.getName(), share.actualUserTestDataVehicle.getName());
        Assert.assertEquals(share.expectedUserTestDataVehicle.getJob(), share.actualUserTestDataVehicle.getJob());
    }
}
