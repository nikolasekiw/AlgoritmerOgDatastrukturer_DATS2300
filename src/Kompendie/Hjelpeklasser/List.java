package Kompendie.Hjelpeklasser;

import java.util.Collection;
import java.util.Iterator;

/**
 * 3.2.1b
 */

public interface List<T> extends Collection<T> {
    public boolean add(T element);              // leggInn
    public void add(int index, T element);      // leggInn
    public boolean contains(Object o);          // inneholder
    public T get(int index);                    // hent
    public int indexOf(Object o);               // indeksTil
    public T set(int index, T element);         // oppdater
    public T remove(int index);                 // fjern
    public boolean remove(Object o);            // fjern
    public int size();                          // antall
    public boolean isEmpty();                   // tom
    public void clear();                        // nullstill
    public Iterator<T> iterator();              // iterator

    // samt mange andre metoder
}
