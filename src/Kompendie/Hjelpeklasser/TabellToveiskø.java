package Kompendie.Hjelpeklasser;

import java.util.NoSuchElementException;

//Denne klassen het egt TabellKø, men skulle forandre på det fordi jeg skulle lage en toveiskø
//Denne heter tabellkø siden det er en kø implementert ved hjelp av en tabell
public class TabellToveiskø<T> implements Kø<T> {
    private T[] a;      // en tabell
    private int fra;    // posisjonen til den første i køen
    private int til;    // posisjonen til første ledige plass

    @SuppressWarnings("unchecked")      // pga. konverteringen: Object[] -> T[]
    public TabellToveiskø(int lengde) {
        if (lengde < 1)
            throw new IllegalArgumentException("Må ha positiv lengde!");

        a = (T[])new Object[lengde];
        fra = til = 0;    // a[fra:til> er tom
    }

    public TabellToveiskø() {  // standardkonstruktør
        this(8);
    }

    /**
     * 4.2.2c --> skal legge verdien på første ledige plass, dvs. posisjon til, øke til med 1 og
     * eventuelt sette den til 0 hvis den har blitt lik a.length. Videre skal tabellen utvides
     * hvis den har blitt full etter innleggingen. Tabellen blir utvidet med en gang hvis en innlegging gjør at den blir full
     */
    @Override
    public boolean leggInn(T verdi){                    // null-verdier skal være tillatt
        a[til] = verdi;                                 // ny verdi bakerst
        til++;                                          // øker til med 1
        if (til == a.length) til = 0;                   // hopper til 0
        if (fra == til) a = utvidTabell(2*a.length);    // sjekker og dobler
        return true;                                    // vellykket innlegging
    }

    //metode til TabellToveiskø
    public void leggInnFørst(T verdi) {
        if (fra == 0) fra = a.length - 1; else fra--;
        a[fra] = verdi;
        if (fra == til) a = utvidTabell(2*a.length);  // dobler tabellen
    }


    /**
     * 4.2.2d --> Utvidelsesmetode som utvider tabellen når den er full. Kan ikke bruke noen av utvidelsesmetodene
     * fra klassen Arrays siden det er nødvendig at kopieringen av den gamle tabellen over i den nye gir riktige
     * verdier på variablene fra og til. Vi lager derfor en egen (privat) utvidelsesmetode for vår klasse:
     */
    private T[] utvidTabell(int lengde) {
        @SuppressWarnings("unchecked")              // pga. konverteringen: Object[] -> T[]
                T[] b = (T[])new Object[lengde];    // ny tabell

        // kopierer intervallet a[fra:a.length> over i b
        System.arraycopy(a,fra,b,0,a.length - fra);

        // kopierer intervallet a[0:fra> over i b
        System.arraycopy(a,0,b,a.length - fra, fra);

        fra = 0; til = a.length;
        return b;
    }

    @Override
    public T kikk() {
        return null;
    }

    //metode til TabellToveiskø
    public T kikkSist() {
        if (fra == til) throw new NoSuchElementException("Køen er tom!");
        if (til == 0) return a[a.length - 1];
        else return a[til - 1];
    }

    /**
     * 4.2.2e --> Metoden taUt() er nå rett frem. Metoden leggInn() sørger for (utvider) at tabellen aldri er full.
     * Det betyr her at den er tom hvis og bare hvis fra og til er like.
     */
    @Override
    public T taUt() {
        if (fra == til) throw new         // sjekker om køen er tom
                NoSuchElementException("Køen er tom!");

        T temp = a[fra];                  // tar vare på den første i køen
        a[fra] = null;                    // nuller innholdet
        fra++;                            // øker fra med 1
        if (fra == a.length) fra = 0;     // hopper til 0
        return temp;                      // returnerer den første
    }

    //metode til TabellToveiskø
    public T taUtSist() {
        if (fra == til) throw new NoSuchElementException("Køen er tom!");
        if (til == 0) til = a.length - 1; else til--;
        T temp = a[til];
        a[til] = null;
        return temp;
    }


    /**
     * 4.2.2a --> returnerer antall elementer i tabellen.
     * Hvis fra < til blir antall lik til - fra
     * Hvis fra > til blir a.length + til - fra
     */
    @Override
    public int antall() {
        //Hvis fra < til = til - fra. Hvis fra > til = a.length + til - fra
        return fra <= til ? til - fra : a.length + til - fra;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }

} // class TabellToveiskø
