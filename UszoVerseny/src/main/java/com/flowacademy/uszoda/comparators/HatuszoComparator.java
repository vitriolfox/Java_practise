package com.flowacademy.uszoda.comparators;

import com.flowacademy.uszoda.Hatuszo;

import java.util.Comparator;

public class HatuszoComparator implements Comparator<Hatuszo> {
    @Override
    public int compare(Hatuszo hatuszo, Hatuszo t1) {
        if (hatuszo.versenyez(200) > t1.versenyez(200)){
            return 1;
        } else if (hatuszo.versenyez(200) < t1.versenyez(200)){
            return -1;
        } else {
            return 0;
        }
    }
}
