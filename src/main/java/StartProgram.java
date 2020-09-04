
import service.RegisterAndLogginService;
import service.Step2;
import service.Step3;

import java.util.Scanner;

import static service.StartingService.*;
import static service.RegisterAndLogginService.*;

public class StartProgram {
    public static void main(String[] args) {

        /**
         * Step 1
         * Starting Program - welcome message
         */
        WelcomeMessage();

        /**
         * Step 2 - register and loggin form
         */
        while (Step2.StepNumber2()!=1) {
            if(Step2.StepNumber2()==1){
                break;
            }
            Step2.StepNumber2();
        }
        /**
         * STEP 3 - client panel
         */
        System.out.println("Step 3");
        Step3.stepNumber3();
    }
}