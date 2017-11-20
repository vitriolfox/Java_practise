package com.flowacademy.observer;

public class Main {
    public static void main(String[] args) {
        Lovaskocsi lovaskocsi = new Lovaskocsi();
        lovaskocsi.beszall(new Karakter("Söhörekk", "Itt"));
        lovaskocsi.beszall(new Karakter("Szamarály", "Kaki"));

        lovaskocsi.ottVagyunk("Itt");
        lovaskocsi.ottVagyunk("Ott");
        lovaskocsi.ottVagyunk("Hol");
        lovaskocsi.ottVagyunk("Amott");
        lovaskocsi.ottVagyunk("Kaki");
    }
}
