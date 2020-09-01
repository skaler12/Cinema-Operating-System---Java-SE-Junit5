package service;

import entity.User;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class RegisterService {
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
        System.out.println("enter amout of money");
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

    public static void LogginForm(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your loggin");
        String logginSearching = in.next();
        Optional<User> userSearching = Optional.of(usersList.stream()
                .filter(user -> (user.getLogin().equals(logginSearching)))
                .findAny()
                .get());
    }
}
