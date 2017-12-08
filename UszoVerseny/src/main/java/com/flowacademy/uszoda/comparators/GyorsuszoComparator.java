package com.flowacademy.uszoda.comparators;

import com.flowacademy.uszoda.Gyorsuszo;
import com.flowacademy.uszoda.Uszo;
import com.flowacademy.uszoda.Versenyzo;

import java.util.Comparator;

public class GyorsuszoComparator implements Comparator<Gyorsuszo> {

    @Override
    public int compare(Gyorsuszo versenyzo1, Gyorsuszo versenyzo2) {
        if (versenyzo1.versenyez(100) > versenyzo2.versenyez(100)){
            return 1;
        } else if (versenyzo1.versenyez(100) < versenyzo2.versenyez(100)){
            return -1;
        } else {
            return 0;
        }
    }
}
