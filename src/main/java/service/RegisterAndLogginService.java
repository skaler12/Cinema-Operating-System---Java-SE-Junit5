package service;

import entity.User;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class RegisterAndLogginService {
    public static List<User>ListAccepted = new LinkedList<>();
    public static User userWithLoggin;

    public static LinkedList<User>usersList = new LinkedList<>();
    /**
     *Methods which create User account
     */
    public static void RegisterForm() {

        User user = new User();
        Scanner in = new Scanner(System.in);

        /**
         * Loggin input Data
         */
        String loggin="";
        boolean logginStatus = false;
        while (!logginStatus) {
            System.out.println("Enter Login");
            loggin = in.nextLine();
            //EXIT
            if(loggin.equals("exit")){
                System.exit(0);
            }
            if(loggin.length()<=4){
                System.out.println("Loggin is too short. Loggin length minimum 5 chars");
                continue;
            }
            user.setLogin(loggin);
            logginStatus=true;
        }
        /**
         * Password input data
         */
        String password="";
        boolean passwordStatus = false;
        while (!passwordStatus) {
            System.out.println("Enter Password");
            password = in.nextLine();
            //Exit
            if(password.equals("exit")){
                System.exit(0);
            }

            if(password.length()<=3){
                System.out.println("Pasword is too short. Password length minimum 4 chars");
                continue;
            }
            user.setPassword(password);
            passwordStatus=true;
        }

        /**
         * Money input data
         */
        int money;
        System.out.println("enter amount of money");
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt()){
            money=sc.nextInt();
            user.setMoney(money);
        }
        else {
            sc.next();
            money=0;
        }
        while (money<10){
            System.out.println("Invalid input data");
            if(sc.hasNextInt()){
                money=sc.nextInt();
                user.setMoney(money);
            }
            else {
                String dummy = sc.next();
                money=0;
            }
        }
        usersList.add(user);
        /**
         *Return User Form Information
         */
        StringBuilder info = new StringBuilder();
        String text1 = "Hello ";
        String text2 = "\nYour password: ";
        String text3 = "\nYou has ";
        String text4 = " Euro.";

        info.append(text1);
        info.append(user.getLogin());
        info.append(text2);
        info.append(user.getPassword());
        info.append(text3);
        info.append(user.getMoney());
        info.append(text4);

        System.out.println(info);
    }

    /**
     * Method with give acces to user accout, couse loggin user
     */
    public static void LogginForm(){
        /**
         * Loggin input data
         */
        Scanner in = new Scanner(System.in);
        boolean logginStatus = false;
        String logginSearching;
        while (!logginStatus) {
            System.out.println("Please enter your loggin");
            logginSearching = in.nextLine();
            String finalLogginSearching = logginSearching;

            //EXIT
            if(finalLogginSearching.equals("exit")){
                System.exit(0);
            }

            List<User>ListAccepted = usersList.stream()
                    .filter(user -> (user.getLogin().equals(finalLogginSearching)))
                    .collect(Collectors.toList());
            if(ListAccepted.isEmpty()){
                System.out.println("Ups.. we have not account with this loggin, try again");
                continue;
            }
            else {
                userWithLoggin = ListAccepted.get(0);
                System.out.println("Please enter your password");
                String passwordSearch = in.next();
                //Exti
                if(passwordSearch.equals("exit")){
                    System.exit(0);
                }
                if(passwordSearch.equals(ListAccepted.get(0).getPassword())){
                    System.out.println("Loggin succesfull");
                }
                else{
                    System.out.println("ups something went wrong :(");
                    continue;
                }
            }
            logginStatus=true;
        }
    }
}
