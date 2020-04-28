package Kompendie;

import Kompendie.Eksempelklasser.*;
import Kompendie.Hjelpeklasser.*;

import java.awt.*;
import java.text.Collator;
import java.util.*;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Kompendie.Hjelpeklasser.Tabell.*;

public class Main {
    public static void main(String[] args) {

        /**
         * 1.1.7b
         */

        int[] a = {8,3,5,7,9,6,10,2,1,4}, b = {}; // to tabeller

        System.out.println(Tabell.maks(a)); // utskrift: OptionalInt[6]
        //System.out.println(Tabell.maks(b)); // utskrift: OptionalInt.empty

        /**
         * 1.1.8g
         */

        int[] q22 = {6,8,1,4,2,10,7,9,3,5};
        Tabell.randPerm5(q22);
        System.out.println(Arrays.toString(q22));

        /**
         * 1.1.9b
         */

        int c22 = 100_000; // tabellstørrelse
        System.out.println(Tabell.antallMaks(randPerm4(c22)));

        /**
         * 1.1.10
         */

        /*int d = 100_000, antall = 2_000; //n er tabellstørrelse
        long tid = 0;
        int e[] = Tabell.randPerm4(d);

        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++) Tabell.kostnader(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++) Tabell.maks1(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis(); // leser av klokken
        for (int i = 0; i < antall; i++) Tabell.maks2(a); // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid; // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis(); // leser av klokken
        for (int i = 0; i < antall; i++) Tabell.maks3(a); // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid; // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");*/

        /**
         * 1.1.11
         */

        /*int[] f = {8,3,5,7,9,6,10,2,1,4};           // en heltallstabell
        IntStream s = Arrays.stream(a);             // fra int-tabell til IntStream
        OptionalInt resultat = s.max();             // kaller max-metode
        if (resultat.isPresent()){
            System.out.println(resultat.getAsInt());
        }
        else {
            System.out.println("Ingen verdi!");
        }

        int[] g = {8, 3, 5, 7, 9, 6, 10, 2, 1, 4};
        IntStream h = Arrays.stream(g);
        OptionalInt resultat2 = h.min();
        if (resultat.isPresent()) System.out.println(resultat2.getAsInt());
        else System.out.println("Ingen verdi!");


        int[] i = {8, 3, 5, 7, 9, 6, 10, 2, 1, 4};

        IntStream s2 = Arrays.stream(f);
        System.out.printf("%-8s%3d\n", "maks: ", s2.max().getAsInt());

        s2 = Arrays.stream(f);
        System.out.printf("%-8s%3d\n", "min: ", s2.min().getAsInt());

        s2 = Arrays.stream(f);
        System.out.printf("%-8s%3d\n", "sum: ", s2.sum());

        s2 = Arrays.stream(f);
        System.out.printf("%-8s%3.1f\n", "snitt: ", s2.average().getAsDouble());*/

        /*s2 = Arrays.stream(f);
        IntSummaryStatistics k = s.summaryStatistics();
        System.out.printf("%-8s%3d\n", "maks: ", k.getMax());
        System.out.printf("%-8s%3d\n", "min: ", k.getMin());
        System.out.printf("%-8s%3d\n", "sum: ", k.getSum());
        System.out.printf("%-8s%3d\n", "antall: ", k.getCount());
        System.out.printf("%-8s%3.1f\n", "snitt: ", k.getAverage());*/

        /**
         * (1.2.1d) --> denne koden viser hvordan copyOfRange-metoden kan brukes
         */

        char[] j = {'A','B','C','D','E','F','G','H','I','J'}; // 10 bokstaver

        char[] w = Arrays.copyOfRange(j,4,8);       // en kopi av c[4:8>
        for (char l : w) System.out.print(l + " ");           // kopien d skrives ut


        /**
         * 1.2.2b
         */

        //int[] m = Program.randPerm4(20);                     // en tilfeldig tabell
        //for (int o : m) System.out.print(k + " ");          // skriver ut a
        //int n = Tabell.maks(m);                             // finner posisjonen til største verdi

        //System.out.println("\nStørste verdi ligger på plass " + n);

        /**
         * 1.2.4b
         */

        //int[] z = Tabell.randPerm4(20);              // tilfeldig permutasjon av 1 . . 20
        //int[] x = Tabell.nestMaks(z);                   // metoden returnerer en tabell

        //int r = b[0], nm = b[1];                        // m for maks, nm for nestmaks

        //Tabell.skrivln(a); // se Oppgave 5 i Avsnitt 1.2.2
        //System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        //System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

        System.out.println("\n-----------");

        System.out.println(Arrays.toString(b));

        System.out.println("\n-----------");

        // kopierer a først i b
        //System.arraycopy(a, 0, b, 0, a.length);

        // kopierer a bakerst i b
        //System.arraycopy(a, 0, b, b.length - a.length,a.length);

        // kopierer a på midten av b
        //System.arraycopy(a, 0, b, (b.length - a.length)/2,a.length);

        /**
         * 1.3.1c --> Denne viser hvordan metoden nestePermutasjon kan brukes
         */

        System.out.println("\n-----------");

        int[] t = {3,1,4,9,7,10,8,6,5,2}; // permutasjon av tallene fra 1 til 10
        Tabell.nestePermutasjon(t); // lager neste permutasjon
        System.out.println(Arrays.toString(a)); // [3, 1, 4, 9, 8, 2, 5, 6, 7, 10]


        /**
         * (1.3.1d) --> oppg 1.3.1 5
         */

        int[] a11 = {1,2,3,4,5};                          // første permutasjon
        int sum = 0;                                    //hjelpevariabel

        do { sum += Tabell.antallMaks(a11); }            //se 1.1.9a
        while (Tabell.nestePermutasjon(a11));             //lager neste permutasjon
        System.out.println(sum);                        //Utskrift: 154

        /**
         * Oppg 1.3.1 2
         */

        System.out.println("\n---------------");

        int[] ab = {2,6,5,4,3,1};
        Tabell.nestePermutasjon(ab);
        Tabell.skriv(ab);

        /**
         * Oppg 1.3.1 3
         */

        System.out.println("\n---------------");

        int[] b11 = {3,1,4,9,7,10,8,6,5,2};

        for (int i = 0; i < 10; i++) {
            Tabell.nestePermutasjon(b11);
            Tabell.skrivln1(b11);
        }

        /**
         * Oppg 1.3.1 4
         */

        System.out.println("-----------------");
        System.out.println("Permutasjoner med 3 tall : ");

        //Permutasjoner med 3 tall = 6
        int[] c2 = {1,2,3};
        do{Tabell.skrivln2(c2);}
        while(Tabell.nestePermutasjon(c2));
        Tabell.skrivln2(c2);

        System.out.println("-----------------");
        System.out.println("Permutasjoner med 4 tall : ");


        //Permutasjoner med 4 tall = 24
        int[] d = {1,2,3,4};
        do{Tabell.skrivln1(d);}
        while(Tabell.nestePermutasjon(d));
        Tabell.skrivln1(d);

        /**
         * (1.3.2b)
         */

        System.out.println("1 -----------------");

        int[] a5 = {1,2,4,3,6,7,9,5,8,10};
        System.out.println(Tabell.inversjoner(a5)); // Utskrift: 5


        /**
         * (1.3.4b) --> sjekke at 1.3.4a fungerer
         */

        System.out.println("2 -----------------");

        int[] x = {7,5,9,2,10,4,1,8,6,3};   // en usortert heltallstabell
        Tabell.utvalgssortering(x);         // stigende sortering
        Tabell.snu(x);                      // tabellen snus
        Tabell.skriv(x);                    // 10 9 8 7 6 5 4 3 2 1

        /**
         * (1.3.4) --> oppg 5
         */

        System.out.println("\n3 ----------------- ");

        int[] x2 = {7,5,9,2,10,4,1,8,6,3};   // en usortert heltallstabell
        Tabell.utvalgssortering2(x2);         // stigende sortering
        Tabell.snu(x2);                      // tabellen snus
        Tabell.skriv(x2);                    // 10 9 8 7 6 5 4 3 2 1


        /**
         * (1.3.4) --> Oppg 9
         */

        System.out.println("\n4 -----------------");

        int[] a2 = {7,5,9,2,10,4,1,8,6,3};
        Tabell.utvalgssortering4(a2, 0, 8);     
        Tabell.snu(a2);
        Tabell.skriv(a2);


        /**
         * (1.3.4) --> Oppg 8
         */

        System.out.println("\n5 -----------------");

        int[] a3 = {7,5,9,2,10,4,1,8,6,3};
        Tabell.utvalgssortering4(a3, 0, 10);
        Tabell.snu(a3);
        Tabell.skriv(a3);

        /**
         * (1.3.4b) -->
         */

        System.out.println("\n6 -----------------");

        int[] a4 = {7,5,9,2,10,4,1,8,6,3};
        Tabell.utvalgssortering(a4);
        Tabell.snu(a4);
        Tabell.skriv(a4);

        /**
         * (1.3.2d) --> viser hvordan metoden erSortert kan brukes
         */

        System.out.println("\n7 -----------------");

        int[] b1 = {}, b2 = {5}, b3 = {1,2,4,3,6,7,9,5,8,10}; // heltallstabeller
        int[] b4 = {1,2,3,4,5,6,7,8,9,10}; //heltallstabell

        boolean q = Tabell.erSortert(b1), y = Tabell.erSortert(b2);
        boolean z = Tabell.erSortert(b3), u = Tabell.erSortert(b4);

        System.out.println(q + " " + y + " " + z + " " + u);

        // Utskrift: true true false true
        //Vi får både true for når tabellen er tom og med 1 verdi

        /**
         * (1.3.5b) --> viser hvordan metoden i lineærsøk kan brukes
         */

        System.out.println("\n8 -----------------");

        int[] ax = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40}; // Figur 1.3.5 a)
        System.out.println(Tabell.lineærsøk(ax,32)); // utskrift: 10
        System.out.println(Tabell.lineærsøk(ax,31)); // utskrift: -11

