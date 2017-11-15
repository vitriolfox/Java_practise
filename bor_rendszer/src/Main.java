import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void kiirBor(Bor bor){
        System.out.println(bor);
    }

    public static void main(String[] args) {

        List<Bor> pince = new ArrayList<Bor>();

        for (int i = 0; i < args.length; i++){

            if (args[i].equals("aszu")){

                pince.add(new Aszu(Integer.parseInt(args[i+1]),Integer.parseInt(args[i+2])));
                i+=2;

            } else {

                pince.add(new Bor(args[i],Integer.parseInt(args[i+1])));
                i++;

            }
        }

        System.out.println(pince);

    }
}
