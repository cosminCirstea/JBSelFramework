package steps.api;

import org.jbehave.core.annotations.When;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class ReqResGetUser extends BaseSteps {

    public ReqResGetUser(SharedData share) { super(share);}

    @When("trying to fetch the data of the new user")
    public void whenFetchingUserById() {
        share.actualUserTestDataVehicle = share.jsonUtilities.userJsonToPojo(share.response);
    }

}
