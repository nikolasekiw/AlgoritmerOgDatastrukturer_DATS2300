package Oblig.Oblig2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /**
         * Oppgave 1
         */

        System.out.println("Oppgave 1------------");

        String[] s = {"Ole", "Nikola", "Julie", "Synne", "Alex", "Liv"};

        Liste<String> liste = new DobbeltLenketListe<>(s);

        System.out.println(liste.antall() + " " + liste.tom());


        Integer[] s2 = {1, 2, 3, 4, 5, 3, 7};
        Liste<Integer> liste2 = new DobbeltLenketListe<>(s2);

        System.out.println(liste2.indeksTil(3));
        System.out.println(liste2.inneholder(5));
        System.out.println(liste2.fjern(5));

        String[] s3 = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste3 = new DobbeltLenketListe<>(s3);
        System.out.println(liste3.antall() + " " + liste3.tom());

        /**
         * Oppgave 2a
         */

        System.out.println("Oppgave 2a------------");

        String[] s4 = {}, s5 = {"A"}, s6 = {null, "A", null, "B", null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s4);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s5);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s6);
        System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString() + " " +
                l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());

        /**
         * Oppgave 2b
         */

        System.out.println("Oppgave 2b------------");

        DobbeltLenketListe<Integer> liste1 = new DobbeltLenketListe<>();
        System.out.println(liste1.toString() + " " + liste1.omvendtString());

        for (int i = 1; i <= 3; i++) {
            liste1.leggInn(i);
            System.out.println(liste1.toString() + " " + liste1.omvendtString());
        }

        /**
         * Oppgave 3b
         */

        System.out.println("Oppgave 3b------------");

        //Character[] c = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        //DobbeltLenketListe<Character> liste5 = new DobbeltLenketListe<>(c);
        //System.out.println(liste5.subliste(3, 8)); ​// [D, E, F, G, H]
        //System.out.println(liste5.subliste(5, 5)); //[]
        //System.out.println(liste5.subliste(8, liste5.antall())); ​// [I, J]
        // System.out.println(liste.subliste(0,11)); // skal kaste unntak

        /**
         * Oppgave 7
         */

        System.out.println("Oppgave 7------------");

        String[] a = {"Anne", "Kriatian", "Martine", "Nikola", "Ola"};
        DobbeltLenketListe<String> listea = new DobbeltLenketListe<>(a);
        listea.nullstill();
        System.out.println(listea);

        /**
         * Oppgave 8
         */

        System.out.println("Oppgave 8------------");

        String[] navn = {"Lars", "Anders", "Bodil", "Kari", "Per", "Berit"};
        Liste<String> liste10 = new DobbeltLenketListe<>(navn);

        liste10.forEach(g -> System.out.println(g + " "));
        System.out.println();
        for (String g : liste10) {
            System.out.println(g + " ");
        }

        /**
         * Oppgave 9
         */

        DobbeltLenketListe<String> liste11 = new DobbeltLenketListe<>(new String[]
                {"Birger", "Lars", "Anders", "Bodil", "Kari", "Per", "Berit"});

        //iste11.fjernHvis(navn -> navn.charAt(0) == "B"); //fjerner navn som starter med B
        System.out.println(liste11.toString()+" "+liste11.omvendtString());


    }
}
