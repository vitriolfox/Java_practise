package com.flowacademy.verem;

import com.flowacademy.verem.exceptions.PopException;
import com.flowacademy.verem.exceptions.PushException;

import java.util.Arrays;

public class Verem {
    public int[] verem;
    public int head = 0;

    public void push(int a) throws PushException{
        if (head < verem.length){
            System.out.println("hozzaadtam a " + a + " szamot");
            verem[head] = a;
            head++;
        } else {
            throw new PushException("Nincs hely a vörömben!");
        }

    }

    public int pop() throws PopException{
        if (head > 0){
            head--;
            int tarolo = verem[head];
            verem[head] = 0;
            System.out.println("kivettem a " + tarolo + " szamot");
            return tarolo;
        } else {
            throw new PopException("Nincs má több elem.");
        }

    }

    @Override
    public String toString() {
        return "com.flowacademy.verem.Verem{" +
                "verem=" + Arrays.toString(verem) +
                '}';
    }

    public Verem() {
        this.verem = new int[10];
    }

    public Verem(int veremSzam) {
        this.verem = new int[veremSzam];
    }

    public static void main(String[] args) {
        Verem verem = new Verem(2);

        try {
            verem.push(10);
            verem.push(20);
            verem.push(50);
            verem.pop();

        } catch (PushException | PopException e) {
            e.printStackTrace();

        } finally {
            System.out.println("Ez egy verem volt.");
        }

        System.out.println(verem);

    }
}
