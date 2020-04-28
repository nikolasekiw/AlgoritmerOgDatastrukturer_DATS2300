package Kompendie.Hjelpeklasser;

import java.util.*;

public class Beholdere {
    private Beholdere() { }  // hindrer instansiering

    public static <T> T maks(Iterable<T> itererbar, Comparator<? super T> c) {
        Iterator<T> it = itererbar.iterator();  // henter iteratoren

        if (!it.hasNext())
            throw new NoSuchElementException("Ingen verdier!");

        T maksverdi = it.next();  // finnes siden listen ikke er tom

        while (it.hasNext()) {
            T verdi = it.next();
            if (c.compare(verdi,maksverdi) > 0) maksverdi = verdi;
        }
        return maksverdi;
    }
} // class Beholdere
