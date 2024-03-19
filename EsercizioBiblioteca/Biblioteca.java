package EsercizioBiblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca{
    public Scanner scanner = new Scanner(System.in);
    public Scanner scannerInt = new Scanner(System.in);

    // contiene tutti gli oggetti Libro disponibili in biblioteca 
    ArrayList<Libro> libri = new ArrayList<>();

    public void stampaLibri(){
        if (libri.isEmpty()) {
            System.out.println("Non ci sono libri disponibili");
        }else{
            for(int i = 0; i < libri.size(); i++){
                System.out.println("\n" + libri.get(i).toString());
            }
        }
    }

    // metodo per aggiungere un nuovo libro alla biblioteca
    public void aggiungiLibro(){
        // chiedo all'utente di indicare il titolo, l'autore e il numero di copie del libro da aggiungere 
        
        System.out.println("inserisci il titolo del libro:");
        String titolo = scanner.nextLine();

        System.out.println("inserisci l'autore:");
        String autore = scanner.nextLine();

        System.out.println("inserisci il numero di copie:");
        int nCopie = scannerInt.nextInt();

        Libro libro = new Libro(titolo, autore, nCopie);
        libri.add(libro);

        System.out.println("hai aggiunto un nuovo libro alla biblioteca");
    }

    // metodo che trova un libro tramite titolo
    public Libro findByName(String titolo){
        for (Libro libro : libri) {
            if (libro.getTitolo().equals(titolo)) {
                return libro;
            }    
        }
        return null;
    }

    // metodo per rimuovere un libro dalla biblioteca 
    public void rimuoviLibro(){
        System.out.println("inserisci il titolo del libro da rimuovere:");
        String titolo = scanner.nextLine();

        Libro libroTrovato = findByName(titolo); 

        // cerco il libro nella lista 
        if (libroTrovato != null) {
            libri.remove(libroTrovato);
        }else{
            System.out.println("il libro da rimuovere non è presente in biblioteca");
        }
    }
}