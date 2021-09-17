package tests;

import bdd.setup.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import steps.api.ReqResUserAsserts;
import steps.api.ReqResCreateNewUserSteps;
import steps.api.ReqResGetUser;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class ReqresCreateNewUserTest extends StoryMapper {

    public ReqresCreateNewUserTest() {
        addSteps(new ReqResCreateNewUserSteps(share), new ReqResGetUser(share), new ReqResUserAsserts(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/reqres_create_new_user.story", "");
    }

}
