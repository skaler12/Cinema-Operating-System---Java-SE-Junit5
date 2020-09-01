package service;

public class StartingService {
    public static void WelcomeMessage(){
        String element1 = "|==";
        String element2 = "==|";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(element1);
        stringBuilder.append("Welcome in GOOD-MOVIES Cinema!");
        stringBuilder.append(element2);

        System.out.println("|==================================|");
        System.out.println(stringBuilder);
        System.out.println("|==================================|");
        System.out.println();
    }
}
