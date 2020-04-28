package Oblig.Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    /**
     * OPPGAVE 1
     *
     * I undervisningen har vi sett på ulike teknikker for å finne posisjonen til den største verdien i en tabell.
     * I denne oppgaven skal det brukes en annen teknikk. Men siden denne teknikken endrer tabellen, er det selve
     * verdien som skal returneres (og ikke posisjonen). Lag metoden ​public​ ​static​ ​int​ ​maks​(​int​[] a)​. Den skal finne
     * og returnere den største ​verdien​ (ikke posisjonen) i parametertabellen ​a​. Du skal bruke følgende teknikk:
     *
     * 1. Sammenlign først ​a[0]​ og ​a[1]​. Hvis ​a[0]​ > ​a[1]​, bytter de to verdiene plass (en ombytting).
     * 2. Sammenlign så ​a[1]​ og ​a[2]​. Hvis ​a[1]​ > ​a[2]​, bytter de to plass.
     * 3. Fortsettmeda[2]oga[3]etc.helttilsluttenavtabellen
     *
     * Når denne prosessen er ferdig, vil tabellens største verdi ligge bakerst (sjekk at det stemmer).
     * Dermed kan den verdien returneres. Det skal kastes en ​NoSuchElementException​ (med en passende tekst) hvis
     * tabellen ​a​ er tom (har lengde 0). En tom tabell har ingen verdier og dermed ingen største verdi.
     *
     * I en metode av typen ​maks​ er det først og fremst antall sammenligninger av tabellverdier vi er opptatt av.
     * Hvor mange (som funksjon av ​n​) blir det for en tabell med ​n​ verdier.
     *
     * Men det har også interesse å finne antall ombyttinger. En ombytting er en relativt kostbar operasjon. Anta
     * at tabellen ​a​ inneholder en tilfeldig permutasjon av tallene fra 1 til ​n​.
     *
     * ● Når blir det flest ombyttinger?
     * ● Når blir det færrest?
     * ● Hvor mange blir det i gjennomsnitt?
     *
     * For å finne svaret på det siste spørsmålet skal du lage en metode som bruker samme teknikk som maks-metoden,
     * men den skal isteden telle opp ombyttingene. Antallet ombyttinger skal returneres. La den hete ​public​ ​static​
     * ​int​ ​ombyttinger​(​int​[] a)​. Da trenger du en hjelpevariabel som øker med 1 for hver ombytting og det er verdien
     * til den som skal returneres. Lag tilfeldige permutasjoner av tallene fra 1 til ​n​ og bruk så metoden. På den
     * måten kan du få en indikasjon på hvor mange det blir i gjennomsnitt (det finnes en formel for gjennomsnittet).
     * Kan du på grunnlag av dette si om metoden ​maks​ er bedre (eller dårligere) enn de maks-metodene vi har sett
     * på tidligere?
     */
    public static int maks(int[] a) {


        if(a.length == 0){
            throw new NoSuchElementException("Tabellen er tom");
        }

        int temp = 0;   //for mellomlagring av verdi

        for(int i = 0; i<a.length-1; i++){
            if(a[i]>a[i+1]){    //sammenligner et element, og elementet ved siden av
                temp = a[i];    //mellomlagrer a[i]
                a[i] = a[i+1];  //setter a[i] til å være neste element
                a[i+1] = temp;  //setter a[i] til å være temp, veriden vi mellomlagret
            }
        }

        int maks = a[a.length-1];   //maksverdi er da: verdien av siste element i arrayet
        return maks;

    }

       /*
    - Når blir det flest ombyttinger?
      Når største verdi ligger først.

    - Når blir det færrest?
      Når største verdi ligger bakerst.

    - Hvor mange blir det i gjennomsnitt?

        Hvor mange operasjoner det blir i gjennomsnitt:
        12+12n+9*log(n)-0,423

        I gjennomsnitt antall a[i]>a[i+1] er sann,
        altså hvor mange ombyttinger i gjennomsnitt: log(n)-0,423

     */


    public static int ombyttinger(int[] a) {

        if(a.length == 0){
            throw new NoSuchElementException("Tabellen er tom");
        }

        int temp = 0;
        int antallOmbyttinger = 0;

        for(int i = 0; i<a.length-1; i++){
            if(a[i]>a[i+1]){
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                antallOmbyttinger++;
            }
        }

        int maks = a[a.length-1];
        return antallOmbyttinger;
    }


    /*
    - Indikasjon på hvor mange det blir i gjennomsnitt.
      Er metoden maks bedre(eller dårligere) enn de maks-metodene
      vi har sett på tidligere?

        Mindre effektiv da den har flere antall operasjoner:
        12+12n+9*log(n)-0,423

     */

    /**
     * OPPGAVE 2
     *
     * Lag metoden ​public​ ​static​ ​int​ ​antallUlikeSortert​(​int​[] a)​. Hvis ​a​ ikke er sortert stigende,skal det kastes en
     * I​llegalStateException​(medenpassendetekst).Tabellen ​a kan ha like verdier. Metoden skal returnere antallet
     * forskjellige verdier i ​a​. Hvis f.eks. ​a inneholder 3, 3, 4, 5, 5, 6, 7, 7, 7 og 8, skal metoden returnere 6
     * siden det er 6 forskjellige verdier. Metoden skal ​ikke​ endre noe på tabellens innhold. Pass på at hvis
     * tabellen er tom (har lengde 0), skal metoden returnere 0 siden det er 0 forskjellige verdier i en tom tabell.
     * Med andre ord er ikke en tom tabell en feilsituasjon.
     */
    public static int antallUlikeSortert(int[] a) {
        int antallUlike = 1;

        if (a.length == 0){  //Sjekker om array er tomt, isåfall returneres 0
            return 0;
        }

        for(int i = 0; i< a.length-1; i++){     //Sjekker om arrayet er sortert
            if(a[i] > a[i+1]){
                throw new IllegalStateException("Tabellen er ikke sortert stigende");
            }
        }

        for(int i = 0; i<a.length-1; i++){  //Sjekker antall unike tall
            if(a[i] < a[i+1]){
                antallUlike++;
            }
        }

        return antallUlike;
    }

    /**
     * OPPGAVE 3
     *
     * Lag metoden ​public​ ​static​ ​int​ ​antallUlikeUsortert​(​int​[] a)​. Tabellen ​a​ kan nå være en hvilken som helst
     * heltallstabell, dvs. den behøver ikke være sortert. Den kan også ha flere like verdier. Metoden skal finne
     * og returnere antallet forskjellige verdier i ​a.​ Metoden skal ​ikke​ endre noe på tabellens innhold.
     * Hvis ​a​ f.eks. inneholder tallene 5, 3, 7, 4, 3, 5, 7, 8, 6 og 7, skal metoden returnere 6 siden det er 6
     * forskjellige verdier. Pass på at hvis tabellen er tom (har lengde 0), skal metoden returnere 0 siden det
     * er 0 forskjellige verdier i en tom tabell. Metoden skal ​ikke bruke hjelpetabeller​. At arbeidet skal foregå
     * innenfor tabellen ​a​. Du kan selvfølgelig bruke en eller flere hjelpevariabler.
     */

    public static int antallUlikeUsortert(int[] a) {

        // Sjekker for tomt array:

        if(a.length == 0){
            return 0; // Tom liste gir 0 unike tall
        }

        // teller  i for-loekke og int ulike starter paa 1 siden foerste
        // element alltid vil vaere unikt,
        // pluss kan da angi a-1 uten aa komme utenfor array:

        int ulike = 1; // Foerste element vil vaere unikt.

        for(int i = 1; a.length > i ; i++){

            boolean tallFinnes = finnesFraFoer(a, a[i], i-1);
            if (tallFinnes){
            } else {
                ulike = ulike + 1;
            }
        }

        System.out.println("Antall ulike er " + ulike);
        return ulike;
    }

