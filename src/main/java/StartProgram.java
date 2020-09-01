
import java.util.Scanner;

import static service.StartingService.*;
import static service.RegisterService.*;

public class StartProgram {
    public static void main(String[] args) {
        /**
         * Step 1
         * Starting Program - welcome message
         */
        WelcomeMessage();

        /**
         * Step 2
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Loggin - press 1 \nRegister - press 2");
        int statusStep2;

            if(in.hasNextInt()){
                statusStep2=in.nextInt();

                if(statusStep2==1){
                    LogginForm();
                }
                else if(statusStep2==2){
                    RegisterForm();
                }
            }
            else{
                in.next();
                statusStep2=0;
            }

            if((statusStep2!=1)&&(statusStep2!=2)){
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
        /**
         * STEP 3
         */
        LogginForm();
    }
}