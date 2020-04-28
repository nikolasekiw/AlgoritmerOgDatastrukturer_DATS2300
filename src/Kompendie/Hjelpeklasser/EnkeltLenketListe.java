package Kompendie.Hjelpeklasser;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 3.3.2a --> enkeltlenket liste som implementerer grensesnittet til Liste
 */

public class EnkeltLenketListe<T> implements Liste<T> {

    private static final class Node<T>  {     // en «nøstet» klasse
        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste){  // konstruktør
            this.verdi = verdi;
            this.neste = neste;
        }
    }  // Node
    // her skal variabler, konstruktører og metoder komme

    private Node<T> hode, hale;         // referanse til første node i listen
    private int antall;           // antall verdier/noder i listen

    public EnkeltLenketListe() {  // standardkonstruktør
        hode = null;               // hode er null
        antall = 0;                // ingen verdier - listen er tom
    }


    public boolean leggInn(T verdi)   // verdi legges bakerst
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        if (antall == 0)  hode = hale = new Node<>(verdi, null);  // tom liste
        else hale = hale.neste = new Node<>(verdi, null);         // legges bakerst

        antall++;                  // en mer i listen
        return true;               // vellykket innlegging
    }


    public void leggInn(int indeks, T verdi)    // verdi til posisjon indeks
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, true);  // Se Liste, true: indeks = antall er lovlig

        if (indeks == 0)                     // ny verdi skal ligge først
        {
            hode = new Node<>(verdi, hode);    // legges først
            if (antall == 0) hale = hode;      // hode og hale går til samme node
        }
        else if (indeks == antall)           // ny verdi skal ligge bakerst
        {
            hale = hale.neste = new Node<>(verdi, null);  // legges bakerst
        }
        else {
            Node<T> p = hode;                  // p flyttes indeks - 1 ganger
            for (int i = 1; i < indeks; i++) p = p.neste;

            p.neste = new Node<>(verdi, p.neste);  // verdi settes inn i listen
        }

        antall++;                            // listen har fått en ny verdi
    }

    @Override
    public boolean inneholder(T verdi) {
        return false;
    }

    private Node<T> finnNode(int indeks) {
        Node<T> p = hode;
        for (int i = 0; i < indeks; i++) p = p.neste;
        return p;
    }

    public T hent(int indeks) {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        return 0;
    }

    public T oppdater(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig

        Node<T> p = finnNode(indeks);
        T gammelVerdi = p.verdi;

        p.verdi = verdi;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        return false;
    }

    public T fjern(int indeks) {
        indeksKontroll(indeks, false);  // Se Liste, false: indeks = antall er ulovlig

        T temp;                              // hjelpevariabel

        if (indeks == 0){                     // skal første verdi fjernes?
            temp = hode.verdi;                 // tar vare på verdien som skal fjernes
            hode = hode.neste;                 // hode flyttes til neste node
            if (antall == 1) hale = null;      // det var kun en verdi i listen
        }
        else {
            Node<T> p = finnNode(indeks - 1);  // p er noden foran den som skal fjernes
            Node<T> q = p.neste;               // q skal fjernes
            temp = q.verdi;                    // tar vare på verdien som skal fjernes

            if (q == hale) hale = p;           // q er siste node
            p.neste = q.neste;                 // "hopper over" q
        }

        antall--;                            // reduserer antallet
        return temp;                         // returner fjernet verdi
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * 3.3.4a
     */
    private class EnkeltLenketListeIterator implements Iterator<T> {
        private Node<T> p = hode;         // p starter på den første i listen
        private boolean fjernOK = false;  // blir sann når next() kalles

        // metodene hasNext(), next() og remove() skal inn her

        /**
         * 3.3.4b
         */
        public boolean hasNext() {
            return p != null;  // p er ute av listen hvis den har blitt null
        }

        /**
         * 3.3.4c
         */
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("Ingen verdier!");

            fjernOK = true;            // nå kan remove() kalles
            T denneVerdi = p.verdi;    // tar vare på verdien i p
            p = p.neste;               // flytter p til den neste noden

            return denneVerdi;         // returnerer verdien
        }

        /**
         * 3.3.4d
         */
        public void remove() {
            if (!fjernOK) throw new IllegalStateException("Ulovlig tilstand!");

            fjernOK = false;               // remove() kan ikke kalles på nytt
            Node<T> q = hode;              // hjelpevariabel

            if (hode.neste == p) {          // skal den første fjernes?
                hode = hode.neste;           // den første fjernes
                if (p == null) hale = null;  // dette var den eneste noden
            }
            else {
                Node<T> r = hode;            // må finne forgjengeren
                // til forgjengeren til p
                while (r.neste.neste != p) {
                    r = r.neste;               // flytter r
                }

                q = r.neste;                 // det er q som skal fjernes
                r.neste = p;                 // "hopper" over q
                if (p == null) hale = r;     // q var den siste
            }

            q.verdi = null;                // nuller verdien i noden
            q.neste = null;                // nuller nestereferansen

            antall--;                      // en node mindre i listen
        }

        public Iterator<T> iterator() {
            return new EnkeltLenketListeIterator();
        }

    } // class EnkeltLenketListeIterator


}

