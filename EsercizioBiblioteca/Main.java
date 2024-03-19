package EsercizioBiblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.aggiungiLibro();
        biblioteca.stampaLibri();
        biblioteca.rimuoviLibro();
        biblioteca.stampaLibri();
    }
}
