package EsercizioBiblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca{
    public Scanner scanner = new Scanner(System.in);
    public Scanner scannerInt = new Scanner(System.in);

    // contiene tutti gli oggetti Libro disponibili in biblioteca 
    private ArrayList<Libro> libri;

    public void popolaBiblioteca(){
        libri.add(new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 150));
        libri.add(new Libro("Harry Potter e la Pietra Filosofale", "J.K. Rowling", 200));
        libri.add(new Libro("Il Codice Da Vinci", "Dan Brown", 180));
        libri.add(new Libro("Orgoglio e Pregiudizio", "Jane Austen", 140));
        libri.add(new Libro("Il Grande Gatsby", "F. Scott Fitzgerald", 120));
        libri.add(new Libro("1984", "George Orwell", 170));
        libri.add(new Libro("Moby Dick", "Herman Melville", 90));
        libri.add(new Libro("L'insostenibile leggerezza dell'essere", "Milan Kundera", 110));
        libri.add(new Libro("Il Piccolo Principe", "Antoine de Saint-Exupéry", 250));
        libri.add(new Libro("Frankenstein", "Mary Shelley", 80));
    }

    public Biblioteca(){
        // inizializzo l'ArrayList
        this.libri = new ArrayList<>();

        // aggiungo i libri alla lista
        popolaBiblioteca(); 
    }

    public void operazioni(){
        System.out.println("Menu");
    }

    public void stampaLibri(){
        if (libri.isEmpty()) {
            System.out.println("Non ci sono libri disponibili");
        }else{
            for(int i = 0; i < libri.size(); i++){
                System.out.println("\n" + libri.get(i).toString());
            }
            System.out.println("\n");
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
            System.out.println("\nHai rimosso il libro: " + libroTrovato.getTitolo());
        }else{
            System.out.println("\nil libro da rimuovere non è presente");
        }
    }
}