package service;

import service.Step2;

public class Steo2Running {
    public static void Step2Run() {
        while (Step2.StepNumber2() != 1) {
            if (Step2.StepNumber2() == 1) {
                Step3.stepNumber3();
                break;
            }
        }
    }
}
