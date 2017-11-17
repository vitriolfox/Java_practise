package com.flofacademy.storage;

import com.flofacademy.exceptions.BadQualityException;

public interface Ware {
    boolean isGood() throws BadQualityException;
    }
