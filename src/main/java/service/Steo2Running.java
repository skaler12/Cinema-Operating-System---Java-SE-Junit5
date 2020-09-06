package service;

import service.Step2;

import java.io.IOException;

public class Steo2Running {
    public static void Step2Run() throws IOException {
        while (Step2.StepNumber2() != 1) {
            if (Step2.StepNumber2() == 1) {
                Step3.stepNumber3();
                break;
            }
        }
    }
}
