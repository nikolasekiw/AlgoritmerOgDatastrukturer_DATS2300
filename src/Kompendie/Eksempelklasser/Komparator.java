package Kompendie.Eksempelklasser;

import Kompendie.Hjelpeklasser.Tabell;

/**
 * (1.4.6a) --> lager vårt eget comparator grensesnitt for å gjøre det litt enklere
 * skal senere bruke java sin som er litt mer kompleks
 */

@FunctionalInterface                //legges i mappen eksempelklasser
public interface Komparator<T> {    //et funksjonsgrensesnitt
    int compare(T x, T y);          //en abstrakt metode


    /**
     * (1.4.7d)
     */

    public static <T extends Comparable<? super T>> Komparator<T> naturligOrden(){
        return (x,y) -> x.compareTo(y);
    }

    public static <T extends Comparable<? super T>> Komparator<T> omvendtOrden(){
        return (x,y) -> y.compareTo(x);
    }

    /**
     * (1.4.7g) --> generalisering
     */

    //TODO: finne ut hvorfor denne kodne ikke fungerer
    /*public static <T, R extends Comparable<? super R>> Komparator<T> orden(Funksjon<? super T, ? extends R> velger) {

        return (x, y) -> velger.anvend(x).compareTo(velger.anvend(y));
    }*/

    //Komparator<Student> c = Komparator.orden(velger);

    /*public static <T, R> Komparator<T> orden
    (Funksjon<? super T, ? extends R> velger, Komparator<? super R> c)
    {
        return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
    }
*/

    /**
     * 1.4.7h
     */

     //Tabell.innsettingssortering(s, Komparator.orden(Student::studium));

    /**
     * 1.4.8a --> lambda uttrykk som ordner leksikografisk rekkefølge av Student
     */

    Komparator<Student> c = (s1,s2) ->
    {
        int k = s1.studium().compareTo(s2.studium());
        if (k != 0) return k;    // forskjellige studier
        k = s1.fornavn().compareTo(s2.fornavn());
        if (k != 0) return k;    // forskjellige fornavn
        return s1.etternavn().compareTo(s2.etternavn());
    };

    /**
     * 1.4.8c
     */

    default Komparator<T> deretter(Komparator<? super T> c){
        return (x, y) -> {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(x, y);
        };
    }

    /**
     * 1.4.8f
     */

    /*default <R extends Comparable<? super R>>  // tilhører grensesnittet Komparator
    Komparator<T> deretter(Funksjon<? super T, ? extends R> velger) {
        return (x, y) -> {
            int k = compare(x, y);
            return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
        };
    }*/

    /**
     * 1.4.8l
     */

    /*default <R> Komparator<T>
    deretter(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c) {
        return (x, y) ->
        {
            int k = compare(x, y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }*/

    /**
     * 1.4.8m --> en komparator som snur en metode kan også legges som en default metode
     */

    default Komparator<T> omvendt() {
        return (x, y) -> compare(y, x);  // bytter x og y
    }
}
