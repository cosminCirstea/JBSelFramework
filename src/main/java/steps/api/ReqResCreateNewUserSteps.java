package steps.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jbehave.core.annotations.Given;
import rest.UserApi;
import steps.setup.BaseSteps;
import utilities.Generator;
import utilities.SharedData;
import utilities.pojos.User;

public class ReqResCreateNewUserSteps extends BaseSteps {

    public ReqResCreateNewUserSteps(SharedData share) {
        super(share);
    }

    @Given("a new user is created")
    public void createNewUser() {
        User user = new User(Generator.getRandomAlphaCharacters(5), Generator.getRandomAlphaCharacters(5));
        share.expectedUserTestDataVehicle = user;
        share.response =  UserApi.createUser(user, 201, share.jsonUtilities);
    }
}
