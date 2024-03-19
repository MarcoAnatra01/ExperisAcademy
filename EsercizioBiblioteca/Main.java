package EsercizioBiblioteca;

public class Main {
    public static void main(String[] args) {

        // creo l'oggetto Biblioteca
        // durante l'istanziazione della classe Biblioteca viene:
        // inizializzato l'ArrayList libri
        // popolato l'ArrayList libri
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.aggiungiLibro();
        biblioteca.stampaLibri();
        biblioteca.rimuoviLibro();
        biblioteca.stampaLibri();
    }
}
