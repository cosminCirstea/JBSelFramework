package tests;

import bdd.setup.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import steps.GoogleSearchSteps;
import steps.setup.StoryBasic;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class GoogleSearchTest extends StoryMapper {

    /*
    the constructor of the glue class, where the StoryBasic in which the WebDriver is instantiated + steps classes
    where text is implemented as code
     */
    public GoogleSearchTest() {
        addSteps(new StoryBasic(share), new GoogleSearchSteps(share));
    }

    /*
    this points to the location of the story file of this test
     */
    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/google_search.story", "");
    }

}
