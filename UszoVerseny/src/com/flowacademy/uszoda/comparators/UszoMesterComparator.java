package com.flowacademy.uszoda.comparators;

import com.flowacademy.uszoda.Uszo;
import com.flowacademy.uszoda.UszoMester;

import java.util.Comparator;

public class UszoMesterComparator implements Comparator<Uszo> {

    @Override
    public int compare(Uszo uszoMester, Uszo t1) {
        return String.CASE_INSENSITIVE_ORDER.compare(uszoMester.getNev(), t1.getNev());
    }
}
