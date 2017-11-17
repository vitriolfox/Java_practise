package com.flowacademy.lista;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();

        for (int i=0; i < 10; i++){
            lista.add(i);
        }

        Iterator<Integer> listaIterator = lista.iterator();

        /*
        for (int i=0; i < lista.size(); i++){
            if (lista.get(i) >= 2){
                lista.remove(i);
            }
        }*/
        while (listaIterator.hasNext()){
            if (listaIterator.next() <= 2) {
                listaIterator.remove();
            }
        }

        System.out.println(lista);


        int[] tomb1 = {1,2,3,4,5,6};
        int[] tomb2 = Arrays.copyOf(tomb1,6);

        for(int tombelem: tomb2){
            System.out.print(tombelem + ", ");
        }

    }
}
