package Kompendie.Hjelpeklasser;

import java.util.*;

public class LenketToveiskø<T> implements Toveiskø<T> {

    private static final class Node<T> {     // en indre nodeklasse
        T verdi;                             // nodens verdi
        Node<T> forrige;                     // peker til forrige node
        Node<T> neste;                       // peker til neste node

        Node(T verdi, Node<T> forrige, Node<T> neste) { // konstruktør
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }
    } // class Node

    private Node<T> start;                 // køens start
    private Node<T> slutt;                 // køens slutt
    private int antall;                    // antall i køen

    public LenketToveiskø() {             // standardkonstruktør
        start = slutt = null;
        antall = 0;
    }

    // her skal resten av metodene inn

    /**
     * Koden for innlegging først i en lenket toveiskø blir slik:
     */
    @Override
    public void leggInnFørst(T verdi) {
        if (antall == 0)   // køen er tom
            start = slutt = new Node<T>(verdi,null,null);
        else
            start = start.forrige = new Node<T>(verdi,null,start);

        antall++;
    }

    @Override
    public void leggInnSist(T verdi) {
        if (antall == 0)   // køen er tom
            start = slutt = new Node<T>(verdi,null,null);
        else
            slutt = slutt.neste = new Node<T>(verdi,slutt,null);

        antall++;

    }

    @Override
    public T kikkFørst() {
        if (antall == 0)  // køen er tom
            throw new NoSuchElementException("Køen er tom!");

        return start.verdi;
    }

    @Override
    public T kikkSist() {
        if (antall == 0)  // køen er tom
            throw new NoSuchElementException("Køen er tom!");

        return slutt.verdi;
    }

    /**
     * Hvis køen ikke er tom, skal første node fjernes. Men først må verdien tas vare på.
     * Dernest flyttes start til neste node. Hvis køen har nøyaktig én node fra før, vil den etterpå bli tom.
     * Dermed må slutt settes til null. Hvis ikke, må forrigepeker i noden som nå blir første node, settes til null
     */
    @Override
    public T taUtFørst() {
        if (antall == 0)  // køen er tom
            throw new NoSuchElementException("Køen er tom!");

        T temp = start.verdi;
        start.verdi = null;
        start = start.neste;

        if (antall == 1) slutt = null;
        else start.forrige = null;

        antall--;
        return temp;
    }

    @Override
    public T taUtSist() {
        if (antall == 0)  // køen er tom
            throw new NoSuchElementException("Køen er tom!");

        T temp = slutt.verdi;
        slutt.verdi = null;
        slutt = slutt.forrige;

        if (antall == 1) start = null;
        else slutt.neste = null;

        antall--;
        return temp;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public void nullstill() {
        Node<T> p = start;

        while (p != null) {
            Node<T> q = p.neste;
            p.neste = p.forrige = null;

            p.verdi = null;
            p = q;
        }
        antall = 0;
        start = slutt = null;
    }

    public String toString() {
        if (antall == 0) {
            return "[]";
        }
        StringBuilder s = new StringBuilder();
        Node<T> p = start;
        s.append('[');
        s.append(p.verdi);
        p = p.neste;

        while (p != null) {
            s.append(", ");
            s.append(p.verdi);
            p = p.neste;
        }
        s.append(']');

        return s.toString();
    }



} // class LenketToveiskø
