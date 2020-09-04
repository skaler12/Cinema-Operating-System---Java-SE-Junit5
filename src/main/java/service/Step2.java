package service;

import java.util.Scanner;

import static service.RegisterAndLogginService.LogginForm;
import static service.RegisterAndLogginService.RegisterForm;

public class Step2 {
    public static int StepNumber2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Loggin - press 1 \nRegister - press 2");
        int statusStep2;

        if (in.hasNextInt()) {
            statusStep2 = in.nextInt();

            if (statusStep2 == 1) {
                LogginForm();
            } else if (statusStep2 == 2) {
                RegisterForm();
            }
        } else {
            in.next();
            statusStep2 = 0;
        }

        if ((statusStep2 != 1) && (statusStep2 != 2)) {
            while ((statusStep2 != 1) || (statusStep2 != 2)) {
                System.out.println("Invalid input data");
                if (in.hasNextInt()) {
                    statusStep2 = in.nextInt();
                    if (statusStep2 == 1) {
                        System.out.println("Loggin");
                        break;
                    } else if (statusStep2 == 2) {
                        RegisterForm();
                        break;
                    }
                } else {
                    String dummy = in.next();
                    statusStep2 = 0;
                }
            }
        }
        if(statusStep2==1){
            return 1;
        }
        return 2;
    }
}
