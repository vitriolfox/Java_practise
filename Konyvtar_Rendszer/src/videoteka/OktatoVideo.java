package videoteka;

import exception.HibasKikolcsonzesException;

public final class OktatoVideo extends Video {

    public OktatoVideo(String filmCime, String kolcsonzesiIdo) {
        super(filmCime, kolcsonzesiIdo, 0);
    }



    @Override
    public boolean kikolcsonoz(int kor, int meddig) throws HibasKikolcsonzesException {

        if (meddig <= this.kolcsonzesiIdoInt){
            this.kolcsonozheto = false;
            return true;
        } else if (!this.kolcsonozheto){
            return false;

        } else {
            throw new HibasKikolcsonzesException ("Hibásan megadott kikölcsönzési paraméterek!");
        }
    }
}
