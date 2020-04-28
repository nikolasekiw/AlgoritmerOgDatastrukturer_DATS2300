package Kompendie.Hjelpeklasser;

import java.util.*;

public class LenketStakk<T> implements Stakk<T> {

    private static final class Node<T> {     // en «nøstet» nodeklasse

        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste){   // nodekonstruktør
            this.verdi = verdi;
            this.neste = neste;
        }
    } // class Node

    private Node<T> hode;             // stakkens topp
    private int antall;               // antall på stakken

    public LenketStakk(){              // konstruktør
        hode = null;
        antall = 0;
    }

    // Her står de andre metodene fra grensesnittet Stakk<T>

    @Override
    public void leggInn(T verdi) {
        hode = new Node<>(verdi,hode);    // verdi legges først
        antall++;                         // antall økes med 1
    }

    @Override
    public T kikk() {
        if (antall == 0)
            throw new NoSuchElementException("Stakken er tom!");
        return hode.verdi;
    }

    @Override
    public T taUt() {
        if (antall == 0)
            throw new NoSuchElementException("Stakken er tom!");

        T temp = hode.verdi;
        hode = hode.neste;
        antall--;

        return temp;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public void nullstill() {
        hode = null;
        antall = 0;
    }

    @Override
    public String toString() {
        if (tom()) return "[]";

        StringBuilder s = new StringBuilder();

        Node<T> p = hode;
        s.append('['); s.append(p.verdi);

        p = p.neste;

        while (p != null) {
            s.append(','); s.append(' '); s.append(p.verdi);
            p = p.neste;
        }
        s.append(']');

        return s.toString();
    }

}  // class LenketStakk