        /**
         * (1.3.5) --> oppgave 2
         */

        System.out.println("\n9 -----------------");
        int[] ax2 = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};
        System.out.println(Tabell.lineærsøk(ax2, 2));
        System.out.println(Tabell.lineærsøk(ax2, 15));
        System.out.println(Tabell.lineærsøk(ax2, 16));
        System.out.println(Tabell.lineærsøk(ax2, 40));
        System.out.println(Tabell.lineærsøk(ax2, 41));

        //når den returnerer et tall, returnerer den indeksen den ligger på,
        //men når tallet ikke finnes returnerer den plasseringen, hvis det ga mening. Tar ikke med null


        /**
         * (1.3.5) --> Oppgave 6
         */

        System.out.println("\n10 -----------------");

        int[] tabell1 = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};
        int[] tabell2 = Tabell.lineærIntervallsøk(tabell1, 10, 20);
        System.out.println(Arrays.toString(tabell2)); // [10, 12, 14, 16]

        /**
         * (1.3.6) --> oppgave 3
         */

        System.out.println("\n11 -----------------");

        int[] tabell3 = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};

        System.out.println("Leter etter tallet 4");
        System.out.println(Tabell.binærsøk1(tabell3, 0, 16, 4));
        System.out.println(Tabell.binærsøk2(tabell3, 0, 16, 4));
        System.out.println(Tabell.binærsøk3(tabell3, 0, 16, 4));

        System.out.println("Leter etter tallet 7");
        System.out.println(Tabell.binærsøk1(tabell3, 0, 16, 7));
        System.out.println(Tabell.binærsøk2(tabell3, 0, 16, 7));
        System.out.println(Tabell.binærsøk3(tabell3, 0, 16, 7));

        System.out.println("Leter etter tallet 10");
        System.out.println(Tabell.binærsøk1(tabell3, 0, 16, 10));
        System.out.println(Tabell.binærsøk2(tabell3, 0, 16, 10));
        System.out.println(Tabell.binærsøk3(tabell3, 0, 16, 10));

        System.out.println("Leter etter tallet 15");
        System.out.println(Tabell.binærsøk1(tabell3, 0, 16, 15));
        System.out.println(Tabell.binærsøk2(tabell3, 0, 16, 15));
        System.out.println(Tabell.binærsøk3(tabell3, 0, 16, 15));


        /**
         * (1.3.8a) --> kode som setter inn en ny verdi i en tabell som ikke er full
         */

        System.out.println("\n12--------------------");

        /*int[] a6 = {3,5,6,10,10,11,13,14,16,20,0,0,0,0,0}; // en tabell
        int antall = 10;

        if (antall >= a.length) throw new IllegalStateException("Tabellen er full");

        int nyverdi = 10;               //ny verdi
        int k = Tabell.binærsøk3(a, 0, antall, nyverdi); // søker i a[0:antall>
        if (k<0)k=-(k+1);           //innsetningspunkt

        for (int i = antall; i > k; i--) a[i] = a[i-1]; //forskyver

        a[k] = nyverdi; //legger inn
        antall++; //øker antallet

        Tabell.skrivln1(a, 0, antall); // Se Oppgave 4 og 5 i Avsnitt 1.2.2*/


        /**
         * (1.3.8d) --> viser hvordan metdoden innsetningssortering (1.3.8c)
         */

        System.out.println("\n13--------------------");

        int[] a7 = {13,11,10,20,15,5,3,2,14,10,12,6,7,4,16};
        Tabell.innsettingssortering2(a7);
        System.out.println(Arrays.toString(a7));
        // Utskrift: [2, 3, 4, 5, 6, 7, 10, 10, 11, 12, 13, 14, 15, 16, 20]

        /**
         * Shellsort (innsetningssortering) --> her økes indeksen med 4 istedenfor 1
         */

        System.out.println("\n14--------------------");

        int[] a8 = {5,14,13,11,12,2,3,4,1,10,8,18,16,19,17,9,6,20,7,15};

        for (int i = 4; i < a.length; i++) {     // avstanden/gapet er nå 4 og ikke 1
            int temp = a[i], j3 = i-4;
            for (;j3 >= 0 && temp < a[j3]; j3 -= 4) a[j3+4] = a[j3];
            a[j3 + 4] = temp;
        }

        /**
         * (1.3.8g) --> ved hjelp av metoden skjell kan vi sortere en tabell fullstendig.
         *
         */

        System.out.println("\n15--------------------");

        int[] a9 = {8,14,16,19,17,9,3,4,1,15,5,18,13,11,12,2,6,20,7,10};
        int[] gap = {1,4,10};

        for (int i = gap.length - 1; i >= 0; i--) {
            Tabell.shell(a,gap[i]);                 // først 10, så 4 og 1 til slutt
            System.out.println(Arrays.toString(a));  // skriver ut
            // [5, 14, 13, 11, 12, 2, 3, 4, 1, 10, 8, 18, 16, 19, 17, 9, 6, 20, 7, 15]
            // [1, 2, 3, 4, 5, 10, 7, 9, 6, 14, 8, 11, 12, 19, 13, 15, 16, 20, 17, 18]
            // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
        }

        /**
         * (1.3.8h)
         */

        System.out.println("\n16--------------------");

        int[] gap2 = {1,4,10,23,57,132,301,701,1577,3548,7984,17965,40423,90952,204642};
        int[] a10 = Tabell.randPerm3(200_000); // en tilfeldig tabell
        System.out.println(Tabell.erSortert(a10)); // sjekker tabellen

        long tid = System.currentTimeMillis(); // starter klokken

        Tabell.innsettingssortering(a10); // sorterer
        for (int i = gap.length - 1; i >= 0; i--)
            Tabell.shell(a,gap[i]);

        System.out.println(System.currentTimeMillis() - tid); // tiden
        System.out.println(Tabell.erSortert(a10)); // sjekker sorteringen

        //System.out.println(Arrays.sort(a10));


        /**
         * (1.3.9b)
         */

        System.out.println("\n17--------------------");

        int[] a6 = {0,0,1,0,0,1,0,1,1,0,0,1,1,1,0,1,0,1,1,0};
        int[] b6 = {8,3,15,13,1,9,20,3,18,2,6,25,14,8,20,16,5,21,11,14};

        Tabell.parter(a6, 0, a6.length, 1); // bruker 1 som skilleverdi
        Tabell.parter(b6, 0, b6.length, 10); // bruker 10 som skilleverdi

        System.out.println(Arrays.toString(a6));
        System.out.println(Arrays.toString(b6));

        // Utskrift:
        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        // [8, 3, 5, 8, 1, 9, 6, 3, 2, 18, 20, 25, 14, 13, 20, 16, 15, 21, 11, 14]

        /**
         * (1.3.9c)
         */

        System.out.println("\n18--------------------");

        int[] a88 = {13,2,8,10,16,9,15,4,18,14,12,11,7,5,3,6,17,1,20,19};
        int pos = Tabell.parter(a88, 11); // bruker 11 som skilleverdi
        System.out.println(pos + " " + Arrays.toString(a88));


        /**
         * (1.3.9c)
         */

        System.out.println("\n19--------------------");

        int[] a12 = {1,2,3,4,5,6,7,8,9,10};
        boolean flere = true;
        int antall = 0;

        while (flere) {
            for (int s = 1; s <= a12.length; s++)
                antall += Tabell.antallOmbyttinger(a12, s);
            flere = Tabell.nestePermutasjon(a12);
        }
        System.out.println(antall); // Utskrift: 59875200
        //Det totale antallet ble 59875200 = 27·35·52·7·11.


        /**
         * (1.3.9g)
         */

        System.out.println("\n20--------------------");

        int[] a13 = {13,2,8,10,16,9,15,4,18,14,12,11,7,5,3,6,17,1,20,19};
        int k = Tabell.sParter(a13, 11); // verdi 11 ligger på indeks 11
        System.out.println(k + " " + Arrays.toString(a13)); // Utskrift:
        // 10 [1, 2, 8, 10, 6, 9, 3, 4, 5, 7, 11, 19, 14, 18, 15, 16, 17, 13, 20, 12]

        /**
         * (1.3.9i)
         */

        System.out.println("\n21--------------------");

        int[] a14 = randPerm4(20); // en tilfeldig permutasjon
        Tabell.kvikksortering(a14); // sorterer
        System.out.println(Arrays.toString(a14)); // skriver ut

        /**
         * (1.3.11b)
         */

        System.out.println("\n22--------------------");

        int[] a15 = {1,3,5,7,9,11}, b15 = {2,4,6,8,10}; // to heltallstabeller
        int[] c = Tabell.enkelFletting(a15, b15);
        System.out.println(Arrays.toString(c));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

        /**
         * (1.3.11e) --> viser hvordan 1.3.11d kan brukes
         */

        System.out.println("\n23--------------------");

        int[] a16 = {1,3,4,6,9,9,11}, b16 = {2,3,5,6,7,8,9,10,12,14}; // sorterte tabeller
        int[] c3 = new int[a16.length + b16.length]; // nå er c stor nok
        Tabell.flett(a16,b16,c3);
        Tabell.skriv(c3); //Utskrift:123345667899910111214

        /**
         * (1.3.11i) --> denne henger sammen med 1.3.11h
         */

        System.out.println("\n24--------------------");

        int[] a17 = randPerm4(15);
        Tabell.flettesortering2(a17);
        Tabell.skriv(a17);
        // Utskrift: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

        /**
         * (1.3.11l)
         */

        System.out.println("\n25--------------------");

        int[] a18 = {1,3,4,6,9,11,13};        // ingen like verdier
        int[] b18 = {2,3,5,6,7,8,9,10,11,12};  // ingen like verdier
        int[] c18 = new int[a18.length + b18.length];  // c er nå stor nok

        System.out.println(Arrays.toString(Arrays.copyOf(c, Tabell.union(a18, b18, c18))));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]


        /**
         * (1.3.11l) --> kode i forhold til 1.3.11m
         */

        System.out.println("\n26--------------------");

        int[] a19 = {1,3,4,6,9,11,13}; // ingen like verdier
        int[] b19 = {2,3,5,6,7,8,9,10,11,12}; // ingen like verdier
        int[] c19 = new int[Math.min(a19.length,b19.length)]; // c er nå stor nok

        System.out.println(Arrays.toString(Arrays.copyOf(c, Tabell.snitt(a19, b19, c19))));
        // Utskrift: [3, 6, 9, 11]

        /**
         * (1.4.1c)
         */

        System.out.println("\n27--------------------");

        int[] a20 = {5,2,7,3,9,1,8,4,6};
        double[] d20 = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s20 = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};

        //Kompilatoren velger rett metode ut fra datatype
        int g = Tabell.maks(a20);     // posisjonen til den største i a
        int l = Tabell.maks(d20);     // posisjonen til den største i d
        int m = Tabell.maks(s20);     // posisjonen til den største i s

        System.out.println(a20[g] + " " + d20[l] + " " + s20[m]);
        // Utskrift: 9 7.12 Thanh


        /**
         * (1.4.2)
         */

        System.out.println("\n28--------------------");


        int[] a33 = {34,64,12,86,54,99,13,36};

        Tabell.utvalgssortering2(a33);
        System.out.println(Arrays.toString(a33)); //hele tabellen

        //System.out.println(Arrays.toString(a[a.length-1])); //siste tallet

        /**
         * (1.4.2d)
         */

        System.out.println("\n29--------------------");

        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int h = Tabell.maks(s);        // hvilken maks-metode?
        System.out.println(s[h]);      // Utskrift:  Thanh

        /**
         * (1.4.2f)
         */

        System.out.println("\n30--------------------");

        String[] s5 = {"Per","Kari","Ole","Anne","Ali","Eva"};
        //Tabell.innsettingssortering(s5);
        System.out.println(Arrays.toString(s5));  // [Ali, Anne, Eva, Kari, Ole, Per]


        /**
         * Test
         */

        //int[] niko = {4,2,6,7,9,3,5,7,1};
        //System.out.println("Antall inversjoner i tabellen "+Arrays.toString(niko)+" er : "+Tabell.inversjoner(niko));


        /**
         * (1.4.3a) --> viser hvordan autoboksing og avboksing virker
         */

        System.out.println("\n31--------------------");

        Integer k10 = new Integer(5);      // gammel (men lovlig) måte
        Integer n10 = 5;                   // ny måte - autoboksing

        int i = k10.intValue();            // i blir 5 - gammel (men lovlig) måte
        int j2 = n10;                       // j blir 5 - avboksing

        Integer[] a21 = {5,2,7,3,9,1,8,10,4,6};   // her inngår autoboksing

        //Tabell.innsettingssortering(a21);  // den generiske metoden kalles
        System.out.println(Arrays.toString(a21));

        /**
         * (1.4.3b) --> Hvis vi allerede har en int-tabell, må det lages kode for å få en Integer-tabell med samme innhold:
         * Dette er feil måte å gjøre det på og vil gi en syntaksfeil
         */

        System.out.println("\n32--------------------");

        //int[] x1 = {5,2,7,3,9,1,8,10,4,6};                // en int-tabell
        //Integer[] x2 = x1;                                 // syntaksfeil

        /**
         * (1.4.3c) --> vi må isteden gjøre slik
         * Denne konstruksjonen er kostbar. Tabellen b som har samme innhold, bruker dobbelt så mye plass som a.
         */

        System.out.println("\n33--------------------");

        int[] a30 = {5,2,7,3,9,1,8,10,4,6};                // en int-tabell

        Integer[] b30 = new Integer[a30.length];             // en tom Integer-tabell

        for (int f = 0; f < b30.length; f++) b30[i] = a30[i];  // fyller tabellen (autoboksing)

        System.out.println(Arrays.toString(a30));
        System.out.println(Arrays.toString(b30));

        /**
         * (1.4.3e) --> denne henger sammen med 1.4.3d
         */

        System.out.println("\n34--------------------");

        Integer[] a40 = Tabell.randPermInteger(10);
        System.out.println(Arrays.toString(a40));
        // En mulig utskrift: [7, 1, 8, 2, 10, 3, 4, 6, 5, 9]

        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        /**
         * (1.4.3) --> Oppgave 1
         *
         * Autoboksing og avboksing gjelder ikke bare for int og Integer, men for alle de grunnleggende typene med
         * tilhørende omslagsklasser. Sjekk dette!
         */

        System.out.println("\n35--------------------");

        Double x30 = new Double(3.14);  // gammel måte
        Double y30 = 3.14;              // autoboksing

        double d30 = x30;     // avboksing

        Boolean b40 = new Boolean(true);   // gammel måte
        Boolean c40 = true;                // autoboksing

        Character[] a41 = {'A','B','C','D','E'};  // autoboksing
        char tegn = a41[2];   // avboksing

        /**
         * (1.4.4c) --> kode ift. kllassen Heltall
         */

        System.out.println("\n35--------------------");

        int[] a50 = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h50 = new Heltall[a50.length];       // en Heltall-tabell

        for (int t24 = 0; t24 < h50.length; t24++) h50[t24] = new Heltall(a50[t24]);
        //Tabell.innsettingssortering(h50);           // generisk sortering
        System.out.println(Arrays.toString(h50));   // utskrift


        /**
         * (1.4.4e) --> finner «største» personen, dvs. den som kommer sist i den leksikografiske ordningen.
         * Denne personen skrives ut. Så sorteres tabellen ved hjelp av innsettingssorteringen og resultatet skrives ut
         */

        System.out.println("\n36--------------------");

        Person[] p60 = new Person[5];                   // en persontabell

        p60[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p60[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p60[2] = new Person("Ali","Kahn");              // Ali Kahn
        p60[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p60[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        //int m60 = Tabell.maks(p60);                       // posisjonen til den største
        //System.out.println(p60[m60] + " er størst");      // skriver ut den største

        //Tabell.innsettingssortering(p60);               // generisk sortering
        //TODO: hvorfor funker aldri Tabell.innsettingssortering?
        System.out.println(Arrays.toString(p60));       // skriver ut sortert

        // Utskrift:

        // Boris Zukanovic er størst
        // [Ali Kahn, Kari Pettersen, Kari Svendsen, Azra Zukanovic, Boris Zukanovic]

        /**
         * (1.4.4f) --> java sin teknikk for å finne den største verdien, men med omvei
         */

        Stream s70 = Arrays.stream(p60);
        Optional<Person> resultat = s70.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);

        /**
         * (1.4.5b) --> (1.4.5a)
         */

        System.out.println("\n37--------------------");

        for (Studium s80 : Studium.values()) {
            System.out.println(s.toString() + " (" + s80.name() + ")");
        }
        // Ingeniørfag - data (Data)
        // Informasjonsteknologi (IT)
        // Anvendt datateknologi (Anvendt)
        // Enkeltemnestudent (Enkeltemne)


        /**
         * (1.4.5d) --> Vi utnevner personene i eksemplet fra Programkode 1.4.4 e)
         * til studenter og tilordner hver av dem et studium. En Student er en Person og instanser
         * av Student kan sammenlignes og ordnes som personer. Derfor kan vi her benytte den generiske
         * innsettingssorteringen fra Programkode 1.4.2 e) på en Student-tabell:
         */

        System.out.println("\n38--------------------");

        Student[] s71 = new Student[5];  // en Studenttabell

        s71[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s71[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s71[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s71[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s71[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen

        //Tabell.innsettingssortering(s71);                     // Programkode 1.4.2 e)
        for (Student t23 : s71) System.out.println(t23);

        // Utskrift:
        // Ali Kahn Anvendt
        // Kari Pettersen Data
        // Kari Svendsen Data
        // Azra Zukanovic IT
        // Boris Zukanovic IT


        /**
         * (1.4.5e) --> Det er også mulig (men kanskje ikke spesielt naturlig) å blande personer og studenter
         * i samme persontabell. Det går bra siden en student er en person. De generiske metodene vil virke som
         * tidigere, f.eks. innsettingssortering():
         */

        System.out.println("\n39--------------------");

        Person[] p = new Person[5];      // en Persontabell

        p[0] = new Student("Kari","Svendsen",Studium.Data);    // en student
        p[1] = new Person("Boris","Zukanovic");                // en person
        p[2] = new Student("Ali","Kahn",Studium.Anvendt);      // en student
        p[3] = new Person("Azra","Zukanovic");                 // en person
        p[4] = new Student("Kari","Pettersen",Studium.Data);   // en student

        //Tabell.innsettingssortering(p);                     // Programkode 1.4.2 e)
        for (Person t22 : p) System.out.println(t22);

        // Utskrift:
        // Ali Kahn Anvendt
        // Kari Pettersen Data
        // Kari Svendsen Data
        // Azra Zukanovic
        // Boris Zukanovic

        /**
         * (1.4.6c)
         */

        System.out.println("\n40--------------------");

        Person[] p50 = new Person[5];                       // en persontabell
        p50[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p50[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p50[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p50[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p50[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        //Denne koden under her kan kortes mye ned på ved å bruke lambda uttrykk som kommer enda lenger under
        /*class FornavnKomparator implements Komparator<Person> {
            public int compare(Person p1, Person p2)        // to personer
            {
                return p1.fornavn().compareTo(p2.fornavn());  // sammenligner fornavn
            }
        }

        Komparator<Person> c20 = new FornavnKomparator();   // en instans av klassen
        Tabell.innsettingssortering(p50, c20);                // se Programkode 1.4.6 b)

        System.out.println(Arrays.toString(p50)); */          // Utskrift av tabellen p
        // [Ali Kahn, Azra Zukanovic, Boris Zukanovic, Kari Svendsen, Kari Pettersen]

        /**
         * (1.4.6e)
         * Denne koden kan forkortes enda mer (1.4.6f) derfor kommenterer jeg ut denne
         */
        //Komparator<Person> c60 = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        //Tabell.innsettingssortering(p50, c60);                // se Programkode 1.4.6 b)
        //System.out.println(Arrays.toString(p50));           // Utskrift av tabellen p

        /**
         * (1.4.6f)
         */

        Tabell.innsettingssortering(p50, (p1,p2) -> p1.fornavn().compareTo(p2.fornavn()));
        System.out.println(Arrays.toString(p50));

        /**
         * (1.4.6g) --> sortere studenter etter studium
         * Student er subtype til Person. En student hører til et studium
         * Vi bruker et lambda-uttrykk på samme måte som over. Der brukes den naturlige ordningen for
         * enumtypen Studium (dvs. Data, IT, . . .):
         */

        Student[] s32 = new Student[5];                             // en studenttabell
        s32[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s32[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s32[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s32[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s32[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen

        Komparator<Student> c21 = (s1,s2) -> {
            int cmp = s1.studium().compareTo(s2.studium());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        //Tabell.innsettingssortering(s32, c21);    // Programkode 1.4.6 b)
        System.out.println(Arrays.toString(s32));

        /**
         * (1.4.6i) --> ordne tallstrenger med hensyn på lengde
         * Når man vil ordne noe på en spesiell måte så er det da mantar ibruk en komperator
         */

        System.out.println("\n41--------------------");

        String[] s33 = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s33, (s1,s2) -> s1.length() - s2.length());

        System.out.println(Arrays.toString(s33));
        // Utskrift: [Per, Lars, Kari, Bodil, Berit, Anders]

        /**
         * (1.4.6j) --> ordner integer etter leksikografisk rekkefølge
         */

        System.out.println("\n42--------------------");

        Integer[] a35 = {13,25,11,3,2,21,10,1,33,100};  // en Integer-tabell
        Tabell.innsettingssortering(a35, (x3,y3) -> x3.toString().compareTo(y3.toString()));

        System.out.println(Arrays.toString(a35));
        // Utskrift: [1, 10, 100, 11, 13, 2, 21, 25, 3, 33]


        /**
         * (1.4.6k) --> I flg. ordning skal ethvert oddetall komme foran ethvert partall. La x og y være to heltall.
         * Hvis x − y er et partall, så er enten begge oddetall eller begge partall:
         */

        System.out.println("\n43--------------------");

        Komparator<Integer> c36 = (x4,y4) -> {
            if (((x4 - y4) & 1) == 0) return 0;  // x og y oddetall eller x og y partall
            else if ((x4 & 1) == 0) return 1;    // x partall og y oddetall
            else return -1;                      // x oddetall og y partall
        };

        Integer[] b36 = {6,2,7,1,9,5,10,8,4,3};
        //Tabell.innsettingssortering(b36, c36);

        System.out.println(Arrays.toString(b36));
        // Utskrift: [7, 1, 9, 5, 3, 6, 2, 10, 8, 4]

        /**
         * (1.4.6) --> Oppgave 2
         */

        /*Student[] s37 = new Student[9];                             // en studenttabell

        s37[0] = new Student("Kari","Svendsen",Studium.Data);      // Kari Svendsen
        s37[1] = new Student("Boris","Zukanovic",Studium.IT);      // Boris Zukanovic
        s37[2] = new Student("Ali","Kahn",Studium.Anvendt);        // Ali Kahn
        s37[3] = new Student("Azra","Zukanovic",Studium.IT);       // Azra Zukanovic
        s37[4] = new Student("Kari","Pettersen",Studium.Data);     // Kari Pettersen
        s37[5] = new Student("Anders","Åsen",Studium.Elektro);     // Anders Åsen
        s37[6] = new Student("Kari","Østsiden",Studium.Elektro);   // Kari Østsiden
        s37[7] = new Student("Per","Jensen",Studium.Enkeltemne);   // Per Jensen
        s37[8] = new Student("Kari","Lie",Studium.Enkeltemne);     // Kari Lie

        Tabell.innsettingssortering(s, (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    return k != 0 ? k : s1.compareTo(s2);
                }
        );

        for (Student t : s) System.out.println(t);*/


        /**
         * (1.4.7a) -->
         */

        System.out.println("\n44--------------------");

        Integer[] a42 = {6,2,10,9,5,1,8,4,3,7};                            // Integer
        String[] s42 = {"Sohil","Per","Thanh","Ann","Kari","Jon"};         // String

        Tabell.innsettingssortering(a42, (x5,y5) -> x5.compareTo(y5));         // lamda-uttrykk
        Tabell.innsettingssortering(s42, (x5,y5) -> x5.compareTo(y5));         // lamda-uttrykk

        System.out.println(Arrays.toString(a42));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(Arrays.toString(s42));  // [Ann, Jon, Kari, Per, Sohil, Thanh]


        /**
         * (1.4.7e) --> eksempel på hvordan 1.4.7d funker
         */

        System.out.println("\n45--------------------");

        Integer[] a43 = {6,2,10,9,5,1,8,4,3,7};
        String[] s43 = {"Sohil","Per","Thanh","Ann","Kari","Jon"};

        Tabell.innsettingssortering(a43, Comparator.reverseOrder());
        Tabell.innsettingssortering(s43, Comparator.reverseOrder());

        System.out.println(Arrays.toString(a43));  // [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        System.out.println(Arrays.toString(s43));  // [Thanh, Sohil, Per, Kari, Jon, Ann]


        /**
         * (1.4.7i) --> dette er en forenkling av koden 1.4.6i
         */

        System.out.println("\n46--------------------");

        String[] s61 = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //Tabell.innsettingssortering(s61, Komparator.orden(String::length));

        System.out.println(Arrays.toString(s61));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

        /**
         * (1.4.7j) -->
         */

        //Tabell.innsettingssortering(a, Komparator.orden(x -> x.toString()));
        System.out.println(Arrays.toString(a)); // [1, 10, 100, 11, 13, 2, 21, 25, 3, 33]


        /**
         * 1.4.8b -->
         */

        System.out.println("\n47--------------------");

        Komparator<String> c45 = (s1,s2) -> {
            int k45 = s1.length() - s2.length(); //ordner strenger etter lengde
            return k45 != 0 ? k45 : s1.compareTo(s2); //ordner strenger alfabetisk
            //to strenger kan være like lange uten at de er like.

            /*
            Disse to strengene over som ordner etter lengde of alfabetisk og også være satt opp slik som under her, med en komparator
              Komparator<String> c1 = Komparator.orden(String::length);  // ordner etter lengde
              Komparator<String> c2 = Komparator.naturligOrden();        // ordner alfabetisk

              Komparator<String> c  = c1.deretter(c2);      // sammensetingen av c1 og c2
              Skal gjøres slik at det først ordnes ved hjelp av c1 og deretter ved hjelp av c2 hvis c1 gir 0.
              Det betyr at deretter må være en instansmetode til c1. Det får vi til ved å legge 1.4.8c inn i grensesnittet Komparator
             */

        };

        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //Tabell.innsettingssortering(navn, c45);

        System.out.println(Arrays.toString(navn));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

        /**
         * 1.4.8d
         */

        System.out.println("\n48--------------------");

        //TODO: finn ut av hvorfor orden ikke fungerer.
        //Komparator<String> c33 = Komparator.orden(String::length);  // ordner etter lengde
        Komparator<String> c34 = Komparator.naturligOrden();        // ordner alfabetisk

        //Tabell.innsettingssortering(navn, c33.deretter(c34));

        System.out.println(Arrays.toString(navn));
        // Utskrift: [Per, Kari, Lars, Berit, Bodil, Anders]

        //koden over kan kortes ned til:
        //Tabell.innsettingssortering(navn, Komparator.orden(String::length).deretter(Komparator.naturligOrden()));


        /**
         * 1.4.8g
         */

       /* Komparator<Student> c = Komparator.orden(Student::studium).
                deretter(Student::fornavn).
                deretter(Student::etternavn);*/

        /**
         * 1.4.8h
         */

        System.out.println("\n49--------------------");

        String[] s3 = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};

        Tabell.innsettingssortering(s3, Comparator.naturalOrder());
        System.out.println(Arrays.toString(s3));

        // Utskrift: [KARI, Kari, OLA, Ola, PER, Per, kari, ola, per]

        /**
         * 1.4.8i --> samme navn kommer ved hverandre fordi den ignorerer store og små bokstaver, men alle like navn
         * kommer ved siden av hverandre i tilfeldig rekkefølge
         */

        System.out.println("\n50--------------------");

        String[] s4 = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};
        Tabell.innsettingssortering(s4, (x7,y7) -> x7.compareToIgnoreCase(y7));
        System.out.println(Arrays.toString(s4));

        // Utskrift: [Kari, kari, KARI, OLE, Ole, ole, Per, PER, per]


        /**
         * 1.4.8j --> her bruker vi omvendt naturlig orden og da blir det riktig
         */

        System.out.println("\n51--------------------");

        String[] s6 = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};
        //Komparator<String> c6 = (x8,y8) -> x8.compareToIgnoreCase(y8);
        //Tabell.innsettingssortering(s6, c6.deretter(Komparator.omvendtOrden()));

        System.out.println(Arrays.toString(s6));
        // [kari, Kari, KARI, ole, Ole, OLE, per, Per, PER]

        /**
         * 1.4.8k -->
         */

        System.out.println("\n52--------------------");

        String[] s7 = {"OLE","Per","Kari","PER","Ole","kari","per","KARI","ole"};
        Arrays.sort(s7, Collator.getInstance(Locale.US));  // finnes ingen norsk versjon
        System.out.println(Arrays.toString(s7));
        // Utskrift: [kari, Kari, KARI, ole, Ole, OLE, per, Per, PER]

        /**
         * 1.4.9c --> bruker comparable grensesnittet til java i stedenfor komparable som vi laget
         */

        System.out.println("\n53--------------------");

        String[] s12 = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> c12 =  Comparator.comparing(String::length);  // etter lengde
        Tabell.innsettingssortering(s12, c12.thenComparing(x12 -> x12));       // vanlig orden
        System.out.println(Arrays.toString(s12));                        // skriver ut

        /**
         * 1.4.9d
         */

        Comparator<Point> c54 = (p1, p2) ->
        {
            int d54 = p1.x - p2.x;    // forskjellen mellom x-koordinatene
            if (d54 != 0) return d54;
            return p1.y - p2.y;     // forskjellen mellom y-koordinatene
        };

        System.out.println("\n54--------------------");

        /*Comparator<Point> c56 = Comparator.comparing(Point::getX).thenComparing(Point::getY);

        int[] x7 = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y7 = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i2 = 0; i2 < punkt.length; i2++) punkt[i] = new Point(x7[i],y7[i]);

        for (Point p3 : punkt) System.out.print("(" + p3.x + "," + p3.y + ") ");
        System.out.println();                    // linjeskift

        Tabell.innsettingssortering(punkt,
                Comparator.comparing(Point::getX).thenComparing(Point::getY));

        for (Point p3 : punkt) System.out.print("(" + p3.x + "," + p3.y + ") ");*/

        // Utskriften blir:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (2,5) (3,3) (4,1) (4,4) (5,6) (6,3) (6,5) (7,2) (7,4)


        /**
         * 1.4.9h --> main metode ift. 1.4.9g
         */

        System.out.println("\n55--------------------");

        Dato[] d78 = new Dato[5];           // en datotabell
        d78[0] = new Dato(24,12,2014);      // 24/12-2014
        d78[1] = new Dato(24,12,2012);      // 24/12-2012
        d78[2] = new Dato(9,12,2013);       // 9/12-2013
        d78[3] = new Dato(25,12,2012);      // 25/12-2012
        d78[4] = new Dato(10,12,2013);      // 10/12-2013

        Tabell.innsettingssortering(d);
        for (Dato x72 : d78)
            System.out.print(x72 + " ");

        // Utskrift: 24/12-2012 25/12-2012 9/12-2013 10/12-2013 24/12-2014

        /**
         * 1.5.1a --> eksempel på kjøring av metoden 1.5.1a
         */

        System.out.println("\n56--------------------");
        System.out.println(Tabell.a(2));

        /**
         * 1.5.1b --> kjører eksempe 2 av rekursiv metode
         */

        System.out.println("\n57--------------------");

        System.out.println(Tabell.tverrsum(0));               // Utskrift: 0
        System.out.println(Tabell.tverrsum(72416));           // Utskrift: 20
        System.out.println(Tabell.tverrsum(2147483647));      // Utskrift: 46


        /**
         * 1.5.1c --> eksempel på kjøring av metoden
         */

        System.out.println("\n58--------------------");

        int a47 = 480, b47 = 126;
        System.out.println(Tabell.euklid(a47,b47));     // Utskrift: 6

        /**
         * 1.5.1d --> eksempel på kjøring av metoden
         */

        System.out.println("\n59--------------------");

        System.out.println(sum(100));      // Utskrift>: 5050

        /**
         * 1.5.1f --> eksempel på kjøring av metoden
         */

        System.out.println("\n60--------------------");

        int[] a68 = randPerm4(100);       // en permutasjon av tallene fra 1 til 100
        //System.out.println(Tabell.sum(a68,a68.length));  // Utskrift: 5050

        /**
         * 1.5.1g --> eksempel på kjøring av metoden (dette gir samme resultat som 1.5.1d
         */

        System.out.println("\n61--------------------");

        int[] a99 = randPerm4(100);       // en permutasjon av tallene fra 1 til 100
        System.out.println(sum(a99,0,a99.length-1));  // Utskrift: 5050

        /**
         * 1.5.1h --> eksempel på main
         */

        System.out.println("\n62--------------------");

        System.out.println(fib(10));     // Utskrift: 55
        System.out.println(fib(20));     // Utskrift: 6765

        /**
         * 1.5.2d --> main ift. 1.5.2c
         */

        System.out.println("\n63--------------------");

        System.out.println("main() starter!");
        int sum2 = tverrsum2(7295);
        System.out.println("main() er ferdig!");


        int n = 2000;
        System.out.println(sum(n));  // metoden fra Programkode 1.5.1 g)

        /**
         * 1.5.5b --> bruker metoden 1.5.5a
         */

        System.out.println("\n64--------------------");

        int[] a87 = {1,2,3,4};
        perm(a87,0);

        /**
         * 1.5.6e
         */

        System.out.println("\n65--------------------");


        Integer[] a79 = {1,2,3,4};              // Integer-tabell
        //perm(a79,0, p79 -> Tabell.skrivln2(p79));    // et lambda-uttrykk som argument

        /**
         * 1.5.6c
         */

        int[] a38 = {3,0,1,2,4,5,6,7};           // dronning i kolonne 3 og rad 0

        int n38 = a38.length;                      // hjelpevariabel

        boolean[] b38 = new boolean[2*n38-1];      // bidiagonaler
        boolean[] d38 = new boolean[2*n38-1];      // diagonaler

        b38[3] = true;                           // markerer i bidiagonalen
        d38[-3 + n38 - 1] = true;                  // markerer i diagonalen

        //System.out.println(Dronning.antall(a38,1,b38,d38));   // Utskrift: 18

        /**
         * 1.5.6d
         */

        for (int n39 = 8; n < 17; n++) {
            long tid39 = System.currentTimeMillis();
            //int antall39 = Dronning.antallR(n39);
            tid39 = System.currentTimeMillis() - tid39;
            //System.out.printf("%2d%12d%10d\n",n39,antall39,tid39);
        }

        /**
         * 1.5.9b
         */

        Tabell.HanoisTårn('A', 'B', 'C', 3);

        double[] d88 = {1,2,3};      // lovlig, 1 gjøres om til 1.0, osv.
        int[] a84 = {(int)1.0,(int)2.0,(int)3.0};   // ulovlig, kan ikke gjøre om fra double til int


        System.out.println(Arrays.toString(a84));

        /**
         * 1.5 Oppgaver
         */

        System.out.println("\n66--------------------");

        //Oppgave 1.5.1 --> 7
        System.out.println(Tabell.kvadratsum(4));



        /**
         * 1.6.2a --> arraycopy
         */

        System.out.println("\n67--------------------");

        int[] a58 = {1, 2, 3};
        //a58[3] = 4;    // må fjernes, gir ArrayIndexOutOfBoundsException

        int[] b58 = new int[2*a58.length];         // b dobbelt så stor som a

        System.arraycopy(a58,0,b58,0,a58.length);    // kopierer a over i b
        a58 = b58;                                 // a er "utvidet"
        a58[3] = 4;                              // nå er dette ok

        /**
         * 1.6.2b --> arrayCopy
         */

        System.out.println("\n68--------------------");

        int[] a89 = {1,2,3};
        //a89[3] = 4;    // må fjernes, gir ArrayIndexOutOfBoundsException

        a89 = Arrays.copyOf(a89, 2*a89.length);
        a89[3] = 4;    // nå er dette ok
        System.out.println(Arrays.toString(a89));

        /**
         * 1.6.2c --> copyOfRange
         */

        System.out.println("\n69--------------------");

        String[] s88 = {"Per","Kari","Ola"};
        s88 = Arrays.copyOfRange(s88, 2, 4);  // lengde 4 - 2 = 2;
        s88[1] = "Åse";
        System.out.println(Arrays.toString(s88));  // [Ola, Åse]

        /**
         * 1.6.2d --> fill og equals
         */

        System.out.println("\n70--------------------");

        int[] a91 = new int[5];                     // a = {0,0,0,0,0}
        Arrays.fill(a91, 1);                  // a = {1,1,1,1,1}

        int[] b91 = {1,1,1,1,1};
        int[] c91 = {1,2,3,4,5};

        boolean x91 = Arrays.equals(a91, b91);    // x = true
        boolean y91 = Arrays.equals(a91, c91);    // y = false


        /**
         * 3.2.2c
         */

        String[] navn2 = {"Per", "Kari", "Ole", "Azra"};
        Liste<String> liste = new TabellListe<>(navn2);

        /**
         * 3.2.4 --> oppgave 2
         */

        System.out.println("\n71--------------------");

        String[] s72 = {"Jens","Per","Kari","Ole","Berit","Jens","Anne","Nils","Siv"};

        Liste<String> liste72 = new TabellListe<>();

        for (String navn72 : s72) liste72.leggInn(0,navn72);  // legger inn først

        System.out.println("Vi henter " + liste72.hent(6) + ".");

        System.out.println("Nils er på plass " + liste72.indeksTil("Nils") + "!");

        liste72.oppdater(2,"Anna");  // bytter ut Anne med Anna på plass 2

        System.out.println(liste72.fjern(0) + " er slettet!");

        System.out.println("Listeinnhold: " + liste72);

        //liste72.fjernHvis(x72 -> x72.equals("Jens"));  // fjerner alle forekomster av Jens

        //liste72.forEach(x72 -> System.out.print(x72 + " "));

        /**
         * 3.2.5a
         */

        System.out.println("\n72--------------------");

        /*String[] s73 = {"Per","Kari","Ole"};

        Liste<String> liste73 = new TabellListe<>();

        for (String navn73 : s73) liste.leggInn(navn73);

        System.out.println(liste73);

        // Utskrift: [Per, Kari, Ole]

        Iterator<String> i75 = liste.iterator();     // oppretter en iterator i
        Iterator<String> j75 = liste.iterator();     // oppretter en iterator j

        System.out.println(i75.next());              // den første i listen
        i75.remove();                                // fjerner den første
        System.out.println(j75.next());              // den første i listen*/



        /**
         * 3.2.5b
         */

        /*System.out.println("\n73--------------------");

        Iterator<String> i74 = liste.iterator();     // oppretter en iterator
        System.out.println(i74.next());              // den første i listen

        liste.fjern("Per");                        // fjerner den første
        System.out.println(i74.next());              // den neste i listen*/


        /**
         * 3.2.6a --> eksempel på hvordan ArrayList
         */

        /*System.out.println("\n74--------------------");

        List<Integer> liste1 = new ArrayList<>();
        for (int i76 = 1; i76 <= 5; i76++) liste1.add(i76);  // tallene fra 1 til 5

        List<Integer> liste2 = new ArrayList<>();
        for (int i76 = 6; i76 <= 10; i76++) liste2.add(i76);  // tallene fra 6 til 10

        liste1.addAll(0,liste2);   // liste2 legges forrest i liste 1
        System.out.println(liste1);  // [6, 7, 8, 9, 10, 1, 2, 3, 4, 5]

        liste1.removeAll(liste2);   // fjerner tallene fra 6 til 10
        System.out.println(liste1);  // [1, 2, 3, 4, 5]

        ListIterator<Integer> i76 = liste1.listIterator(4);  // bakerst
        while (i76.hasPrevious()) System.out.print(i76.previous() + " ");
        System.out.println();  // 4 3 2 1

        Integer[] a76 = new Integer[liste1.size()];
        Integer[] b76 = liste1.toArray(a76);
        System.out.println(Arrays.toString(a76));  // [1, 2, 3, 4, 5]*/

        /**
         * 3.2.2 --> Oppgave 2
         */

        System.out.println("\n75--------------------");

        String[] s2 = {"Kristian", "Anne", "Nikola", null, null};
        Liste<String> liste22 = new TabellListe<>(s2);
        System.out.println(Arrays.toString(s2));

        /**
         * 3.2.2. --> Oppgave 3
         */

        System.out.println("\n76--------------------");

        String[] s47 = {"Sohil","Per","Thanh","Ann","Kari","Jon"};
        String[] s48 = {};
        //Liste<String> liste47 = new TabellListe<>(s48);

        //FIXME: hvorfor funker dette aldri??
        System.out.println(Arrays.toString(s48));

        /**
         * 4.1.2e
         */

        System.out.println("\n77--------------------");

        Stakk<Integer> s92 = new TabellStakk<>();
        for (int k92 = 1; k92 <= 1000; k92++) s92.leggInn(k92);

        /**
         * 4.1.2f
         */

        System.out.println("\n78--------------------");

        Stack<Character> s93 = new Stack<>();         // oppretter en stakk

        s93.push('A'); s93.push('B'); s93.push('C');      // legger inn tre verdier

        while (!s93.isEmpty()) System.out.print(s93.pop() + " ");  // tar ut

        // Utskrift: C B A

        /**
         * 4.1.3d
         */

        System.out.println("\n79--------------------");

        long tid2 = System.currentTimeMillis();

        Stakk<Integer> s94 = new LenketStakk<>();
        Integer k94 = 0;

        for (int i94 = 0; i94 < 10000000; i94++) s94.leggInn(k94);
        while (!s94.tom()) s94.taUt();

        tid2 = System.currentTimeMillis() - tid2;
        System.out.println(tid2);

        /**
         * 4.1.4b
         */

        System.out.println("\n80--------------------");

        Deque<Character> s96 = new ArrayDeque<>();  // oppretter en stakk

        s96.push('A'); s96.push('B'); s96.push('C');        // legger inn tre verdier

        while (!s96.isEmpty())
            System.out.print(s96.pop() + " ");  // tar ut

        // Utskrift: C B A

        /**
         * 4.2.2 --> bruker en kø til å snu rekkefølgen på objektene i stakk
         */

        System.out.println("\n81--------------------");

        /*Stakk<Character> s23 = new TabellStakk<>();
        Kø<Character> k23 = new TabellToveiskø<>();

        s23.leggInn('A');
        s23.leggInn('B');
        s23.leggInn('C');

        while (!s23.tom()) k23.leggInn(s23.taUt());
        while (!k23.tom()) s23.leggInn(k23.taUt());

        System.out.println(s23);  // Utskrift: [A, B, C]*/


        /**
         * 4.2.4c
         */

        System.out.println("\n82--------------------");

        //Kø<Integer> kø = new EnkeltLenketListe<>();

        //for (int i44 = 1; i44 <= 10; i44++) kø.leggInn(i44);

        //while (!kø.tom()) {
        //    System.out.print(kø.taUt() + " ");


        /**
         * 4.2.5b
         */

        System.out.println("\n83--------------------");

        //Eksempel på at man kan bruke ArrayDeque
        Character[] bokstaver = {'A','B','C'};                      // bokstaver
        Queue<Character> kø = new ArrayDeque<>();                   // oppretter en kø
        for (char c5 : bokstaver) kø.offer(c5);                       // bruker offer, legger inn bakerst
        while (!kø.isEmpty()) System.out.print(kø.poll() + " ");    // tar ut med poll, tar ut den første

        System.out.println();

        //Kan også bruke LinkedList og få samme resultat, men ArrayDeque er vanligvis mer effektiv
        Character[] bokstaver2 = {'A','B','C'};                      // bokstaver
        Queue<Character> kø2 = new LinkedList<>();                   // oppretter en kø
        for (char c6 : bokstaver2) kø2.add(c6);                         // bruker add
        while (!kø2.isEmpty()) System.out.print(kø2.remove() + " ");  // tar ut med remove


        /**
         * 4.3.4b --> Både ArrayDeque og LinkedList kan brukes som en toveiskø. Her er et eksempel der ArrayDeque brukes:
         */

        System.out.println("\n84--------------------");

        Deque<Integer> toveiskø = new ArrayDeque<>();

        toveiskø.offerFirst(3);
        toveiskø.offerLast(4);
        toveiskø.offerFirst(2);
        toveiskø.offerLast(5);
        toveiskø.offerFirst(1);
        toveiskø.offerLast(6);

        while (!toveiskø.isEmpty()) {
            System.out.print(toveiskø.pollFirst() + " ");
        }

        // Utskrift 1 2 3 4 5 6

        /**
         * 4.4.2h --> viser hvordan klasse UsortertTabellPrioritetsKø kan brukes
         */

        System.out.println("\n85--------------------");

        char[] c7 = "VMUSXQCJKOATZPLDHIRBNFEGYW".toCharArray();

        PrioritetsKø<Character> kø7
                = UsortertTabellPrioritetsKø.naturligOrdenKø();

        for (int i7 = 0; i7 < c7.length; i7++) kø7.leggInn(c7[i7]);

        while (!kø7.tom()) System.out.print(kø7.taUt() + " ");

        // Utskrift:  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

        /**
         * 4.4.5 --> eksempel på bruk av klassen PriorityQueue
         */

        System.out.println("\n86--------------------");

        Comparator<Integer> c83 = Comparator.naturalOrder();       // en komparator

        PriorityQueue<Integer> prkø = new PriorityQueue<>(5,c83);  // plass til 5

        int[] a83 = {3,5,2,4,1};
        for (int k8 : a83) prkø.offer(k8);   // legger inn

        while (!prkø.isEmpty()) {
            System.out.print(prkø.poll() + " ");   // tar ut
        }

        // Utskrift: 1 2 3 4 5

    }

}


