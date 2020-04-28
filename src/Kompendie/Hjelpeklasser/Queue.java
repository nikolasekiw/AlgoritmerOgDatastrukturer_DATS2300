package Kompendie.Hjelpeklasser;

import java.util.Collection;

/**
 * Java sitt grensesnitt for Kø
 */

public interface Queue<T> extends Collection<T>
{
    public boolean add(T verdi);    // legger inn bakerst
    public boolean offer(T verdi);  // legger inn bakerst
    public T element();             // ser på den første (tom kø: kaster unntak)
    public T peek();                // ser på den første (tom kø: returnerer null)
    public T remove();              // tar ut den første (tom kø: kaster unntak)
    public T poll();                // tar ut den første (tom kø: returnerer null)

    // + metoder som arves fra Collection<T>

} // interface Queue

/**
 * Det fremgår av kommentarene i Queue (se over) hva element(), peek(), remove() og poll() gjør.
 * Metodene add() og offer() legger begge inn en verdi bakerst i køen. Hvis innleggingen er vellykket,
 * returnerer begge true. Det finnes køtyper der den interne lagringsstrukturen har en maksimal størrelse.
 * Det gjelder f.eks. klassen ArrayBlockingQueue. Hvis det ikke er plass, vil offer() gi false, mens add()
 * kaster unntak. Det er også mulig å ha en kø der like verdier ikke er tillatt. I så fall skal både offer()
 * og add() gi false hvis en forsøker å legge inn en verdi som finnes fra før.
 *
 * Både ArrayDeque og LinkedList kan brukes som en kø. En ArrayDeque er normalt mest effektiv,
 * men tillater ikke null-verdier. Hvis en har behov for det, er LinkedList alternativet.
 **/