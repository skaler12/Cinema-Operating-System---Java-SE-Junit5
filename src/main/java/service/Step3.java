package service;

import dto.SpectacleList;
import entity.Spectacle;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static service.RegisterAndLogginService.userWithLoggin;

public class Step3 {
    public static void stepNumber3() throws IOException {
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
                buyTicket();

            } else if (optionCheck == 2) {
                System.out.println("lista biletow");
                checkYourTickets();
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

    private static void checkYourTickets() {
        userWithLoggin.getSpectacleList().stream().forEach(spectacle -> System.out.println(spectacle));
        System.out.println("Click button and go back to menu.");
        System.out.println("Remember that your tickets are in the tickets catalog, you can print them out!");
        Scanner in  = new Scanner(System.in);
        String x = in.next();
    }

    /**
     * Method which generate welcome message before step number 3.
     * @return
     */

    private static StringBuilder welcomeMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        String text1 = "-------------------------------------\n";
        String text2 = "Welcome ";
        String text3 = userWithLoggin.getLogin();
        String text4 = " in GoodMovies Cinema!\n";
        stringBuilder.append(text1);
        stringBuilder.append(text2);
        stringBuilder.append(text3);
        stringBuilder.append(text4);
        stringBuilder.append(text1);
        return stringBuilder;
    }
    private static void buyTicket() throws IOException {
        Consumer<Spectacle>spectacleConsumer = spectacle -> System.out.println(spectacle);
        SpectacleList.spectacleLinkedList.forEach(spectacleConsumer);
        /**
         * Admin must change this code if he add new Spectacles
         */
        System.out.println("Which spectacle are you interest in?");
        System.out.println("press 1 - " + SpectacleList.spectacleLinkedList.get(0).toString() + "\n"
                            +"press 2 - " + SpectacleList.spectacleLinkedList.get(1).toString() + "\n"
                            +"press 3 - " + SpectacleList.spectacleLinkedList.get(2).toString() + "\n"
                            +"press 4 - " + SpectacleList.spectacleLinkedList.get(3).toString() + "\n"
        );

        Scanner in = new Scanner(System.in);
        int checkSpectacle;
        checkSpectacle = in.nextInt();
        /**
         * Instructions regarding buying tickets
         */
        if(checkSpectacle==1) {
            System.out.println("Are you sure that you can buy ticket on " + SpectacleList.spectacleLinkedList.get(0).getSpectacleName() + " ?\n"
                    + "Ticket cost " + SpectacleList.spectacleLinkedList.get(0).getTicketPrice());
            System.out.println("Yes - press - 1 \n No - press - 2");
            int makeSure;
            makeSure = in.nextInt();
            if (makeSure == 1) {
                if (SpectacleList.spectacleLinkedList.get(0).getTicketPrice() > userWithLoggin.getMoney()) {
                    System.out.println("You have not enought money!");
                    Step3.stepNumber3();
                }
                System.out.println("You buy ticket on this spectacl.");
                userWithLoggin.getSpectacleList().add(SpectacleList.spectacleLinkedList.get(0));
                userWithLoggin.setMoney(userWithLoggin.getMoney() - SpectacleList.spectacleLinkedList.get(0).getTicketPrice());

                /**
                 * File Save - generate ticket.txt
                 */
                FileWriter fileWriter = null;
                try{
                    fileWriter=new FileWriter("C:\\Users\\Grzegorz\\Desktop\\IntellijProjects\\CinemaOperatingSystem\\src\\main\\java\\tickets\\\\ticket1.txt");
                    fileWriter.write(SpectacleList.spectacleLinkedList.get(0).toString());
                }
                finally {
                    if(fileWriter!=null){
                    fileWriter.close();
                    }
                }

                Step3.stepNumber3();
            }
        }
           else if(checkSpectacle==2) {
                System.out.println("Are you sure that you can buy ticket on " + SpectacleList.spectacleLinkedList.get(1).getSpectacleName() + " ?\n"
                        + "Ticket cost " + SpectacleList.spectacleLinkedList.get(1).getTicketPrice());
                System.out.println("Yes - press - 1 \n No - press - 2");
                int makeSure1;
                makeSure1 = in.nextInt();
                if (makeSure1 == 1) {
                    if (SpectacleList.spectacleLinkedList.get(1).getTicketPrice() > userWithLoggin.getMoney()) {
                        System.out.println("You have not enought money!");
                        Step3.stepNumber3();
                    }
                    System.out.println("You buy ticket on this spectacl.");
                    userWithLoggin.getSpectacleList().add(SpectacleList.spectacleLinkedList.get(1));
                    userWithLoggin.setMoney(userWithLoggin.getMoney() - SpectacleList.spectacleLinkedList.get(1).getTicketPrice());
                    /**
                     * File Save - generate ticket.txt
                     */
                    FileWriter fileWriter = null;
                    try{
                        fileWriter=new FileWriter("C:\\Users\\Grzegorz\\Desktop\\IntellijProjects\\CinemaOperatingSystem\\src\\main\\java\\tickets\\\\ticket2.txt");
                        fileWriter.write(SpectacleList.spectacleLinkedList.get(1).toString());
                    }
                    finally {
                        if(fileWriter!=null){
                            fileWriter.close();
                        }
                    }
                    Step3.stepNumber3();
                }
            }
           else if(checkSpectacle==3) {
                System.out.println("Are you sure that you can buy ticket on " + SpectacleList.spectacleLinkedList.get(2).getSpectacleName() + " ?\n"
                        + "Ticket cost " + SpectacleList.spectacleLinkedList.get(2).getTicketPrice());
                System.out.println("Yes - press - 1 \n No - press - 2");
                int makeSure2;
                makeSure2 = in.nextInt();
                if (makeSure2 == 1) {
                    if (SpectacleList.spectacleLinkedList.get(2).getTicketPrice() > userWithLoggin.getMoney()) {
                        System.out.println("You have not enought money!");
                        Step3.stepNumber3();
                    }
                    System.out.println("You buy ticket on this spectacl.");
                    userWithLoggin.getSpectacleList().add(SpectacleList.spectacleLinkedList.get(2));
                    userWithLoggin.setMoney(userWithLoggin.getMoney() - SpectacleList.spectacleLinkedList.get(2).getTicketPrice());
                    /**
                     * File Save - generate ticket.txt
                     */
                    FileWriter fileWriter = null;
                    try{
                        fileWriter=new FileWriter("C:\\Users\\Grzegorz\\Desktop\\IntellijProjects\\CinemaOperatingSystem\\src\\main\\java\\tickets\\\\ticket3.txt");
                        fileWriter.write(SpectacleList.spectacleLinkedList.get(2).toString());
                    }
                    finally {
                        if(fileWriter!=null){
                            fileWriter.close();
                        }
                    }
                    Step3.stepNumber3();
                }
            }
            else if(checkSpectacle==4) {
                System.out.println("Are you sure that you can buy ticket on " + SpectacleList.spectacleLinkedList.get(3).getSpectacleName() + " ?\n"
                        + "Ticket cost " + SpectacleList.spectacleLinkedList.get(3).getTicketPrice());
                System.out.println("Yes - press - 1 \n No - press - 2");
                int makeSure3;
                makeSure3 = in.nextInt();
                if (makeSure3 == 1) {
                    if (SpectacleList.spectacleLinkedList.get(3).getTicketPrice() > userWithLoggin.getMoney()) {
                        System.out.println("You have not enought money!");
                        Step3.stepNumber3();
                    }
                    System.out.println("You buy ticket on this spectacl.");
                    userWithLoggin.getSpectacleList().add(SpectacleList.spectacleLinkedList.get(3));
                    userWithLoggin.setMoney(userWithLoggin.getMoney() - SpectacleList.spectacleLinkedList.get(3).getTicketPrice());
                    /**
                     * File Save - generate ticket.txt
                     */
                    FileWriter fileWriter = null;
                    try{
                        fileWriter=new FileWriter("C:\\Users\\Grzegorz\\Desktop\\IntellijProjects\\CinemaOperatingSystem\\src\\main\\java\\tickets\\\\ticket4.txt");
                        fileWriter.write(SpectacleList.spectacleLinkedList.get(3).toString());
                    }
                    finally {
                        if(fileWriter!=null){
                            fileWriter.close();
                        }
                    }
                    Step3.stepNumber3();
                }
            }
            else {
                System.out.println("We have not spectacl with this number :(");
                Step3.stepNumber3();
            }
        }
    }

