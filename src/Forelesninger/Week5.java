package Forelesninger;




public class Week5 {

    //Dette er en annen måte å tenke på flettesortering på, lister med lengde en så flette dem sammen
    //På en annen måte starter vi med et helt array og deler den i to, da har vi to usorterte arrays.
    //Hvis vi later som om de er sorterte gjør vi det samme med to andre array???
    //Kan vi skrive en annen måte som er rekursov som....
    //Lønner seg å starte med rekursjon hvor man starter på toppen og går ned og gjør det finere og finere.

    /*
    Skissere rekursjon: trenger å kalle seg selv, gå mot slottkriterie også må det ha et sluttkriterie. Sluttkrieterie kan være
    at tabellen har lengde 1 elle rlengde 2. Kan ikke kjøre en fletting med bare 2 tall.
    2 kriteri: for å forenkle problemet vårt deler vi hele tiden tabellen vår i to.
    Fint å bruke intervall for å ikke måtte lage egen tabeller hele tiden. Vi ønsker å gjenbruke det minnet vi allerede bruker.
    Mid er midten av tabellen
    Her driver vi med halvåpne intervallet. Begin og end. Typisk er ikke end elementet med. L og R er beggge med.
    End er utenfortabellen fordi det er halvåpent intervall. Da kan vi definere at vi skal flette sammen to tabeller (begin mid, mid end)

    Trenger jeg noe mellomlagring (tenk på merge funksjon), trenger jeg noe der?
    Må ha en temp variabel som . Skal gå fra en tabell til en annem. Vi skal bruke 1 ekstra midlertidig variabe, så flytter vi 3 til temp, så flytter 1
    til der hvor 3 var (husk at merge er stable kan ikke bytte på rekkefølgen) så må flytte alt det andre til høyre for så å gjøre plass til at 3 kommer på plass.

    Annen måte å gjøre det på: bruke et midlertidig array. Flytter det midlertidige arrayet med verdiene ut. Da står vi med 2 arrays og begynner å flette de.
    Bruker temp for å lagre det midlertidige arrayet. Mer effektivt med tanke på minnet
     */

    /**
     * Merges values [begin end] with values [mid, end]
     */

    public static void merge(int[] values, int[] temp, int begin, int mid, int end){

    }

    public static void mergeSort(int[] values, int[] temp, int begin, int end){

        int mid = (begin+end) / 2;

        //sort left intervall, går fra begin til mid (mid er ikke med i sorteringen
        // mergeSort(values, begin, mid);

        //sort right intervall, fra mid til end (end er ikke med i sorteringen
        //mergeSort(values, mid, end);

        //kaalle min egen sortering på de to tabellene, men jeg må sortere dem først.


        //merge values into a single table
        merge(values, temp, begin, mid, end);
        //denne er en intern funksjon da må man ha den til private

        //public static void mergeSort(int[] values){
        // int[] temp = new int[values.length/2];

        //denne starter rekursjonen
        mergeSort(values, temp, 0, values.length) ;
    }

}
