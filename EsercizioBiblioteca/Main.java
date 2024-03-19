package EsercizioBiblioteca;

public class Main {
    public static void main(String[] args) {

        // creo l'oggetto Biblioteca
        // durante l'istanziazione della classe Biblioteca viene:
        // inizializzato l'ArrayList libri
        // popolato l'ArrayList libri
        Biblioteca biblioteca = new Biblioteca();

        // biblioteca.stampaLibri();
        // biblioteca.aggiungiLibro();
        // biblioteca.stampaLibri();
        // biblioteca.rimuoviLibro();

        int scelta = 0;
        biblioteca.stampaLibri();

        do {
            scelta = biblioteca.operazioni();
        } while (scelta >= 1 && scelta <= 4);
    }
}
