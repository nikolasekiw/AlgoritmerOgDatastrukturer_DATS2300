package Kompendie.Hjelpeklasser;

import Kompendie.Eksempelklasser.Komparator;

import java.util.*;

public class Tabell { //Samleklasse for tabellmetoder

    /**
     * 1.2.2a --> denne klassen inneholder bare metoder som arbeider med tabeller
     */

    private Tabell() {
    } //privat standardkonstruktør - hindrer instansiering

    public static void bytt2(int[] a, int i, int j) { //returnerer ny tabell hver gang den kalles
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm5(int n) {       // en effektiv versjon
        Random r = new Random();                // en randomgenerator
        int[] a = new int[n];                   // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);           // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--) {                // løkke som går n - 1 ganger
            int i = r.nextInt(k + 1);      // en tilfeldig tall fra 0 til k
            bytt(a, k, i); // bytter om
        }
        return a;                               // permutasjonen returneres
    }

    public static void randPerm6(int[] a) {      //Denne omstokker om på verdiene i tabellen a
        Random r = new Random();                // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);   // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    public static int maks7(int[] a, int fra, int til) {

        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;                            // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];                 // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                          // indeks til største verdi oppdateres
                maksverdi = a[m];               // største verdi oppdateres
            }
        }
        return m;                               // posisjonen til største verdi i a[fra:til>
    }

    public static int maks8(int[] a) {           // bruker hele tabellen
        return maks(a, 0, a.length);          // kaller metoden over
    }

    /**
     * Versjon 1 av maks-metoden (1.1.2)
     * Her gjør man oppslag i 2 tabeller, tar teknisk sett lenger tid
     */

    public static int maks1(int[] a) { // a er en heltallstabell

        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        int m = 0;                              // indeks til foreløpig største verdi

        for (int i = 1; i < a.length; i++) {    // obs: starter med i = 1
            if (a[i] > a[m]) {                  //indejsen oppdateres
                m = i;
            }
        }
        return m;
    }

    /**
     * (1.1.3) --> oppg 6
     */

    public static long fak(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n < 0");
        long fak = 1;

        for (int i = 2; i <= n; i++) fak *= i;

        return fak;
    }

    /**
     * Versjon 2 av maks-metoden (1.1.4)
     */

    public static int maks2(int[] a) {   // versjon 2 av maks-metoden

        int m = 0;                      // indeks til største verdi
        int maksverdi = a[0];           // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i] > maksverdi) {
                maksverdi = a[i];       // største verdi oppdateres
                m = i;                  // indeks til største verdi oppdateres
            }
        return m;                       // returnerer indeks/posisjonen til største verdi
    }

    //I gjennomsnitt vil sammenligningen/if-setningen bare være sann i noen få tilfeller, og derfor er denne koden mer effektiv.
    //     * 1 tabelloperasjon istedenfor 2

    /**
     * Versjon 3 av maks-metoden (1.1.5)
     * //det som er alleredes med denne max metoden er at her får jeg vite største tallet og ikke bare plasseringen
     */

    public static int maks3(int[] a) {

        int sist = a.length - 1;        // siste posisjon i tabellet
        int m = 0;                      // indeks til største verdi
        int maksverdi = a[0];           // største verdi
        int temp = a[sist];             // tar vare på siste verdi
        a[sist] = 0x7fffffff;           // legger tallet 2147483647 sist

        for (int i = 0; ; i++) {        // i starter med 0
            if (a[i] >= maksverdi) {    // denne blir sann til slutt
                if (i == sist) {        // sjekker om vi er ferdige
                    a[sist] = temp;     // legger siste verdi tilbake
                    return temp > maksverdi ?   // er siste størst?
                            sist : m;
                } else {
                    maksverdi = a[i];   // maksverdi oppdateres
                    a[sist] = maksverdi;
                    m = i; // m oppdateres
                }
            }
        }
    }
    /*
    Her tas det i bruk vektpost som er største verdien av int slik at vi er sikre på at siste verdien er sann og at den har kommet til slutten.
    Denne utfører færre operasjoner ettersom a < a.length har forsvunnet i for-løkka.
    Man bruker vaktpost eller stoppverdi for å signalisere at vi har nådd slutten på noe.
     */

    /**
     * Maks-test metode (1.1.7a)
     */

    public static void makstest() {
        int[] a = {8, 3, 5, 7, 9, 6, 10, 2, 1, 4}; // maksverdien 10 er i posisjon 6

        if (maks1(a) != 6) { // kaller maks-metoden
            System.out.printf("Kodefeil : gir feil posisjon for maksverdien");
        }

        a = new int[0];
        boolean unntak = false;

        try {
            maks1(a);
        } catch (Exception e) {
            unntak = true;
            if (!(e instanceof NoSuchElementException)) {
                System.out.println("Kodefeil : Feil unntak for en tom tabell");
            }
            if (!unntak) {
                System.out.println("Kodefeil : Mangler unntak for en tom tabell");
            }
        }
    }

    /**
     * (1.1.7) --> oppg 2
     * En utvidet versjon av makstest
     */

    public static void makstest2() {
        int[] a = { 8, 3, 5, 7, 9, 6, 10, 2, 1, 4 };  // 10 er i posisjon 6

        int antallfeil = 0;

        if (maks(a) != 6) // kaller maks-metoden
        {
            System.out.println("Test 1 - feil posisjon!");
            antallfeil++;
        }

        a = new int[] { 10, 9, 8, 7, 6 };

        if (maks(a) != 0) // kaller maks-metoden
        {
            System.out.println("Test 2 - feil posisjon!");
            antallfeil++;
        }

        a = new int[] { 1, 2, 3, 4, 5 };

        if (maks(a) != 4) // kaller maks-metoden
        {
            System.out.println("Test 3 - feil posisjon!");
            antallfeil++;
        }

        a = new int[] { 2, 3, 3, 5, 3, 5, 4 };

        if (maks(a) != 3) // kaller maks-metoden
        {
            System.out.println("Test 4 - feil posisjon!");
            antallfeil++;
        }

        a = new int[]{ 2 };

        if (maks(a) != 0) // kaller maks-metoden
        {
            System.out.println("Test 5 - feil posisjon!");
            antallfeil++;
        }

        a = new int[] { 1, 2 };

        if (maks(a) != 1) // kaller maks-metoden
        {
            System.out.println("Test 6 - feil posisjon!");
            antallfeil++;
        }

        a = new int[] { 2, 1 };

        if (maks(a) != 0) // kaller maks-metoden
        {
            System.out.println("Test 7 - feil posisjon!");
            antallfeil++;
        }

        a = new int[] { -5, -5 };

        if (maks(a) != 0) // kaller maks-metoden
        {
            System.out.println("Test 8 - feil posisjon!");
            antallfeil++;
        }

        a = new int[0];  // en tom tabell
        boolean unntak = false;

        try
        {
            maks(a);  // kaller maks-metoden
        } catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException))
            {
                System.out.println("Kaster feil unntak for en tom tabell!");
                antallfeil++;
            }
        }

        if (!unntak)
        {
            System.out.println("Det skal kastes unntak for en tom tabell!");
            antallfeil++;
        }

        a = null;
        unntak = false;
        try
        {
            maks(a);  // kaller maks-metoden
        } catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof NullPointerException))
            {
                System.out.println("Kaster feil unntak for en null-tabell!");
                antallfeil++;
            }
        }

        if (!unntak)
        {
            System.out.println("Det skal kastes unntak for en null-tabell!");
            antallfeil++;
        }

        System.out.println("Antall feil: " + antallfeil);
    }

    /**
     * OptionalInt maks (1.1.7b)
     */

    public static OptionalInt maks4(int[] a) { // indeks til største verdi

        if (a.length < 1) { // en konstruksjonsmetode
            return OptionalInt.empty();
        }

        int m = 0, maksverdi = a[0]; // startindeks og verdi

        for (int i = 1; i < a.length; i++) { // starter med i = 1
            if (a[i] > maksverdi) {
                m = i;
                maksverdi = a[i]; // oppdaterer
            }
        }
        return OptionalInt.of(m); // en konstruksjonsmetode
    }

    /**
     * RandPerm metode som ikke virker fordi vi fortsatt kan få gjentagelden tall. (1.1.8a)
     */

    public static int[] randPerm1(int n) {           // en versjon som ikke virker

        Random r = new Random();                    // en randomgenerator
        int[] a = new int[n];                       // en tabell med plass til n tall

        for (int i=0;i<n;i++){
            a[i] = r.nextInt(n) + 1;                // tabellen fylles med tall
        }
        return a;                                   // tabellen returneres
    }

    /**
     * Denne RandPerm metoden funker, men er ikke effektiv (1.1.8b)
     */

    public static int[] randPerm2(int n) {       // virker, men er svært ineffektiv
        Random r = new Random();                // en randomgenerator
        int[] a = new int[n];                   // en tabell med plass til n tall

        for (int i = 0; i < n; ) {              // vi skal legge inn n tall
            int k = r.nextInt(n) + 1;           // trekker et nytt tall k
            int j = 0;

            for (; j < i; j++) {                // leter i intervallet a[0:i>
                if (a[j] == k) break;           // stopper hvis vi har k fra før
                if (i == j) a[i++] = k;         // legger inn k og øker i
            }
        }
        return a;                               // tabellen returneres
    }

    /**
     * Denne RandPerm metoden virker, men er også inneffektiv (1.1.8c)
     */

    public static int[] randPerm3(int n) {       // virker, men er ineffektiv

        Random r = new Random();                // en randomgenerator
        int[] a = new int[n];                   // en tabell med plass til n tall
        boolean[] har = new boolean[n];         // en boolsk tabell

        for (int i=0;i<n;){                     // vi skal legge inn n tall
            int k = r.nextInt(n);               // trekker en indeks k
            if (har[k] == false){               // sjekker
                har[k] = true;                  // oppdaterer den boolske tabellen
                a[i++] = k + 1;                 //leggerinnk+1ia
            }
        }
        return a; // tabellen returneres
    }

    /**
     * Metode for plassbytting (1.1.8d)
     */

    public static void bytt(int[] a, int i, int j) { //returnerer ny tabell hver gang den kalles
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Denne RandPerm metoden er effektiv (orden n) (1.1.8e)
     * Denne lager ny tabell hver gang den kalles
     */

    public static int[] randPerm4(int n){       // en effektiv versjon
        Random r = new Random();                // en randomgenerator
        int[] a = new int[n];                   // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);           // legger inn tallene 1, 2, . , n

        for (int k=n-1;k>0;k--){                // løkke som går n - 1 ganger
            int i = r.nextInt(k+1);      // en tilfeldig tall fra 0 til k
            bytt(a,k,i); // bytter om
        }
        return a;                               // permutasjonen returneres
    }

    /**
     * Denne randPerm-metoden omstokker om på verdiene i tabellen a (som vi allerede har) (1.1.8f)
     */

    public static void randPerm5(int[] a){      //Denne omstokker om på verdiene i tabellen a
        Random r = new Random();                // en randomgenerator

        for (int k=a.length-1;k>0;k--) {
            int i = r.nextInt(k + 1);   // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    /**
     * (1.1.9a) --> antallMaks-metoden genererert tilfeldige permutasjoner ved å finne antall tall av den typen i hver permutasjon
     */

    public static int antallMaks(int[] a) {     // teller opp i a
        int antall = 0;                         // antall tall
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {    // går gjennom tabellen a
            if (a[i] > maksverdi) {             // a[i] er større enn største foran
                antall++;                       // har funnet et nytt tall
                maksverdi = a[i];               // oppdaterer maksverdi
            }
        }
        return antall;                          // de som er større enn det største foran
    }

    /**
     * (1.1.10) --> Denne metoden måler de faste kostnadene
     */

    public static int kostnader(int[] a) {      // legges i class Program
        int m = 0;
        for (int i = 1; i < a.length; i++) {}   // en tom blokk
        return m;
    }

    /**
     * (1.2.1b) --> dette er en forbedring fra 1.1.4
     * letingen etter den største verdien skjer kun i tabellintervallet a[fra:til> og ikke i tabellen a
     */

    public static int maks(int[] a, int fra, int til) {

        fratilKontroll(a.length,fra,til);

        int m = fra;                            // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];                 // største verdi i a[fra:til>

        for (int i=fra+1;i<til;i++){
            if (a[i] > maksverdi){
                m = i;                          // indeks til største verdi oppdateres
                maksverdi = a[m];               // største verdi oppdateres
            }
        }
        return m;                               // posisjonen til største verdi i a[fra:til>
    }

    public static int min(int[] a, int fra, int til) {

        fratilKontroll(a.length,fra,til);

        int m = fra;                            // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];                 // største verdi i a[fra:til>

        for (int i=fra+1;i<til;i++){
            if (a[i] < maksverdi){
                m = i;                          // indeks til største verdi oppdateres
                maksverdi = a[m];               // største verdi oppdateres
            }
        }
        return m;                               // posisjonen til største verdi i a[fra:til>
    }

    /**
     * (1.2.1c) --> praktisk å ha denne metoden, en egen maks-metode for å finne den største i en tabell
     */

    public static int maks(int[] a) {           // bruker hele tabellen
        return maks(a, 0, a.length);
    }

    public static int min(int[] a) { //samme som maks1 bare at her finner man min tallet i tabellen

        if (a.length <= 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int m = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[m]) {
                m = i;
            }
        }
        return m;
    }

    /**
     * (1.2.3a) --> Denne metoden tester om det halvåpne tabellintervallet a[fra:til> er lovlig
     */

    public static void fratilKontroll(int tablengde, int fra, int til) {

        if (fra < 0) {                           // fra er negativ
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tablengde) {                   // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");
        }

        if (fra > til) {                         // fra er større enn til
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        //(1.2.3c)
        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }
    }

    /**
     * (1.2.3d) --> denne metoden sjekekr om et lukket tabellintervall a[v:h] er lovlig
     */

    public static void vhKontroll(int tablengde, int v, int h) {

        if (v < 0) {
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }

        if (h >= tablengde) {
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde(" + tablengde + ")");
        }

        if (v > h + 1) {
            throw new IllegalArgumentException("v = " + v + ", h = " + h);
        }
    }

    /**
     * (1.2.4a) --> returnerer en tabell som inneholder posisjonene til største og nest største verdi.
     * Denne funker, men finnes en annen kode som er mer effektiv
     * Her går algoritmen først gjennom tabellen en gang for å finne den største verdien, også en gang til for å
     * finne den nest største verdien.
     */

    public static int[] nestMaks1(int[] a) {                 // legges i class Tabell

        int n = a.length;                                   // tabellens lengde

        if (n < 2) { // må ha minst to verdier!
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = maks(a);                                    // m er posisjonen til tabellens største verdi
        int nm;                                             // nm skal inneholde posisjonen til nest største verdi

        if (m == 0) {                                        // den største ligger først
            nm = maks(a, 1, n);                         // leter i a[1:n>
        } else if (m == n - 1) {                                  // den største ligger bakerst
            nm = maks(a, 0, n - 1);                   // leter i a[0:n-1>
        } else {
            int mv = maks(a, 0, m);                     // leter i a[0:m>
            int mh = maks(a, m + 1, n);                     // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;                   // hvem er størst?
        }

        return new int[]{m, nm};                            // m i posisjon 0 , nm i posisjon 1
    }

    /**
     * Oppgave 5 og 6 (1.2.2)
     */

    public static void skrivln1(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivln1(int[] a) {
        skrivln1(a, 0, a.length);
    }

    public static void skriv(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        if (til - fra > 0) System.out.print(a[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);
    }

    public static void skriv(int[] a) {
        skriv(a, 0, a.length);
    }

    public static void skrivln2(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivln2(int[] a) {
        skrivln2(a, 0, a.length);
    }

    /**
     * Oppgave 7 (1.2.2)
     */

    public static int[] naturligeTall(int n) {
        if (n < 1) throw new
                IllegalArgumentException("n(" + n + ") er mindre enn 1!");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        return a;
    }

    public static int[] heleTall(int fra, int til) {
        if (fra > til) throw new
                IllegalArgumentException("fra(" + fra + ") > til(" + til + ")");

        int[] a = new int[til - fra];
        for (int i = fra; i < til; i++) a[i - fra] = i;
        return a;
    }

    /**
     * (1.2.5a) --> hvis det er en ny størst verdi, vil den tydligere største verdi bli ny nest størst verdi
     * Denne har bare en for-løkke og det betyr at den går gjennom tabellen a bare en gang.
     * Hvis vi bruker en vektpost her blir koden enda mer effektiv (oppg 2)
     * Den er ikke effektiv i de ugunstige tilfellene
     */

    public static int[] nestMaks2(int[] a) {                 // ny versjon

        int n = a.length;                                   // tabellens lengde

        if (n < 2) {                                        // må ha minst to verdier
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = 0; // m er posisjonen til største verdi
        int nm = 1; // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) {
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];                           // største verdi
        int nestmaksverdi = a[nm];                      // nest største verdi

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {
                if (a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi;           // ny nest størst

                    m = i;
                    maksverdi = a[m];                   // ny størst
                }
            } else {
                nm = i;
                nestmaksverdi = a[nm];                  // ny nest størst
            }
        } //for

        return new int[]{m, nm};                        // n i posisjon 0, nm i posisjon 1
    }

    /**
     * (1.2.13a) --> turneringstre, finne ut av nest største verdi
     * Denne er bedre enn 1.2.5a, spesielt i det verste tilfellet.
     * Men testkjøringen viser likevel at denne tar lenger tid
     */

    public static int[] nestMaks(int[] a) {             // en turnering

        int n = a.length;                               // for å forenkle notasjonen

        if (n < 2) {                                    // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");
        }

        int[] b = new int[2 * n];                         // turneringstreet
        System.arraycopy(a, 0, b, n, n);            // legger a bakerst i b

        for (int k = 2 * n - 2; k > 1; k -= 2) {             // lager turneringstreet
            b[k / 2] = Math.max(b[k], b[k + 1]);
        }

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2 * n - 1, k = 2; k < m; k *= 2) {
            int tempverdi = b[k + 1];                     // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) {
                tempverdi = b[k];
                k++;
            }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }
        return new int[]{maksverdi, nestmaksverdi};     // størst og nest størst
    }

    public static void kopier(int[] a, int i, int[] b, int j, int ant) {
        for (int n = i + ant; i < n; ) b[j++] = a[i++];
    }


    /**
     * (1.3.1a) --> snur rekkefølgen på et intervall av verdier
     */

    public static void snu(int[] a, int v, int h) { // snur intervallet a[v:h]

        while (v < h) {
            bytt(a, v++, h--);
        }

    }

    public static void snu(int[] a, int v) { // snur fra og med v og ut tabellen
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a) { // snur hele tabellen
        snu(a, 0, a.length - 1);
    }

    /**
     * (1.3.1b) --> snur om på tabellen?
     * Denne er inneffektiv hvis n er stor, men fordelen er at vi får generert en og en permutasjon.
     * (Mer effektive teknikker i 1.5.5)
     */

    public static boolean nestePermutasjon(int[] a) {

        int i = a.length - 2;                       // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) {            // går mot venstre
            i--;
        }

        if (i < 0) {                                // a = {n, n-1, . . . , 2, 1}
            return false;
        }

        int j = a.length - 1;                       // j starter bakerst
        while (a[j] < a[i]) {                        // stopper når a[j] > a[i]
            j--;
        }

        bytt(a, i, j);                                // bytter og snur
        snu(a, i + 1);

        return true;                                // en ny permutasjon
    }


    /**
     * (1.3.2a) --> teller opp antall inversjoner
     */

    public static int inversjoner(int[] a) {

        int antall = 0;                         // antall inversjoner

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])              // en inversjon siden i < j
                    antall++;
            }
        }
        return antall;
    }

    /**
     * (1.3.4) --> oppg 3
     */

    public static void utvalgssortering(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {        //lengden av tabellen er 5 men i forløkka teller vi 0, 1,2,3,4 så må ta -1 for å komme til 4. Dette må vi gjøre fordi her er det snakk om tall og ikke index.
            bytt(a, i, Tabell.min(a, i, a.length)); // to hjelpemetoder, når denne finner den minste verdien i supertabellen setter den det i subtabellen (før streken i samme tabellen)
            //Hvis vi har 5 tall og index er også 5 så vil det bli en index for mye for da blir det plass til 6 stall, derfor må vi sette length-1
        }
    }

    /**
     * (1.3.4) --> Oppg 5
     */

    public static void utvalgssortering2(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int m = i;             // indeks til den foreløpig minste
            int minverdi = a[i];  // verdien til den foreløpig minste

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minverdi) {
                    minverdi = a[j];  // ny minste verdi
                    m = j;            // indeksen til ny minste verdi
                }
            }
            // bytter om a[i] og a[m]
            int temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }
    }

    /**
     * (1.3.4) --> Oppg 9
     * (Dette prøvde jeg på selv, men er feil, fasiten kommer i metoden under)
     */

    public static void utvalgssortering3(int[] a, int fra, int til) {

        if (fra < 0) {
            throw new IllegalArgumentException("Tabellen er tom!");
        }

        if (fra > til) {
            throw new IllegalArgumentException("Fra kan ikke være større enn til");
        }

        if (fra == til) {
            throw new IllegalArgumentException("Tabellen inneholder bare en verdi");
        }

        if (til > a.length) {
            throw new NullPointerException("Til peker utenfor tabellen");
        }

        for (int i = 0; i < a.length - 1; i++) {
            int m = 1;
            int minverdi = a[i];

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minverdi) {
                    minverdi = a[j];
                    m = j;
                }
            }
            int temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }
    }

    /**
     * (1.3.4) --> Oppg 9
     */

    public static void utvalgssortering4(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < til - 1; i++) {
            bytt(a, i, Tabell.min(a, i, til));  // to hjelpemetoder
        }
    }

    /**
     * (1.3.4) --> Oppg 8
     * Avtagende utvalgssortering
     */

    public static void utvalgssorteringAvtagende(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int m = i;             // indeks til den foreløpig minste
            int maksverdi = a[i];  // verdien til den foreløpig minste

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < maksverdi) {
                    maksverdi = a[j];  // ny minste verdi
                    m = j;            // indeksen til ny minste verdi
                }
            }
            // bytter om a[i] og a[m]
            a[m] = a[i];
            a[i] = maksverdi;
        }
    }

    /**
     * (1.3.2c) --> metode som sjekker naboverdier for å finne ut av om tabellen er sortert.
     * Den er sortert hvis ingen par (x,y) av naboverdier utgjør en inversjon.
     * Sjekker om tabellen er sortert
     */

    public static boolean erSortert(int[] a) { // legges i samleklassen Tabell
        for (int i = 1; i < a.length; i++) {           // starter med i = 1
            if (a[i - 1] > a[i]) return false;    // en inversjon
        }
        return true;
    }

    /**
     * (1.3.5a) --> returnerer verdien til det største tallet (fra venstre)
     * Hvis den ikke finner det den leter etter får vi ut -1
     */

    public static int usortertsøk(int[] a, int verdi) { // tabell og søkeverdi
        for (int i = 0; i < a.length; i++) {             // går gjennom tabellen
            if (verdi == a[i]) return i;                // verdi funnet - har indeks i
        }
        return -1;                                      // verdi ikke funnet
    }

    /**
     * (1.3.5b) --> lineærsøk, ser på en og en tabellverdi. Tabellens siste verdi vil fungeree som vektpost.
     * En verdi som er større enn den, vil ha p = a.length som innsettingspunkt. For alle andre søkeverdier
     * vil den bli en stoppverdi. Legg metoden i samleklassen Tabell.
     */

    public static int lineærsøk(int[] a, int verdi) { // legges i class Tabell
        if (a.length == 0 || verdi > a[a.length - 1]) {
            return -(a.length + 1); // verdi er større enn den største
        }
        int i = 0;
        for (; a[i] < verdi; i++) ; // siste verdi er vaktpost
        return verdi == a[i] ? i : -(i + 1); // sjekker innholdet i a[i]
    }

    /**
     * (1.3.5) --> Oppg 1
     */

    public static int søkUsortert(int[] a, int verdi) {
        int sist = a.length - 1;
        int tmp = a[sist];          // tar vare på den siste
        a[sist] = verdi;            // verdi blir vaktpost

        for (int i = 0; ; i++)      // i < a.length er tatt vekk
            if (verdi == a[i]) {     // dette blir sant før eller senere
                a[sist] = tmp;      // legger den siste tilbake

                if (i == sist) return verdi == tmp ? sist : -1;
                else return i;
            }
    }

    /**
     * (1.3.5) --> Oppg 3
     * lineærsøk bare her starter man å lete motsatt vei, bakerst
     */

    public static int lineærsøkMotsatt(int[] a, int verdi) {
        if (a.length == 0 || verdi < a[0])
            return -1;  // verdi er mindre enn den største

        int i = a.length - 1;
        for (; a[i] > verdi; i--) ;

        return verdi == a[i] ? i : -(i + 2);
    }

    /**
     * (1.3.5) --> Oppg 4
     * lineærsøk med intervaller
     */

    public static int lineærsøkIntervall(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);

        if (fra == til || verdi > a[til - 1])
            return -(til + 1);  // verdi er større enn den største

        int i = 0;
        for (; a[i] < verdi; i++) ;  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    /**
     * (1.3.5) --> Oppgave 5a
     */

    public static int lineærsøk(int[] a, int k, int verdi) {
        if (k < 1)
            throw new IllegalArgumentException("Må ha k > 0!");

        int j = k - 1;
        for (; j < a.length && verdi > a[j]; j += k) ;

        int i = j - k + 1;  // søker i a[j-k+1:j]
        for (; i < a.length && verdi > a[i]; i++) ;

        if (i < a.length && a[i] == verdi) return i;  // funnet
        else return -(i + 1);
    }

    /**
     * (1.3.5) --> Oppgave 5c
     * denne hopper bortover i tabellen istedenfor å sammenligne en og en tabellverdi med verdi
     */

    public static int kvadratrotsøk(int[] a, int verdi) {
        return lineærsøk(a, (int) Math.sqrt(a.length), verdi);
    }

    /**
     * (1.3.5) --> oppgave 6
     */

    public static int[] lineærIntervallsøk(int[] a, int fraverdi, int tilverdi) {
        if (a.length == 0 || fraverdi > a[a.length - 1])
            return new int[0];  // returnerer en tom tabell

        int fra = 0;
        while (a[fra] < fraverdi) fra++;

        int til = a.length;

        if (tilverdi <= a[a.length - 1]) {
            til = fra;
            while (a[til] < tilverdi) til++;
        }

        // intervallet a[fra:til> inneholder de søkte verdiene
        return Arrays.copyOfRange(a, fra, til);
    }

    /**
     * (1.3.6a) --> første versjon av binærsøk
     */

    public static int binærsøk1(int[] a, int fra, int til, int verdi) {

        Tabell.fratilKontroll(a.length, fra, til); // se Programkode 1.2.3 a)
        int v = fra, h = til - 1; // v og h er intervallets endepunkter

        while (v <= h) { // fortsetter så lenge som a[v:h] ikke er tom
            int m = (v + h) / 2; // heltallsdivisjon - finner midten
            int midtverdi = a[m]; // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m; //funnet

            else if (verdi > midtverdi) v = m + 1; // verdi i a[m+1:h]
            else h = m - 1;                             // verdi i a[v:m-1]
        }
        return -(v + 1); // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk12(int[] a, int verdi) {        // søker i hele a
        return binærsøk1(a, 0, a.length, verdi); // bruker metoden over
    }

    /**
     * (1.3.6b) --> 2. versjon av binærsøk
     * Denne tar hensyn til at det kan være flere verdier på den ene siden
     */

    public static int binærsøk2(int[] a, int fra, int til, int verdi) {
        Tabell.fratilKontroll(a.length, fra, til);        // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;       // v og h er intervallets endepunkter

        while (v <= h) {                // fortsetter så lenge som a[v:h] ikke er tom
            int m = (v + h) / 2;        // heltallsdivisjon - finner midten
            int midtverdi = a[m];        // hjelpevariabel for midtverdien

            if (verdi > midtverdi) v = m + 1;       // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;  // verdi i a[v:m-1]
            else return m;                          // funnet
        }
        return -(v + 1);        // ikke funnet, v er relativt innsettingspunkt
    }

    /**
     * (1.3.6c) --> 3. versjon av binærsøk
     * Denne er mest effektiv og funker også bedre når tabellintervallet har like verdier
     */

    public static int binærsøk3(int[] a, int fra, int til, int verdi) {
        Tabell.fratilKontroll(a.length,fra,til); // se Programkode 1.2.3 a)
        int v = fra, h = til - 1; // v og h er intervallets endepunkter

        while(v<h) { //obs.måhav<hherogikkev<=h
            int m = (v + h)/2; // heltallsdivisjon - finner midten
            if (verdi > a[m]) v = m + 1; // verdi må ligge i a[m+1:h]
            else h = m; // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1); // ikke funnet
        else if (verdi == a[v]) return v;           // funnet
        else return -(v + 2);                       //ikke funnet
    }

    /*
    Denne tar også hensyn til hvis det skulle ha søkt etter en verdi som ligger utenfor tabellen.
    Da returnerer den -(v + 2) eller -(v+n)
     */

    /**
     * (1.3.8c) --> sammenligner og forskyver en og en verdi ved hjelp av en index j
     * Den må sjekkes i tilfelle verdi skal legges helt først
     */

    public static void innsettingssortering(int[] a) {
        for (int i=1;i<a.length;i++) {              // starter med i = 1
            int verdi = a[i], j = i - 1;            // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j+1] = a[j]; // sammenligner og flytter
            a[j + 1] = verdi;                       // j + 1 er rett sortert plass
        }
    }

    /**
     * (1.3.8e) --> her bruker vi ombytninger
     */

    public static void innsettingssortering2(int[] a) {
        for (int i=1;i<a.length;i++){           // starter med i = 1
            int temp = a[i]; // hjelpevariabel
            for (int j=i-1;j>=0&&temp<a[j];j--){
                Tabell.bytt(a,j,j+1);
            }
        }
    }

    /**
     * (1.3.8f) --> shell
     * Ved hjelp av denne metoden kan vi sortere en tabell fullstendig
     */

    public static void shell(int[] a, int k) {
        for (int i = k; i < a.length; i+=4) {
            int temp = a[i], j = i-k;
            for (;j >= 0 && temp < a[j]; j -= k){
                a[j + k] = a[j];
                a[j + k] = temp;
            }
        }
    }

    /**
     * (1.3.9a) --> Partisjonering
     */

    public static int parter0(int[] a, int v, int h, int skilleverdi) {

        while (true){               // stopper når v > h
            while (v <= h && a[v] < skilleverdi) v++; // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--; // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--); // bytter om a[v] og a[h]
            else return v; // a[v] er nåden første som ikke er mindre enn skilleverdi

        }
    }

    /**
     * (1.3.9) --> oppgave 1
     */

    // intervallet a[fra:til>
    public static int parter(int[] a, int fra, int til, int skilleverdi) {
        fratilKontroll(a.length, fra, til);
        return parter0(a, fra, til - 1, skilleverdi);
    }

    public static int parter(int[] a, int skilleverdi) {// hele tabellen
        return parter0(a, 0, a.length - 1, skilleverdi);
    }

    /**
     * (1.3.9d) --> finner antall ombytninger
     */

    public static int antallOmbyttinger(int[] a, int s) {
        int antall = 0, m = s-1;
        for (int i = 0 ;i < m; i++)
            if (a[i] > m)
                antall++;
        return antall;

    }

    /**
     * (1.3.9f) --> En vilkårlig tabellverdi, f.eks. a[indeks], kan være skilleverdi i parter0(). To ombyttinger
     * (en før og en etter) får den inn på rett sortert plass:
     */

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h); // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]); // partisjonerer a[v:h − 1]
        bytt(a, pos, h); // bytter for å få skilleverdien på rett plass
        return pos; // returnerer posisjonen til skilleverdien

    }

    /**
     * (1.3.9) -> oppgave 9
     */

    public static int sParter(int[] a, int fra, int til, int indeks) {
        fratilKontroll(a.length, fra, til);

        if (fra == til) throw new
                IllegalArgumentException("Intervallet a[" + fra + ":" + til + "> er tomt!");

        if (indeks < fra || indeks >= til) throw new
                IllegalArgumentException("indeks(" + indeks + ") er utenfor intervallet!");

        return sParter0(a, fra, til - 1, indeks);
    }

    public static int sParter(int[] a, int indeks) {
        if (indeks < 0 || indeks >= a.length) throw new
                IllegalArgumentException("indeks(" + indeks + ") er utenfor tabellen!");

        return sParter0(a, 0, a.length - 1, indeks);
    }

    /**
     * (1.3.9h) --> kvikksortering
     */

    private static void kvikksortering0(int[] a, int v, int h) {    // en privat metode
        if (v >= h) return; // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2); // bruker midtverdien
        kvikksortering0(a, v, k - 1); // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h); // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) {  // a[fra:til>
        fratilKontroll(a.length, fra, til); // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1); // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a) {    // sorterer hele tabellen
        kvikksortering0(a, 0, a.length - 1);
    }

    /**
     * (1.3.9j) --> kvikksøk
     */

    public static int kvikksøk(int[] a, int m) {
        if (m < 0 || m >= a.length)
            throw new IllegalArgumentException("m(" + m + ") er ulovlig!");

        int v = 0, h = a.length - 1; // intervallgrenser

        while (true) {
            int k = sParter0(a,v,h,(v + h)/2);  // se Programkode 1.3.9 f)
            if (m < k)h = k-1;
            else if (m > k)v = k+1;
            else return k;
        }
    }

    /**
     * (1.3.9k) --> vi bruker kvikksøk for å finne medianen
     * Medianen til en samling verdier er den som ville ha havnet på midten etter en sortering.
     * Hvis antallet er odde, er dette veldefinert. Hvis ikke, defineres medianen som
     * gjennomsnittet av de to verdiene på hver side av «midten». Vi kan bruke kvikksøk() til å finne medianen:
     */

    public static double median(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Tom tabell!");

        int k = kvikksøk(a, a.length/2);
        return (a.length & 1) == 0 ? (a[k-1] + a[k])/2.0 : a[k];
    }

    /**
     * (1.3.11a) --> fletting av to enheter, annenhver verdi kommer fra den ene,
     * og annenhver fra den andre. Hvis det er ulikt antall, da må vi feks legge dem bakerst
     */

    public static int[] enkelFletting(int[] a, int[] b) {

        int[] c = new int[a.length + b.length]; // en tabell av rett størrelse
        int i = 0, j = 0, k = 0; // løkkevariabler

        while (i < a.length && j < b.length){
            c[k++] = a[i++]; // først en verdi fra a
            c[k++] = b[j++]; // så en verdi fra b
        }
        // vi må ta med resten
        while (i < a.length)
            c[k++] = a[i++];
        while (j < b.length)
            c[k++] = b[j++];
        return c;
    }

    /**
     * (1.3.11c) --> flettealgoritme som fletter sammen verdier fra flere tabeller i sortert rekkefølge
     */

    public static int flett(int[] a, int m, int[] b, int n, int[] c) {
        int i = 0, j = 0, k = 0;
        while (i < m && j < n)
            c[k++] = a[i] <= b[j]? a[i++] : b[j++];
        //sammenligningen a[i] <= b[j] blir utført  m + n – 1 ganger hvis tallene i a og b er slik at a[i] <= b[j] blir sann/usann annenhver gang

        while (i < m) c[k++] = a[i++]; // tar med resten av a
        while (j < n) c[k++] = b[j++]; // tar med resten av b

        return k; // antallet verdier som er lagt inn i c
    }

    /**
     * (1.3.11d) --> fletter sammen to hele tabeller ved hjelp av flett()
     */

    public static int flett(int[] a, int[] b, int[] c){ // legges i samleklassen Tabell
        return flett(a, a.length, b, b.length, c);
    }

    /**
     * (1.3.11f) --> flettemetode som først starter med 2 tabeller for å sortere dem,
     * så flette disse tabellene sammen og ha det sortert
     */

    private static void flett2(int[] a, int[] b, int fra, int m, int til) {
        int n = m-fra; // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i=0,j=m,k=fra;          // løkkeST0r og indekser

        while (i < n && j < til) {  // fletter b[0:n> og a[m:til> og
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];    // legger resultatet i a[fra:til>
        }
        while (i < n) a[k++] = b[i++]; // tar med resten av b[0:n>
    }

    /**
     * (1.3.11g) --> I denne koden deles a[fra:til> på midten og metoden kalles (rekursjon)
     * først på a[fra:m> og så på a[m:til>. Etterpå vil de være sortert og kan flettes sammen.
     */

    private static void flettesortering(int[] a, int[] b, int fra, int til) {
        if (til - fra <= 1) return; // a[fra:til> har maks ett element
        int m = (fra + til)/2; // midt mellom fra og til

        flettesortering(a,b,fra,m); // sorterer a[fra:m>
        flettesortering(a,b,m,til); // sorterer a[m:til>

        if (a[m-1] > a[m])
            flett2(a,b,fra,m,til); // fletter a[fra:m> og a[m:til>
    }

    /**
     * (1.3.11h) --> denne sorterer en hel tabell
     */

    public static void flettesortering2(int[] a) {
        int[] b = Arrays.copyOf(a, a.length/2); // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length); // kaller metoden over
    }

    /**
     * (1.3.11j) --> La a[0:m> være sortert med ulike verdier. Tilsvarende for b[0:n>.
     * De kan da ses på som to mengder. Vi finner «unionen» ved å flette dem sammen.
     * En verdi som ligger i begge to tas med kun én gang. Flg. metode legger «unionen»
     * i tabellen c og returnerer antallet:
     */

    public static int union(int[] a, int m, int[] b, int n, int[] c) {
        int i = 0, j = 0, k = 0; // indekser for a, b og c
        while (i < m && j < n) {
            if (a[i] < b[j])
                c[k++] = a[i++]; // tar med a[i]
            else if (a[i] == b[j]) {    // a[i] og b[j] er like
                c[k++] = a[i++]; j++;  // tar med a[i], men ikke b[j]
            }
            else c[k++] = b[j++];  // tar med b[j]
        }
        while (i < m) c[k++] = a[i++];  // tar med resten av a[0:m>
        while (j < n) c[k++] = b[j++];  // tar med resten av b[0:n>

        return k;  // antall verdier i unionen
    }

    /**
     * (1.3.11k) --> Metoden union() returnerer antallet.
     * Det er mindre enn m + n hvis a og b har felles verdier.
     * Flg. metode finner «unionen» av hele tabeller:
     */

    public static int union(int[] a, int[] b, int[] c) {
        return union(a, a.length, b, b.length, c);
    }

    /**
     * (1.3.11m) --> Snittet av to mengder er det de har felles.
     * Vi kan finne snittet ved å bruke en fletteteknikk:
     */

    public static int snitt(int[] a, int m, int[] b, int n, int[] c) {
        int i = 0, j = 0, k = 0;    // indekser for a, b og c

        while (i < m && j < n){
            if (a[i] < b[j]) i++;   // hopper over a[i]
            else if (a[i] == b[j]) {    // a[i] og b[j] er like
                c[k++] = a[i++]; j++;    // tar med a[i], men ikke b[j]
            }
            else j++;       // hopper over b[j]
        }
        return k;   // antall i snittet
    }

    public static int snitt(int[] a, int[] b, int[] c) {  // hele tabeller
        return snitt(a, a.length, b, b.length, c);
    }

    /**
     * (1.4.1a) --> maks metode for desimaltall
     */

    public static int maks(double[] a) {       // legges i class Tabell
        int m = 0;  // indeks til største verdi
        double maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i] > maksverdi) {
                maksverdi = a[i];   // største verdi oppdateres
                m = i;              // indeks til største verdi oppdaters
            }
        return m; // returnerer posisjonen til største verdi
    }

    /**
     * (1.4.1b) --> maks metode for strenger
     */

    public static int maks(String[] a) {    // legges i class Tabell
        int m = 0;                  // indeks til største verdi
        String maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];   // største verdi oppdateres
                m = i;              // indeks til største verdi oppdaters
            }
        return m; // returnerer posisjonen til største verdi
    }

    /**
     * (1.4.1) --> Oppgave 2
     */

    public static int maks(char[] c) {
        int m = 0;                    // indeks til "største" tegn
        char maksverdi = c[0];        // "største" tegn

        for (int i = 1; i < c.length; i++) if (c[i] > maksverdi)
        {
            maksverdi = c[i];     // "største" tegn oppdateres
            m = i;                // indeks til "største" tegn oppdaters
        }
        return m;     // returnerer posisjonen til "største" tegn

    } // maks

    /**
     * (1.4.1) --> Oppgave 3
     */

    public static int maks(Integer[] a) {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];           // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi

    } // maks

    /**
     * (1.4.1) --> Oppgave 5
     */

    public static int sammenlign(String s1, String s2) {
        int n1 = s1.length();    // lengden til s1
        int n2 = s2.length();    // lengden til s2

        int n = n1 < n2 ? n1 : n2;    // den minste av n1 og n2

        for (int i = 0; i < n; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) return c1 - c2;
        }
        return n1 - n2;
    }


    /**
     * (1.4.2a) --> definisjon av comparable<T>
     */

    public interface Comparable<T> {    // definert i java.lang
        public int compareTo(T o);
    }

    /**
     * (1.4.2b) --> generisk maks-metode
     */

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;          // indeks til største verdi
        T maksverdi = a[0]; // største verdi

        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i]; // største verdi oppdateres
                m = i;      // indeks til største verdi oppdaters
            }
        return m; // returnerer posisjonen til største verdi
    }

    /**
     * (1.4.2e) --> generisk innsetningssortering
     *
     * Innsettingssorteringen i Programkode 1.3.8 c) kan gjøres generisk ved å
     * bytte temp < a[j] med temp.compareTo(a[j]) < 0:
     */

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) {
        for (int i = 1; i < a.length; i++){ // starter med i = 1
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--)
                a[j+1] = a[j];
                a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    /**
     * (1.4.3d) --> lager tilfeldige integer-tabeller (1.1.8)
     */

    public static void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static Integer[] randPermInteger(int n) {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }

    /**
     * (1.4.6b) --> Skal vi bruke en komparator til å sortere personer etter fornavn istedenfor etter etternavn,
     * må vi lage en sorteringsmetode som benytter en komparator, dvs. en komparatormetode. Det er nok å gjøre
     * noen små endringer i metoden i Programkode 1.4.2 e) (den som sorterer instanser av typen Comparable).
     */

    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c) {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--)
                a[j+1] = a[j];
                a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    /**
     * 1.5.1a) --> eksempel på en enkel rekursiv metode
     */

    public static int ab(int n) {          // n må være et ikke-negativt tall
        if (n == 0) return 1;              // a0 = 1
        else if (n == 1) return 2;         // a1 = 2
        else return 2 * ab(n-1) + 3 * ab(n-2);   // to rekursive kall
    }

    /**
     * 1.5.1b --> eksempel 2 på en rekursiv metode
     */

    public static int tverrsum(int n) {             // n må være >= 0
        if (n < 10) return n;                        // kun ett siffer
        else return tverrsum(n / 10) + (n % 10);     // metoden kalles
    }

    /**
     * 1.5.1c --> eksempel 3 på en rekursiv metode
     */

    public static int euklid(int a, int b) {
        if (b == 0) return a;
        int r = a % b;            // r er resten
        return euklid(b,r);       // rekursivt kall
    }

    /**
     * 1.5.1d --> eksempel 4 på en rekursiv metode
     */

    public static int sum(int n) {      // summen av tallene fra 1 til n
        if (n == 1) return 1;            // summen av 1 er lik 1
        return sum(n - 1) + n;           // summen av de  n – 1 første + n
    }

    /**
     * 1.5.1e --> enda et eksempel av den rekursive sum metoden, bare at her ser vi på summen av de n første verdiene
     */
    public static int sum2(int[] a, int n){   // summen av de n første
        if (n == 1) return a[0];       // summen er verdien selv
        return sum2(a,n-1) + a[n-1];    // summen av de n-1 første + a[n-1]
    }

    /**
     * 1.5.1g --> splitter tabellen i deltabeller (splitter problemer) så summerer hver for seg og legger sammen
     */

    public static int sum(int[] a, int v, int h) {  // intervallet a[v:h]
        if (v == h) return a[v];   // summen av én verdi er verdien selv
        int m = (v + h)/2;         // finner midten
        return sum(a,v,m) + sum(a,m+1,h);  // summen av de to halvdelene
    }

    /**
     * 1.5.1h --> Denne koden er et eksempel på at det ikke alltid er lurt å bruke rekursjon
     * Hvis tallet blir for stort vil den gå i en evig løkke.
     */

    public static int fib(int n) {       // det n-te Fibonacci-tallet
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }

    /**
     * (1.5.1) --> oppgave 1
     * Gjorde om en rekursiv metode til en iterativ metode
     */

    public static int a(int n){
        if (n < 0){
            throw new IllegalArgumentException("N er negativ");
        }
        int x = 0, y = 1, z = 1;

        for(int i = 0; i < n; i++){
            z = 2*y + 3*x;
            x = y;
            y = z;
        }
        return z;
    }

    /**
     * 1.5.1 --> Oppgave 3
     */

    public static int tverrsumOppg(int n){
        int sum = 0;

        while(n > 10){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * 1.5.1 --> Oppgave 4
     */

    public static int sifferrot(int n){

        while(n >= 10){
            n = tverrsum(n);
        }
        return n;
    }

    public static int sifferrot2(int n) {
        n %= 9;
        return n == 0 ? 9 : n;
    }

    /**
     * 1.5.1 --> Oppgave 7
     */

    public static int kvadratsum(int n) {
        if (n == 1) return 1;
        else return kvadratsum(n-1) + n*n;
    }

    // Formel:  n*(n + 1)*(2*n + 1)/6

    /**
     * 1.5.2c
     */

    public static int tverrsum2(int n) {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum2(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

    /**
     * 1.5.4a --> rekursivt binærsøk (denne er mindre effektiv fordi det er mer effektivt å operere med
     * løkker enn kall på metode
     */

    public static int rekursivBinærsøk(int[] a, int v, int h, int verdi) {
        if (v < 0 || h >= a.length)
            throw new IllegalArgumentException("Ulovlig intervall");

        if (h < v) return -(v + 1);     // tomt intervall - ikke funnet

        int m = (v + h)/2;              // finner midten
        int midtverdi = a[m];           // midtverdien

        if (verdi > midtverdi)
            return rekursivBinærsøk(a,m+1,h,verdi);
        else if (verdi < midtverdi)
            return rekursivBinærsøk(a,v,m-1,verdi);
        else
            return m;     // funnet
    }

    public static int rekursivBinærsøk(int[] a, int verdi) {  // leter i hele a
        return rekursivBinærsøk(a,0,a.length-1,verdi);
    }

    /**
     * 1.5.5a
     */

    public static void perm(int[] a, int k) {   // permuterer a[k:a.length>
        if (k == a.length-1) Tabell.skrivln2(a);  // en ny permutasjon
        else
            for (int i = k; i < a.length; i++)
            {
                Tabell.bytt(a,k,i);     // bytter om a[k] og a[i]
                perm(a,k+1);            // permuterer a[k+1:a.length>
                Tabell.bytt(a,k,i);     // bytter tilbake
            }
    }  // perm


    /**
     * 1.5.5d --> en generisk bytt metode
     */

    public static <T> void perm(T[] a, int k, Oppgave<T[]> o){
        if (k == a.length-1) o.utførOppgave(a);   // en ny permutasjon
        else
            for (int i = k; i < a.length; i++)
            {
                Tabell.bytt(a,k,i);     // bytter om a[k] og a[i]
                perm(a,k+1,o);          // permuterer a[k+1:a.length>
                Tabell.bytt(a,k,i);     // bytter tilbake
            }
    }  // perm

    /**
     * 1.5.6a
     */

    public static int antall(int[] a, int r, boolean[] b, boolean[] d) {
        if (r == a.length) return 1;                  // lovlig oppstilling
        int antallLovlige = 0;                        // hjelpevariabel

        for (int i = r; i < a.length; i++)            // fra r og ut a
        {
            int sum = r + a[i], diff = r - a[i] + a.length - 1;

            if (b[sum] != true && d[diff] != true)      // sjekker om ledig
            {
                Tabell.bytt(a,i,r);                       // bytter a[i] og a[r]
                b[sum] = d[diff] = true;                  // markerer opptatt
                antallLovlige += antall(a,r+1,b,d);       // går til neste rad
                b[sum] = d[diff] = false;                 // markerer ledig
                Tabell.bytt(a,r,i);                       // bytter tilbake
            }
        }
        return antallLovlige;
    }

    /**
     * 1.5.6b
     */

    public static int antallR(int n) {
        int[] a = Tabell.naturligeTall(n);     // a = {0,1,2, . . , n - 1}
        return antall(a,0,new boolean[2*n-1],new boolean[2*n-1]);
    }

    /**
     * 1.5.6d
     */

    public static int antallR2(int n) {         // ny versjon

        int[] a = Tabell.naturligeTall(n);      // a = {0,1, . . , n - 1}
        boolean[] b = new boolean[2*n-1];       // bidiagonaler
        boolean[] d = new boolean[2*n-1];       // diagonaler

        int antallLovlige = 0;                  // hjelpevariabel

        for (int i = 0; i < n/2; i++)           // går til midten av rad 0
        {
            b[i] = d[n - 1 - i] = true;           // markerer en dronning
            antallLovlige += antall(a,1,b,d);     // kaller metoden
            b[i] = d[n - 1 - i] = false;          // opphever markering
            Tabell.bytt(a,0,i+1);                 // flytter dronning i rad 0
        }
        antallLovlige *= 2;                     // dobler antallet

        if (n % 2 != 0)                         // er n et oddetall?
        {
            b[n/2] = d[n/2] = true;               // dronning på midten
            antallLovlige += antall(a,1,b,d);     // kaller metoden
        }

        return antallLovlige;                   // det totale antallet
    }

    /**
     * 1.5.7a --> kvikksortering (quicksort)
     */

    private static void kvikksortering02(int[] a, int v, int h) {
        if (v >= h) return;   // tomt eller maks ett element

        int k = sParter0(a,v,h,(v + h)/2);   // se Programkode 1.3.9 f)
        kvikksortering02(a,v,k-1);
        kvikksortering02(a,k+1,h);
    }

    /**
     * 1.5.8a --> flettesortering (merge sort)
     */

    /*private static void flettesortering2(int[] a, int[] b, int fra, int til) {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element

        int m = (fra + til)/2;        // midt mellom fra og til

        flettesortering2(a,b,fra,m);   // sorterer a[fra:m>
        flettesortering2(a,b,m,til);   // sorterer a[m:til>

        // fletter a[fra:m> og a[m:til>
        flett(a,b,fra,m,til);         // Programkode 1.3.11 f)
    }*/

    public static void flettesortering(int[] a) {
        int[] b = new int[a.length/2];    // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length);  // kaller metoden over
    }

    /**
     * 1.5.9a
     */

    public static void HanoisTårn(char A, char B, char C, int n) {
        if (n == 0) return;   // ingen brikker - tomt tårn
        HanoisTårn(A, C, B, n - 1);
        System.out.println("Brikke " + n + " fra " + A + " til " + C);
        HanoisTårn(B, A, C, n - 1);
    }

    public static int finnStørste(int[]a){
        int størsteTall = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] > størsteTall){
                størsteTall = a[i];
            }
        }
        return størsteTall;
    }



}