//    finnesFraFoer(int[], int, int) gaar gjennom arrayet fra start frem til elementet
//    foer det tallet vi vurderer om er unikt, og gir true dersom det allerede finnes i
//    listen og false dersom det ikke allerede finnes i listen.
//    sjekke om denne allerede finnes i kode...:

    public static boolean finnesFraFoer(int[] a, int tall, int til){

        for(int i = 0; i <= til; i++){
            if(tall == a[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * OPPGAVE 4
     *
     * Lag metoden ​public​ ​static​ ​void​ ​delsortering​(​int​[] a)​. Den skal dele parametertabellen ​a​ i to sorterte deler.
     * Venstre del skal inneholde oddetallene sortert og høyre del partallene sortert.
     * Flg. eksempel viser hvordan den skal virke:
     *
     * ​int​[] a = {6,10,9,4,1,3,8,5,2,7};
     * delsortering(a);
     * System.​out​.println(Arrays.​toString​(a));
     * // Utskrift: [1, 3, 5, 7, 9, 2, 4, 6, 8, 10]
     *
     * Tabellen ​a​ kan være tom (det er ingen feilsituasjon), inneholde både negative og positive tall, kun
     * oddetall eller kun partall. ​Metoden skal ikke bruke hjelpetabeller​. Men en eller flere hjelpevariabler
     * kan inngå. Lag den så effektiv som mulig.
     */

    public static void delsortering(int[] a) {

        if(a.length == 0) {
            return;
        }

        int antallPartall = 0;
        int antallOddetall = 0;
        int teller = 0;
        int temp = 0;


        //teller antall partall og oddetall
        for(int i = 0; i<a.length; i++){
            if(a[i] % 2 == 0) {
                antallPartall++;
            }
            else {
                antallOddetall++;
            }
        }

        //forsøk på å sortere oddetallene hvis det KUN er de som er i tabellen
        if (a.length == antallOddetall) {
            sortering(a);
        }


        //forsøk på å sortere oddetallene hvis det KUN er de som er i tabellen
        else if (a.length == antallPartall) {
            sortering(a);
        }

        else{
            for(int i = 0; i<a.length; i++){  //hvis det er oddetall skal den legge tallet som opprinnelig var der om temp og den bytter plass med partall???
                if(a[i] % 2 != 0){              //hvis den finner oddetall, så.....
                    temp = a[teller];           //teller er først 0 (det er plassen der det første oddetallet skal være
                    a[teller] = a[i];           //når den finner oddetall går tallet (a[i]) det første oddetallet til teller (indeksen den skal ligge på)
                    a[i] = temp;                //da blir oddetallet lik temp (teller 0)
                    teller++;                   //så går man videre i arrayet til teller = 1 (2 tallet i arrayet) og finner det andre oddetallet og setter det der, osv osv.
                }
            }

            //Quicksortering
            utvalgssortering4(a, 0, antallOddetall);
            utvalgssortering4(a, antallOddetall, a.length);
        }
    }
    public static void utvalgssortering4(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < til - 1; i++) {
            bytt(a, i, min(a, i, til));  // to hjelpemetoder
        }
    }

    public static void bytt(int[] a, int i, int j) { //returnerer ny tabell hver gang den kalles
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sortering(int[] a) {
        for (int i = a.length; i > 1; i--) {
            int m = maks( a, 0, i );
            bytt( a, i - 1, m );
        }
    }

    public static int maks(int[] a, int fra, int til) {

        if (a == null) throw new NullPointerException
                ( "parametertabellen a er null!" );

        fratilKontroll( a.length, fra, til );

        if (fra == til) throw new NoSuchElementException
                ( "fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!" );

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (a[i] > maksverdi) {
                m = i;               // indeks til største verdi oppdateres
                maksverdi = a[m];    // største verdi oppdateres
            }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    /**
     * OPPGAVE 5
     * Det kan være aktuelt å «rotere» elementene i en tabell. En rotasjon på én enhet gjøres ved at det siste
     * elementet blir det første og alle de andre forskyves én enhet mot høyre.
     *
     * På figuren over har elementene i den første tabellen blitt «rotert» én enhet.
     * Lag metoden public​ ​static​ ​void​ ​rotasjon​(​char​[] a)​. Den skal «rotere» innholdet i tabellen ​a​ én enhet.
     * En rotasjon i en tom tabell eller i en tabell med nøyaktig ett element er ingen feilsituasjon.
     * Men rotasjonen vil da ikke endre noe.
     */

    public static void rotasjon(char[] a) {

        // får hjelpevariabel n som er lengden til a.
        int n = a.length;

        // Her sjekker vi om lengden til a  er stor nok til å kunne
        // gjøre en rotasjon. Ingenting skjer om n er mindre enn 2.
        if (n<2) return;

        // char b er hjelpevariabel som kopierer den siste i a.
        char b = a[n-1];

        // Under forflytter alle bokstavene i a et steg til høyre
        for (int i = n - 1; i >= 1; i--) {
            a[i] = a[i-1];
        }
        // Første indeks i a blir her satt til b, som var siste indeks før
        // rotasjonen.
        a[0] = b;
    }

    /**
     * OPPGAVE 6
     *
     * Her skal vi gå videre fra ​Oppgave​ 5. Hvis vi tenker oss at tabellen er «bøyd til en sirkel», er det mer
     * naturlig å se på dette som en rotasjon. Dermed kan vi «rotere» et valgfritt antall enheter.
     * Lag metoden ​public​ ​static​ ​void​ ​rotasjon​(​char​[] a, ​int​ k)​ der ​k​ er et vilkårlig heltall. Hvis ​k​ = 1,
     * skal metoden ha samme effekt som metoden i ​Oppgave​ 5. Hvis ​k​ er negativ, skal rotasjonen gå motsatt vei.
     * En rotasjon i en tom tabell eller i en tabell med nøyaktig ett element er ingen feilsituasjon.
     * Men rotasjonen vil da ikke endre noe. Det er ingen grense på størrelsen til ​k​. Målet er å gjøre metoden
     * så effektiv som mulig. Følgende programbit viser hvordan metoden skal virke:
     *
     * ​char​[] a = {​'A'​,​'B'​,​'C'​,​'D'​,​'E'​,​'F'​,​'G'​,​'H'​,​'I'​,​'J'​};
     * System.​out​.println(Arrays.​toString​(a));
     * ​rotasjon(​ a,3); System.​out​.println(Arrays.​toString(​ a)); ​
     * rotasjon(​ a,-2); System.​out​.println(Arrays.​toString(​ a));
     *
     * Utskrift:
     * ​[A, B, C, D, E, F, G, H, I, J]​ ​originaltabellen
     * [H, I, J, A, B, C, D, E, F, G]​ ​en rotasjon på tre enheter mot høyre
     * [J, A, B, C, D, E, F, G, H, I]​ en rotasjon to enheter mot venstre
     */

    public static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (n<2) {
            return; }
        k %= n;
        char[] b = new char[Math.abs(k)];
        int c = 0;

        // mot høyre
        if (k > 0) {
            for (int i = n - k; i < n; i++) {
                b[c++] = a[i];
            }
            for (int i = n - k - 1; i >= 0; i--) {
                a[k + i] = a[i];
                if (i < k) {
                    a[i] = b[i];
                }
            }
            // mot venstre
        } else if (k<0) {
            k = Math.abs(k);
            // Fra i = 0, mens i er mindre enn antall rotasjoner,
            // 1 øker for hver gang. Vi kopierer
            for(int i = 0; i<k; i++){
                b[i] = a[i];
            }

            for(int i = 0; i <= n-k-1; i++){
                a[i] = a[k+i];
            }

            for(int i = 0; i < b.length; i++){
                a[n-i-1] = b[k - i - 1];
            }
        }
    }

    /**
     * OPPGAVE 7a
     *
     * a)​ Lag metoden ​public​ ​static​ String ​flett​(String s, String t)​. Den skal «flette» sammen tegnstrengene ​s​ og ​t​
     * slik at resultatet blir en tegnstreng der annethvert tegn kommer fra ​s​ og annethvert fra ​t.​ Hvis ​s​ og ​t​ har
     * ulik lengde, skal det som er «til overs» legges inn bakerst. Resultatet skal returneres. Flg. eksempel
     * viser hvordan det skal virke:
     *
     * String a = ​flett​(​"ABC"​,​"DEFGH"​);
     * String b = ​flett​(​"IJKLMN"​,​"OPQ")​ ;
     * String b = ​flett​(​""​,​"AB"​);
     * System.​out.​ println(a + ​"​ ​"​ + b + ​"​ ​"​ + c);
     * ​// Utskrift: ADBECFGH IOJPKQLMN AB
     */

    public static String flett(String s, String t) {

        int k = Math.min( s.length(), t.length() );

        StringBuilder sp = new StringBuilder();

        for (int i = 0; i < k; i++) {

            sp.append( s.charAt( i ) ).append( t.charAt( i ) );
        }

        sp.append( s.substring( k ) ).append( t.substring( k ) );

        return sp.toString();
    }

    /**
     * OPPGAVE 7b
     *
     * b)​ Lag metoden ​public​ ​static​ String ​flett​(String... s)​. Den skal «flette» sammen tegnstrengene i ​s​.
     * Husk at ​s​ nå er en tabell av tegnstrenger. I koden vil derfor ​s[0]​ være første streng i tabellen ​s​, osv.
     * Flettingen skal være slik: Først hentes fortløpende det første tegnet fra hver tegnstreng, deretter
     * fortløpende det andre tegnet, osv. De tegnstrengene som er «brukt opp», dvs. vi er ferdige med alle tegnene der,
     * hoppes over. Resultatet skal returneres. Flg. eksempel viser hvordan den skal virke:
     *
     * String a = ​flett​(​"AM "​,​"L"​,​"GEDS",​ ​"ORATKRR"​,​""​,​"R TRTE"​,​"IO"​,​"TGAUU"​);
     * System.​out.​ println(a);
     * ​// Utskrift: ALGORITMER OG DATASTRUKTURER
     */

    public static String flett(String... s) {

        int storstelength = 0;

        for (int i = 0; i < s.length; i++) { //finner største string length i s Arrayet

            if (s[i].length() > storstelength) {

                storstelength = s[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= storstelength; i++) {

            for (int j = 0; j <= s.length - 1; j++) {

                if (i <= s[j].length()) {

                    sb.append( s[j].charAt( i - 1 ) );
                }
            }
        }
        return sb.toString();

    }

    /**
     * OPPGAVE 8
     *
     * Lag metoden ​public​ ​static​ ​int​[] ​indekssortering(​ ​int​[] a)​. Den skal returnere en tabell med indekser til
     * verdiene i tabellen ​a​ der ​a​ ​ikke​ skal endres. Se på. flg. eksempel:
     *
     * ​int​[] a = {6,10,16,11,7,12,3,9,8,5};
     * ​int​[] indeks = ​indekssortering(​ a);
     * System.​out.​ println(Arrays.​toString​(a)); ​// skriver ut a
     * System.​out.​ println(Arrays.​toString​(indeks)); ​// skriver ut indeks
     * ​// Utskrift: [6, 10, 16, 11, 7, 12, 3, 9, 8, 5] a er ikke endret
     * ​// Utskrift: [6, 9, 0, 4, 8, 7, 1, 3, 5, 2]
     *
     * Første verdi i indeks-tabellen, dvs. ​indeks[0]​, skal være indeksen til den minste verdien i ​a​.
     * Vi ser av utskriften at det er 6 og det passer siden den minste verdien i ​a​ (dvs. 3) har indeks 6.
     * Neste verdi i indeks-tabellen, dvs. ​indeks[1]​ skal være indeksen til den nest minste verdien i ​a​.
     * Utskriften gir at ​indeks[1]​ = 9 og den nest minste verdien i ​a​ (dvs. 5) har indeks 9. Osv. til den siste.
     * Det er 2 som er indeksen til den største verdien (dvs. 16) i ​a​.
     *
     * På denne måten kan vi få ut verdiene i ​a​ i sortert rekkefølge ved å gå veien om indeks-tabellen. Dvs. slik
     * ​int​[] a = {6,10,16,11,7,12,3,9,8,5};
     * ​int​[] indeks = ​indekssortering(​ a);
     * ​for​ (​int​ i = 0; i < a.​length​; i++) System.​out.​ print(a[indeks[i]] + ​"​ ​"​);
     * ​// Utskrift: 3 5 6 7 8 9 10 11 12 16
     *
     * Dette kan løses på flere måter. Her blir det ikke lagt vekt på effektivitet, men kun på at det virker.
     * Du kan også bruke hjelpetabeller - en eller flere. Opprett i hvert fall en tabell ​indeks ​av typen ​int[]​
     * med samme lengde som ​a​. Det er den som til slutt skal returneres. Tabellen ​a​kan inneholde like verdier!
     * I så fall blir det ingen entydig løsning. Hvis f.eks. den minste verdien
     * forkommer to ganger, spiller det ingen rolle hvem av dem ​indeks[0]​ refererer til. Men da må ​indeks[1]​
     * referere til den andre av de to. Hvis ​a​ er tom, skal også returtabellen være tom.
     */

    public static int[] indekssortering(int[] a) {

        if (a.length == 0) return a;

        int[] temp = Arrays.copyOf( a, a.length );

        int[] indekser = new int[a.length];

        int maks = maksverdi( temp );
        int k = 0;

        for (int i = a.length; i > 1; i--) {
            int m = min( temp );
            indekser[k] = m;
            temp[m] = 2147483647;   //maks value for int
            k++;
        }
        indekser[temp.length - 1] = maks;

        for (int s : a) {
            System.out.print( s + " " );
        }
        return indekser;
    }

    /**
     * OPPGAVE 9
     *
     * Lag metoden ​public​ ​static​ ​int[]​ ​tredjeMin(​ ​int​[] a)​. Den skal finne ​indeksene​ til de tre
     * minste verdiene i tabellen ​a.​ Den skal returnere en tabell med tre verdier der første verdi skal
     * være indeksen til den minste verdien i ​a​, andre verdi indeksen til den nest minste i ​a​ og tredje
     * verdi indeksen til den tredje minste verdien i​a​. Bruk samme type idé som i
     * Programkode​ 1.2.5 ​a)​. Bruk tre hjelpevariabler for verdier og tre hjelpevariabler for indekser.
     * Gi dem korrekte startverdier ved hjelp av metoden ​indekssortering​()​ fra Oppgave 8. Den
     * kaller du på en tabell som KUN består av de tre første verdiene i ​a.​ ​Du skal IKKE
     * bruke ​indekssortering(​ )​ på hele ​a​. Det blir svært ineffektivt siden du da gjør en full sortering.
     * I den siste versjonen av testprogrammet ligger det en tidstest på Oppgave
     * 9.​Hvis tabellen​ah​ar færre enn tre elementer, skal det kastes en ​NoSuchElementException​ sammen med en passende tekst.
     * Metoden skal ikke endre noe på innholdet i ​a.​
     */

    public static int[] tredjeMin(int[] a) {
        int n = a.length;
        if (n < 3) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 3!");

        int[] førsteTreiA = Arrays.copyOfRange(a,0,3);

        int[]    index = indekssortering(førsteTreiA);

        int m = index[0];
        int nm = index[1];
        int nnm = index[2];

        int forsteMinsteVerdi = a[m];
        int andreMinsteVerdi = a[nm];
        int tredjeMinsteVerdi = a[nnm];

        for (int i = 3; i < n; i++) {

            if (a[i] < tredjeMinsteVerdi) { //Hvis a[i] er mindre enn trejminste så skal neste setning kjøres

                if (a[i] < andreMinsteVerdi) {  //Hvis a[i] er mindre enn nestminste verdi så skal neste setning kjøres

                    if (a[i] < forsteMinsteVerdi) {  //Hvis a[i] er mindre en minst verdi så skal ny verdi settes

                        nnm = nm;
                        tredjeMinsteVerdi = andreMinsteVerdi;

                        nm = m;
                        andreMinsteVerdi = forsteMinsteVerdi;

                        m = i;
                        forsteMinsteVerdi = a[m];

                    } else {
                        nnm = nm;
                        tredjeMinsteVerdi = andreMinsteVerdi;

                        nm = i;
                        andreMinsteVerdi = a[nm];
                    }
                } else {

                    nnm = i;
                    tredjeMinsteVerdi = a[nnm];
                }
            }
        }
        return new int[]{m, nm, nnm};//returnerer tabell med inndekser
    }

    /**
     * OPPGAVE 10
     *
     * Vi sier at et ord er inneholdt i et annet ord hvis hver bokstav i det første ordet forekommer minst like mange
     * ganger i det andre ordet som i det første, men ikke nødvendigvis i samme rekkefølge. F.eks. er ABBA inneholdt
     * i både ABBABBA, BARAB, BARBARER og RABARBRA. ABBA har to A-er og to B-er og minst så mange av de to bokstavene
     * har også de fire «ordene». Men ABBA er hverken inneholdt i BARBERER eller i AKROBAT. BARBERER har to B-er,
     * men kun én A og AKROBAT har to A-er, men kun én B. Lag metoden ​public static boolean​ ​inneholdt​(String a, String b)
     * ​ der ​a​ og ​b​ er «ord». Du kan ta som gitt at tegnstrengene ​a​ og ​b​ kun har store bokstaver (A − Å).
     * Metoden skal returnere ​true​ hvis ​a​ er inneholdt i ​b​ og ​false​ ellers. Vi tenker oss her at et «ord» rett
     * og slett er en oppramsing av bokstaver. Et «tomt» ord (en tom tegnstreng) er innholdt i alle andre ord
     * (tegnstrenger). Det er ingen grense på hvor lange ordene kan være. Lag metoden så effektiv som mulig.
     */

    // Passerer testene i testfilen

    public static boolean inneholdt(String a, String b) {

        //Den tomme strengen er inneholdt i alle andre strenger.
        // Ikke noe annet enn den tomme strengen kan vaere
        // inneholdt i en tom streng:

        if("".equals(a)){
            return true;
        } else if("".equals(b)){
            return false;
        }

        // sorterer begge strengene til char array med quicksort algoritme:
        char[] charArray1 = sorterStringTilChar(a);
        char[] charArray2 = sorterStringTilChar(b);

        // sjekker om streng a er inneholdt i streng b og lagrer resultatet i
        // variabelen resultat:
        boolean resultat = erInneholdt(charArray1, charArray2,
                charArray1.length, charArray2.length);

        return resultat;
    }

    public static boolean erInneholdt(char[] a, char[] b, int lengdeA, int lengdeB) {

        int i = 0;
        int j = 0;

        // vi sammenligner arrayene a og b saa lenge vi er innenfor lengden av begge.
        while(i < lengdeA && j < lengdeB) {

            // Saa lenge foerste char i a er stoerre enn foerste char i b
            // traverserer vi bare videre i b:
            if(a[i] > b[j]) {
                j++;
            }
            // Hvis foerste char i a og b er lik, gaar vi videre til neste char
            // i baade a og b og sammenligner denne.
            else if(a[i] == b[j]){
                i++;
                j++;
            }
            // Dersom foerste char i a er mindre enn foerste char i b kan ikke
            // a lenger vaere inneholdt i b og vi returnerer false.
            else if (a[i] < b[j]) {
                return false;
            }
        }
        // Hvis vi har sammenlignet de to arrayene saa langt uten aa returnere false,
        // returnerer testen true dersom det ikke gjenstaar flere chars i a som
        // ikke er matchet i b.
        if (i < lengdeA) {
            return false;
        }
        else {
            return true;
        }

    }

    public static char[] sorterStringTilChar(String a){

        // vi konverterer stringen til et char-array.
        char[] charArray = a.toCharArray();

        // vi finner foerste og siste posisjon i arrayet.
        int foerste = 0, siste = a.length() -1;

        // Vi sorterer arrayet med en quicksort-algoritme.
        quickSort(charArray, foerste, siste);

        return charArray;

    }


// QuickSort-algoritme hentet fra begynnelse paa implementasjon under forelesning,
// supplert fra pensumlitteratur og internett siden vi ikke ble ferdig under
// forelesning.

    public static void quickSort(char[] values, int left, int right){


        int i = left;
        int j = right;
        char temp;

        int pivot = (left + right) / 2;

        while (i <= j) {
            while(values[i] < values[pivot]){
                i++;
            }
            while(values[j] > values[pivot]){
                j--;
            }

            if(i <= j) {
                temp = values[i];
                values[i] = values[j];
                values[j] = temp;
                i++;
                j--;
            }
        }
        if(left < j){
            quickSort(values, left, j);
        }
        if(i < right){
            quickSort(values, i, right);
        }
    }




//---------------------------------------------------------------------------------------//


    //Her brukte jeg hjelpe metoder fra kompendiet:

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ( "fra(" + fra + ") er negativ!" );

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ( "til(" + til + ") > tablengde(" + tablengde + ")" );

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ( "fra(" + fra + ") > til(" + til + ") - illegalt intervall!" );
    }


    public static int min(int[] a, int fra, int til) {

        if (a == null) throw new NullPointerException
                ( "parametertabellen a er null!" );

        fratilKontroll( a.length, fra, til );

        if (fra == til) throw new NoSuchElementException
                ( "fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!" );

        int m = fra;             // indeks til minste verdi i a[fra:til>
        int minsverdi = a[fra];  // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (a[i] < minsverdi) {
                m = i;               // indeks til minste verdi oppdateres
                minsverdi = a[m];    // minste verdi oppdateres
            }

        return m;  // posisjonen til minst verdi i a[fra:til>
    }

    public static int maksverdi(int[] a, int fra, int til) {

        if (a == null) throw new NullPointerException
                ( "parametertabellen a er null!" );

        fratilKontroll( a.length, fra, til );

        if (fra == til) throw new NoSuchElementException
                ( "fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!" );

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (a[i] > maksverdi) {
                m = i;               // indeks til største verdi oppdateres
                maksverdi = a[m];    // største verdi oppdateres
            }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maksverdi(int[] a)  // bruker hele tabellen
    {
        return maksverdi( a, 0, a.length );  // kaller metoden over
    }


    public static int min(int[] a)  // bruker hele tabellen
    {
        return min( a, 0, a.length );  // kaller metoden over
    }
}