package Kompendie;

import Kompendie.Hjelpeklasser.Tabell;

public class Program {

    public static void main(String[] args) {
        int[] a = Tabell.randPerm4(20); //en tilfeldig tabell
        for(int k : a){
            System.out.println(k+" "); //skriver ut a
        }

        int m = Tabell.maks(a);
        System.out.println("\nStørste verdi ligger på plass " + m);
    }
}
