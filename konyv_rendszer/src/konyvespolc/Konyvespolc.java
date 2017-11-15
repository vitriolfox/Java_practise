package konyvespolc;
import java.util.*;
import com.flowacademy.konyv.Konyv;
import com.flowacademy.konyv.Regeny;
import com.flowacademy.konyv.Tankonyv;

public class Konyvespolc {

    private static List<Konyv> konyvTomb = new ArrayList<Konyv>();

    public static void polcraTesz(Konyv konyv){
        konyvTomb.add(konyv);
    }

    public static Konyv konyvkoto(String adatok){
        String[] konyvParameterek = adatok.split(",");
        String cim = konyvParameterek[0];
        String szerzo = konyvParameterek[1];
        String kiado = konyvParameterek[2];
        int kiadasEve = Integer.parseInt(konyvParameterek[3]);

        Konyv kotottKonyv = new Konyv(cim, szerzo, kiado,kiadasEve);

        return kotottKonyv;
    }

    public static void main(String[] args) {

        System.out.print("Bementei argumentumok: ");
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();


        for (int i = 0; i < args.length; i += 2) {

            if (args[i].equals("Tankonyv")) {

                String[] konyvParameterek = args[i + 1].split(",");
                Konyv konyv = konyvkoto(args[i+1]);

                if (konyvParameterek.length == 5) {

                    String tantargy = konyvParameterek[4];
                    polcraTesz(new Tankonyv(konyv.getCim(), konyv.getSzerzo(), konyv.getKiado(), konyv.getDatum(),tantargy));

                } else {

                    polcraTesz(new Tankonyv(konyv.getCim(), konyv.getSzerzo(), konyv.getKiado(), konyv.getDatum()));
                }

            } else if (args[i].equals("Regeny")) {

                String[] konyvParameterek = args[i + 1].split(",");
                Konyv konyv = konyvkoto(args[i+1]);

                if (konyvParameterek.length == 5) {

                    String tipus = konyvParameterek[4];
                    polcraTesz(new Regeny(konyv.getCim(), konyv.getSzerzo(), konyv.getKiado(), konyv.getDatum(), tipus));

                } else {

                    polcraTesz(new Regeny(konyv.getCim(), konyv.getSzerzo(), konyv.getKiado(), konyv.getDatum()));
                }
            }
        }
        System.out.println("==============================================================");
        System.out.println(konyvTomb);
    }
}
