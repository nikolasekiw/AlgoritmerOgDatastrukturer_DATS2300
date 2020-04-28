package Kompendie.Hjelpeklasser;

import java.util.NoSuchElementException;

public class LenketKø<T> implements Kø<T> {

    /**
     * Indre nodeklasse som oppretter en node med verdi og peker til neste node slik at nodene blir lenket sammen
     */
    private static final class Node<T> {  // en indre nodeklasse

        private T verdi;        // nodens verdi
        private Node<T> neste;  // peker til neste node

        Node(Node<T> neste) {    // nodekonstruktør
            verdi = null;
            this.neste = neste;
        }
    }   // class Node

    private Node<T> fra, til;  // fra: først i køen, til: etter den siste
    private int antall;        // antall i køen

    private static final int START_STØRRELSE = 8;


    /**
     * Oppretter en sirkulær pekerkjede med så mange noder som størrelse sier og til og fra skal begge peke på samme node
     */
    public LenketKø(int størrelse) {  // konstruktør

        til = fra = new Node<>(null);  // lager den første noden

        Node<T> p = fra;               // en hjelpevariabel
        for (int i = 1; i < størrelse; i++) {
            p = new Node<>(p);           // lager resten av nodene
        }
        fra.neste = p;                 // for å få en sirkel

        antall = 0;                    // ingen verdier foreløpig
    }

    public LenketKø() { // standardkonstruktør
        this(START_STØRRELSE);
    }

    public int antall() {
        return antall;
    }

    public boolean tom() {
        return fra == til;  // eller antall == 0
    }

    @Override
    public void nullstill() {

    }

    /**
     * I leggInn() vil til peke på første ledige node og der legges verdi. Hvis til.neste er lik fra,
     * oppretter vi en ny node mellom til og fra
     */
    @Override
    public boolean leggInn(T verdi) {  // null-verdier skal være tillatt

        til.verdi = verdi;              // legger inn bakerst

        if (til.neste == fra) {          // køen vil bli full - må utvides
            til.neste = new Node<>(fra);  // ny node mellom til og fra
        }

        til = til.neste;                // flytter til
        antall++;                       // øker antallet

        return true;                    // vellykket innlegging
    }

    /**
     * Metoden kikk() skal, hvis køen ikke er tom, returnere køens første verdi
     */
    @Override
    public T kikk() {
        if (tom()) throw new NoSuchElementException("Køen er tom!");
        return fra.verdi;           // returnerer verdien
    }

    /**
     * Metoden taUt skal returnere og fjerne verdien
     */
    @Override
    public T taUt() {
        if (tom()) throw new NoSuchElementException("Køen er tom!");

        T tempverdi = fra.verdi;    // tar vare på verdien i fra
        fra.verdi = null;           // nuller innholdet i fra

        fra = fra.neste;            // flytter fra
        antall--;                   // reduserer antallet

        return tempverdi;           // returnerer verdien
    }


} // class LenketKø
