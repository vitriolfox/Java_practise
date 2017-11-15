import com.flowacademy.automata.*;

public class Forgalmazo {

    private static void informacio(ItalAutomata italAutomata){
        System.out.println("Felhasználható poharak száma: " + italAutomata.getPoharakSzama());
        System.out.println("Bedobott pénzösszeg: " + italAutomata.getBedobottPenz());
    }

    public static void main(String[] args) {

        int n = 0;
        ItalAutomata[] automata = new ItalAutomata[args.length/2];
        for (int i = 0; i < args.length; i += 2) {
            automata[n] = new ItalAutomata(Integer.parseInt(args[0]), true);

            if (args[1].equals("true")){

                automata[n].setHidegIal(true);

            } else if (args[1].equals("false")){

                automata[n].setHidegIal(false);

            } else {

                System.out.println("A paraméterek helytelenül lettek megadva.");
            }
        }

        automata[0].penztBedob(100);
        informacio(automata[0]);
        System.out.println(automata[0].toString());


    }
}
