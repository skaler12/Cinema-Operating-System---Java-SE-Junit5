
import additionalInstructions.Step2Running;
import service.Step1;
import service.Step3;

import java.io.IOException;

public class StartProgram {
    public static void main(String[] args) throws IOException {

        /**
         * Step 1
         * Starting Program - welcome message
         */
        Step1.WelcomeMessage();

        /**
         * Step 2 - register and loggin form
         */
         Step2Running.Step2Run();
        /**
         * STEP 3 - client panel - buy tickets, tickets list, more...
         */
        Step3.stepNumber3();
    }
}