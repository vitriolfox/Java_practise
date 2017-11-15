import com.flowacademy.filmek.AkcioFilm;
import com.flowacademy.filmek.Film;

import java.util.ArrayList;
import java.util.List;

public class OszkarGala {
    int galaEve;
    Film[] nevezettFilmek;
    static String alapito = "Douglas Fairbanks";



    public OszkarGala(int galaEve, Film[] nevezettFilmek) {
        this.galaEve = galaEve;
        this.nevezettFilmek = nevezettFilmek;
    }



    public static void main(String[] args) {

        List<Film> nevezettFilmek = new ArrayList<Film>();

        System.out.print("Bementei argumentumok: ");
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
        System.out.println("============================");

        for (int i=0; i < args.length; i++){
            String[] filmParameterek = args[i].split(",");

            String cim = filmParameterek[0];
            String rendezo = filmParameterek[1];
            int gyartasEve = Integer.parseInt(filmParameterek[2]);


            if (filmParameterek.length == 3 ){

                Film gyartottFilm = new Film(cim, rendezo, gyartasEve);
                nevezettFilmek.add(gyartottFilm);

            } else if (filmParameterek.length == 6){

                String fohosNeve = filmParameterek[3];
                boolean fohosNeme = Boolean.parseBoolean(filmParameterek[4]);
                int halottakAFilmben = Integer.parseInt(filmParameterek[5]);

                Film gyartottFilm = new AkcioFilm(cim, rendezo, gyartasEve, fohosNeve, fohosNeme, halottakAFilmben);
                nevezettFilmek.add(gyartottFilm);
            }
        }
        System.out.println(nevezettFilmek);
    }

}
