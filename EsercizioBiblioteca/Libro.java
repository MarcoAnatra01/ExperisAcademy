package EsercizioBiblioteca;

public class Libro {
    private String titolo;
    private String autore;
    private int totaleCopie;
    private int disponibili;
    private int prestito;
    
    public Libro(String titolo, String autore, int totaleCopie){
        this.titolo = titolo;
        this.autore = autore;
        this.totaleCopie = totaleCopie;

        // le copie in prestito inizialmente sono zero
        // le copie disponibili inizialmente sono pari al totale copie
        this.prestito = 0;  
        this.disponibili = totaleCopie;
        
    }


    // metodi getter
    public String getTitolo(){
        return this.titolo;
    }

    public String getAutore(){
        return this.autore;
    }

    public int getCopie(){
        return this.totaleCopie;
    }

    public int getDisponibili(){
        return this.disponibili;  // ritorna le copie disponibili
    }

    public int getPrestito(){     // ritorna le copie in prestito
        return this.prestito;
    }


    public void prestaLibro(Libro libro){
        if(libro.disponibili > 0){
           libro.disponibili--;
           libro.prestito++; 
           System.out.println("Hai scelto il libro: " + libro.titolo);
        }else{
            System.out.println("Al momento non abbiamo copie disponibili per il libro: " + libro.titolo);
        }
    }

    public void restituisciLibro(Libro libro){
        if (libro.prestito > 0) {
            libro.disponibili++;
            libro.prestito--;
            System.out.println("Hai restituito il libro: " + libro.titolo);
        }else{
            System.out.println("non ci sono copie in prestito per il libro indicato");
        }
    }

    @Override
    public String toString() {
        return titolo + " - autore: " + autore + " - copie disponibili: " + disponibili;
    }
}
