package Kompendie.Eksempelklasser;

import java.util.Objects;

public class Person implements Comparable<Person> {

    /**
     * (1.4.4.d) --> Klassen Person er for personopplysninger. Den gjøres sammenlignbar ved å ordne
     * personer alfabetisk, dvs. etternavn først og så etter fornavn hvis etternavnene er like.
     * Vi antar at alle har forskjellige navn.
     */

    private final String fornavn;         // personens fornavn
    private final String etternavn;       // personens etternavn

    public Person(String fornavn, String etternavn) {   // konstruktør
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() { return fornavn; }       // aksessor
    public String etternavn() { return etternavn; }   // aksessor

    public int compareTo(Person p) {   // pga. Comparable<Person>
        int cmp = etternavn.compareTo(p.etternavn);     // etternavn
        if (cmp != 0) return cmp;             // er etternavnene ulike?
        return fornavn.compareTo(p.fornavn);  // sammenligner fornavn
    }

    public boolean equals(Object o) {     // vår versjon av equals
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return compareTo((Person)o) == 0;
    }

    public int hashCode() { return Objects.hash(etternavn, fornavn); }

    public String toString() { return fornavn + " " + etternavn; }

} // class Person


