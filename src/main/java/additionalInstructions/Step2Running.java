package additionalInstructions;

import service.Step2;
import service.Step3;

import java.io.IOException;

public class Step2Running {
    public static void Step2Run() throws IOException {
        while (Step2.StepNumber2() != 1) {
            if (Step2.StepNumber2() == 1) {
                Step3.stepNumber3();
                break;
            }
        }
    }
}
