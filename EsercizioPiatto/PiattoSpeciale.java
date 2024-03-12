package EsercizioPiatto;

public class PiattoSpeciale {

    private static final double PREZZO_BASE = 1.0;  // Prezzo fisso base
    private double prezzoTotale;
    private String tipoPane;
    private String tipoFarcitura; 
    private String ingredientePrivato; // nuovo ingrediente che viene settato dall'utente
    private double prezzoPane;
    private double prezzoFarcitura;

    public PiattoSpeciale(String tipoPane, double prezzoPane, String tipoFarcitura, double prezzoFarcitura, double prezzoTotale){
        this.tipoPane = tipoPane;
        this.prezzoPane = prezzoPane;
        this.tipoFarcitura = tipoFarcitura;
        this.prezzoFarcitura = prezzoFarcitura;
        this.prezzoTotale = PREZZO_BASE;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public String getPanino() {
        return tipoPane;
    }


    public void setIngredientePrivato(String ingrediente, double prezzo) {
        this.ingredientePrivato = ingrediente;
        this.prezzoTotale += prezzo;
    }

    public String getIngredientePrivato() {
        return ingredientePrivato;
    }
}
