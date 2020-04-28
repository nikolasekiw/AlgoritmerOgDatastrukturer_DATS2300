package Kompendie.Eksempelklasser;

public enum Studium {

    /**
     * (1.4.5a) -->
     */

    Data ("Ingeniørfag - data"),         // enumkonstanten Data
    IT ("Informasjonsteknologi"),        // enumkonstanten IT
    Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
    Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne


    private final String fulltnavn;      // instansvariabel
    private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

    public String toString() { return fulltnavn; }
}
