package service;

import dto.SpectacleList;
import entity.Spectacle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Step3 {
    public static void stepNumber3() {
        /**
         * Typy generyczne , try with resources, lambda, stream, op. na plikach , serializacja
         *          * Musi być mozliwość zobaczenia wszystkich seansow wraz z godzinami ich grania i dniami
         *          * nastepnie wygenerowanie metody kup bilet , ktora odejmie kase za bilet i wygeneruje gotowy dokument
         *          * nastepnie obiekt user zostanie zserializowany tak by mozna bylo go gdzie indziej otworzyc
         *          * uzyc lambd i streamow do szukania . Na koniec user powinien zobaczyc swoje bilety
         */
        System.out.println(welcomeMessage());
        boolean status = false;
        while (!status) {
            System.out.println("Check what you want to do:\n1-Check Spectacles Lists in this week and buy tickets\n2-Check yours tickets\n3-Go back to loggin form");
            Scanner in = new Scanner(System.in);
            int optionCheck = in.nextInt();
            if (optionCheck == 1) {
                System.out.println("lista spektakli ");

                Consumer<Spectacle>spectacleConsumer = spectacle -> System.out.println(spectacle);
                SpectacleList.spectacleLinkedList.forEach(spectacleConsumer);

            } else if (optionCheck == 2) {
                System.out.println("lista biletow");
            }
            else if(optionCheck==3){
                Steo2Running.Step2Run();
                break;
            }
            else {
                continue;
            }
        }
    }

    /**
     * Method which generate welcome message before step number 3.
     * @return
     */

    private static StringBuilder welcomeMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        String text1 = "-------------------------------------\n";
        String text2 = "Welcome ";
        String text3 = RegisterAndLogginService.userWithLoggin.getLogin();
        String text4 = " in GoodMovies Cinema!\n";
        stringBuilder.append(text1);
        stringBuilder.append(text2);
        stringBuilder.append(text3);
        stringBuilder.append(text4);
        stringBuilder.append(text1);
        return stringBuilder;
    }
}
