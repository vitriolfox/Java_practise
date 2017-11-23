package videoteka;

import exception.HibasKikolcsonzesException;

import java.io.Serializable;

public interface Kolcsonozheto extends Serializable{

    boolean kikolcsonoz(int kor, int meddig) throws HibasKikolcsonzesException;
    boolean visszahoz();

}
