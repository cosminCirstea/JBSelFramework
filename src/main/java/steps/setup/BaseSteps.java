package steps.setup;

import org.jbehave.core.steps.Steps;
import utilities.SharedData;

public class BaseSteps extends Steps {

    protected SharedData share;

    public BaseSteps(SharedData share) {
        this.share = share;
    }
}
