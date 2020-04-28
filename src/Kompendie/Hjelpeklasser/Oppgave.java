package Kompendie.Hjelpeklasser;

@FunctionalInterface
public interface Oppgave<T> {
    void utførOppgave(T t);
}
