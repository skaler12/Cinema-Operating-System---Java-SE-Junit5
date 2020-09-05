
import service.Steo2Running;
import service.Step1;
import service.Step3;

public class StartProgram {
    public static void main(String[] args) {

        /**
         * Step 1
         * Starting Program - welcome message
         */
        Step1.WelcomeMessage();

        /**
         * Step 2 - register and loggin form
         */
         Steo2Running.Step2Run();
        /**
         * STEP 3 - client panel
         */
        /**
         * Typy generyczne , try with resources, lambda, stream, op. na plikach , serializacja
         * Musi być mozliwość zobaczenia wszystkich seansow wraz z godzinami ich grania i dniami
         * nastepnie wygenerowanie metody kup bilet , ktora odejmie kase za bilet i wygeneruje gotowy dokument
         * nastepnie obiekt user zostanie zserializowany tak by mozna bylo go gdzie indziej otworzyc
         * uzyc lambd i stramaow do szukania . Na koniec user powinien zobaczyc swoje bilety
         */
        Step3.stepNumber3();

    }
}