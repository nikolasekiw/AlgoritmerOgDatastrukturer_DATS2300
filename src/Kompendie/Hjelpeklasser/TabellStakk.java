package Kompendie.Hjelpeklasser;

import java.util.*;

/**
 * 4.1.2a --> klasse TabellStakk
 */
public class TabellStakk<T> implements Stakk<T>
{
    private T[] a;                     // en T-tabell
    private int antall;                // antall verdier på stakken

    public TabellStakk()               // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked")     // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde)     // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[])new Object[lengde];     // oppretter tabellen
        antall = 0;                      // stakken er tom
    }

    /**
     * 4.1.2b --> hvis tabellen er full, utvides den til dobbel størrelse med copyOf
     */
    @Override
    public void leggInn(T verdi) {
        if (antall == a.length)
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2*antall);   // dobler

        a[antall++] = verdi;
    }

    /**
     * 4.1.2c
     */
    @Override
    public T kikk() {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall-1];    // returnerer den øverste verdien, altså den siste (som ble lagt inn, siste indeksen)
    }

    @Override
    public T taUt() {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--;             // reduserer antallet

        T temp = a[antall];   // tar var på det øverste objektet
        a[antall] = null;     // tilrettelegger for resirkulering

        return temp;          // returnerer den øverste verdien
    }

    /**
     * 4.1.2d
     */
    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    /**
     * 4.1.2 --> Oppgave 1
     */
    @Override
    public void nullstill() {
        for (int i = 0; i < antall; i++)
            a[i] = null;
            antall = 0;
    }

    /**
     * 4.1.2 --> Oppgave 2
     */
    public String toString(){ //bruker string joiner
        StringJoiner s = new StringJoiner(", ", "[", "]");
        for (int i = antall - 1; i >= 0; i--)
            s.add(a[i] == null ? "null" : a[i].toString());
        return s.toString();
    }

    /**
     * 4.1.2 --> Oppgave 3
     */

    public static <T> void snu(Stakk<T> A){

        Stakk<T> C = new TabellStakk<>();
        Stakk<T> B = new TabellStakk<>();

        while (!A.tom()) B.leggInn(A.taUt());  // verdiene flyttes fra A til B
        while (!B.tom()) C.leggInn(B.taUt());  // verdiene flyttes fra B til C
        while (!C.tom()) A.leggInn(C.taUt());  // verdiene flyttes fra C til A
    }

    /**
     * 4.1.2 --> Oppgave 4
     */

    public static <T> void kopier(Stakk<T> A, Stakk<T> B){

        Stakk<T> C = new TabellStakk<>();
        while (!A.tom()) C.leggInn(A.taUt());
        while (!C.tom()){
            T t = C.taUt();
            B.leggInn(t);
            A.leggInn(t);
        }
    }

    /**
     * 4.1.2 --> Oppgave 5
     */

    public static <T> void snu2(Stakk<T> A) {
        Stakk<T> B = new TabellStakk<T>();
        int n = A.antall() - 1;

        while (n > 0)
        {
            T temp = A.taUt();
            for (int j = 0; j < n; j++) B.leggInn(A.taUt());
            A.leggInn(temp);
            while (!B.tom()) A.leggInn(B.taUt());
            n--;
        }
    }

    /**
     * 4.1.2 --> Oppgave 6
     */

    public static <T> void kopier2(Stakk<T> A, Stakk<T> B) {
        int n = A.antall();

        while (n > 0) {
            for (int j = 0; j < n; j++) B.leggInn(A.taUt());
            T temp = B.kikk();
            for (int j = 0; j < n; j++) A.leggInn(B.taUt());
            B.leggInn(temp);
            n--;
        }
    }

    /**
     * 4.1.2 --> Oppgave 7
     */
    // sorterer slik at den minste kommer øverst på stakken
    public static <T> void sorter(Stakk<T> A, Comparator<T> c) {

        Stakk<T> B = new TabellStakk<T>();
        T temp; int n = 0;

        while (!A.tom()) {
            temp = A.taUt();
            n = 0;
            while (!B.tom() && c.compare(temp,B.kikk()) < 0) {
                n++; A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            for (int i = 0; i < n; i++) B.leggInn(A.taUt());
        }
        while (!B.tom()) A.leggInn(B.taUt());
    }

    /**
     * 4.2.2 --> 2a - snur rekkefølgen i en kø ved hjelp av to hjelpekøer
     * Lag metoden public static <T> void snu(Kø<T> A). Den skal snu rekkefølgen av objektene i køen A.
     * Bruk to hjelpekøer. Parametertypen til A er Kø<T>. Da er det kun metodene i grensesnitt Kø<T> som kan brukes.
     */
    public static <T> void snu(Kø<T> A) {
        Kø<T> B = new TabellToveiskø<T>();
        Kø<T> C = new TabellToveiskø<T>();

        while (!A.tom())
        {
            while (!B.tom()) C.leggInn(B.taUt());
            B.leggInn(A.taUt());
            while (!C.tom()) B.leggInn(C.taUt());
        }
        while (!B.tom()) A.leggInn(B.taUt());
    }

    /**
     * 4.2.2 --> Oppgave 2b - snur rekkefølgen i en kø ved hjelp av en hjelpekø og noen hjelpevariabler
     */

    public static <T> void snu2(Kø<T> A) {
        Kø<T> B = new TabellToveiskø<T>();
        int n = A.antall() - 1;

        while (n >= 0)
        {
            for (int i = 0; i < n; i++) A.leggInn(A.taUt());
            B.leggInn(A.taUt());
            n--;
        }

        while (!B.tom()) A.leggInn(B.taUt());
    }

    /**
     * 4.2.2 --> Oppgave 2c - snur rekkefølgen i en kø ved hjelp av
     */

    public static <T> void snu3(Kø<T> A) {
        int i = 0, j = A.antall() - 1;

        while (i < j) bytt(A, i++, j--);
    }


    /**
     * Lag public static <T> void bytt(Kø<T> kø, int indeks1, int indeks2). Den skal bytte verdiene på de to
     * plassene indeks1 og indeks2. Det skal løses kun ved hjelp av metodene i Kø (og eventuelle hjelpevariabler)
     * og uten hjelpestrukturer. Anta at køen inneholder: Per, Kari, Ole, Åse og Elin, dvs. Per først i køen og
     * Elin sist i køen. Da skal metodekallet bytt(kø, 0, 4) føre til at køen blir lik: Elin, Kari, Ole, Åse og Per.
     * Dvs. den første i køen (indeks 0) har byttet plass med den siste i køen (indeks 4). De øvrige står på samme
     * plass som før. Metoden kan testes vha. klassen TabellKø.
     */
    public static <T> void bytt(Kø<T> kø, int indeks1, int indeks2) {
        if (indeks2 < indeks1) // bytter om hvis dette er sant
        {
            int indeks = indeks1;
            indeks1 = indeks2;
            indeks2 = indeks;
        }

        // nå er indeks1 <= indeks2

        if (indeks1 < 0 || indeks2 >= kø.antall())
            throw new IndexOutOfBoundsException("Ulovlig indeks!");

        if (indeks1 == indeks2) return;  // ingen bytting

        int n = kø.antall();

        for (int i = 0; i < indeks1; i++) {
            kø.leggInn(kø.taUt());  // finner indeks1
        }

        T verdi = kø.taUt();      // tar ut den som var på indeks1

        for (int i = indeks1 + 1; i < indeks2; i++) {
            kø.leggInn(kø.taUt());  // finner indeks2
        }

        kø.leggInn(verdi);        // legger inn bakerst
        verdi = kø.taUt();        // tar ut den som var på indeks2

        for (int i = indeks2 - indeks1 + 1; i < n; i++) {
            kø.leggInn(kø.taUt());  // finner indeks1 på nytt
        }

        kø.leggInn(verdi);        // legger inn bakerst

        for (int i = indeks1 + 1; i < n; i++) {
            kø.leggInn(kø.taUt());  // flytter køen slik den var
        }
    }



}  // class TabellStakk
