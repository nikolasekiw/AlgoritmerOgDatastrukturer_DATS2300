package Kompendie.Hjelpeklasser;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TabellListe<T> implements Liste<T> {
    private T[] a;
    private int antall;

    // konstruktører og metoder kommer her

    @SuppressWarnings("unchecked")          // pga. konverteringen: Object[] -> T[]
    public TabellListe(int størrelse) {     // konstruktør

        a = (T[])new Object[størrelse];       // oppretter tabellen
        antall = 0;                           // foreløpig ingen verdier
    }

    public TabellListe(){                    // standardkonstruktør
        this(10);                             // startstørrelse på 10
    }

    public TabellListe(T[] b) {                  // en T-tabell som parameter
        this(b.length);                            // kaller den andre konstruktøren

        for (T verdi : b){
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }

    public int antall(){
        return antall;          // returnerer antallet
    }

    public boolean tom() {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    @Override
    public void nullstill() {
        if (a.length > 10)
            a = (T[])new Object[10];
        else
            for (int i = 0; i < antall; i++) a[i] = null;

        antall = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public T hent(int indeks) {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }

    public int indeksTil(T verdi) {
        for (int i = 0; i < antall; i++) {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        return null;
    }

    @Override
    public boolean fjern(T verdi) {

        for(int i = 0; i < antall; i++){
            if(verdi.equals(a[i])){
                antall--;
                System.arraycopy(a, i+1, a, i, antall-1);
            }
        }
        return true;
    }

    @Override
    public T fjern(int indeks) {
        return null;
    }

    @Override
    public boolean leggInn(T verdi) {
        return false;
    }

    @Override
    public void leggInn(int indeks, T verdi) {

    }

    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public String toString(){
        if(antall == 0){
            return "[]";
        }

        StringBuilder s = new StringBuilder();
        s.append('[').append(a[0]);

        for (int i = 1; i < antall; i++) {
            s.append(',').append(' ').append(a[i]);
        }
        s.append(']');

        return s.toString();
    }

    private class TabellListeIterator implements Iterator<T> {
        private int denne = 0;       // instansvariabel

        public boolean hasNext(){     // sjekker om det er flere igjen
            return denne < antall;     // sjekker verdien til denne
        }

        public T next()  {            // returnerer aktuell verdi
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");
            return a[denne++]; // a[denne] returneres før denne++
        }
        public Iterator<T> iterator() {
            return new TabellListeIterator();
        }
    }  // TabellListeIterator

}
