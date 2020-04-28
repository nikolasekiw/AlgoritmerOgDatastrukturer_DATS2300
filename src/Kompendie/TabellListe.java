package Kompendie;

import Kompendie.Hjelpeklasser.Liste;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class TabellListe<T> implements Liste<T> {
    private T[] a;
    private int antall;
    private int endringer; //ny variabel

    /**
     * 3.2.2b
     */
    // konstruktører og metoder kommer her
    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse) {      // konstruktør
        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe() {                   // standardkonstruktør
        this(10);                             // startstørrelse på 10
    }

    /**
     * 3.2.2c
     */
    //String[] navn = {"Per", "Kari", "Ole", "Azra"};
    //Liste<String> liste = new TabellListe<>(navn);

    /**
     * 3.2.2d
     */
    public TabellListe(T[] b){                    // en T-tabell som parameter
        this(b.length);                            // kaller den andre konstruktøren
        for (T verdi : b) {
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }

    /**
     * 3.2.2e
     */
    public int antall() {
        return antall;          // returnerer antallet
    }

    public boolean tom() {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    /**
     * 3.2.2f
     */
    public T hent(int indeks) {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }

    /**
     * 3.2.2g
     */
    public int indeksTil(T verdi) {
        for (int i = 0; i < antall; i++) {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    /**
     * 3.2.3b
     */
    public boolean leggInn(T verdi) { // inn bakerst
        Objects.requireNonNull(verdi, "null er ulovlig!");

        if (antall == a.length) { // En full tabell utvides med 50%
            a = Arrays.copyOf(a,(3*antall)/2 + 1);
        }

        a[antall++] = verdi;    // setter inn ny verdi
        return true;            // vellykket innlegging
    }

    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig!");
        indeksKontroll(indeks, true);  // true: indeks = antall er lovlig

        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);

        // rydder plass til den nye verdien
        System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

        a[indeks] = verdi;     // setter inn ny verdi
        antall++;              // vellykket innlegging
    }

    /**
     * 3.2.3c
     */
    public T oppdater(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig!");
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig

        T gammelverdi = a[indeks];      // tar vare på den gamle verdien
        a[indeks] = verdi;              // oppdaterer
        return gammelverdi;             // returnerer den gamle verdien
    }

    public T fjern(int indeks) {
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig
        T verdi = a[indeks];

        antall--; // sletter ved å flytte verdier mot venstre
        System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
        a[antall] = null;   // tilrettelegger for "søppeltømming"

        return verdi;
    }

    /**
     * 3.2.3 --> Oppgaver
     */
    public boolean fjern(T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi)) {
                antall--;
                System.arraycopy(a, i + 1, a, i, antall - i);

                a[antall] = null;

                return true;
            }
        }
        return false;
    }

    public void nullstill() {
        if (a.length > 10)
            a = (T[])new Object[10];
        else
            for (int i = 0; i < antall; i++) a[i] = null;

        antall = 0;
    }

    /**
     * 3.2.4a
     */

    // Skal ligge som en indre klasse i class TabellListe
    private class TabellListeIterator implements Iterator<T> {
        private int denne = 0;       // instansvariabel
        private boolean fjernOk = false;
        private int iteratorendringer = endringer; //ny variabel

        public boolean hasNext() {    // sjekker om det er flere igjen
            return denne < antall;     // sjekker verdien til denne
        }

        public T next()  {            // returnerer aktuell verdi
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
            return a[denne++]; // a[denne] returneres før denne++
        }

        /**
         * 3.2.4c
         */
        /*private boolean fjernOK = false;   // ny instansvariabel i TabellListeIterator

        public T next()                    // ny versjon
        {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

            T denneVerdi = a[denne];   // henter aktuell verdi
            denne++;                   // flytter indeksen
            fjernOK = true;            // nå kan remove() kalles

            return denneVerdi;         // returnerer verdien
        }

        public void remove()         // ny versjon
        {
            if (!fjernOK) throw
                    new IllegalStateException("Ulovlig tilstand!");

            fjernOK = false;           // remove() kan ikke kalles på nytt

            // verdien i denne - 1 skal fjernes da den ble returnert i siste kall
            // på next(), verdiene fra og med denne flyttes derfor en mot venstre
            antall--;           // en verdi vil bli fjernet
            denne--;            // denne må flyttes til venstre

            System.arraycopy(a, denne + 1, a, denne, antall - denne);  // tetter igjen
            a[antall] = null;   // verdien som lå lengst til høyre nulles
        }*/
    }  // TabellListeIterator

    /**
     * 3.2.4b
     */
    public Iterator<T> iterator() {
        return new TabellListeIterator();
    }




}
