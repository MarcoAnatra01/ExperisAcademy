

public class ResocontoDigitale {
    
    public void stampaDati(){

    }
    
    public static void main(String[] args) {
        DispositivoElettronico dispositivo = new DispositivoElettronico();
        Smartphone cellulare = new Smartphone();
        Tablet tablet = new Tablet();

        dispositivo.avviaApplicazione("Facebook");
        cellulare.avviaApplicazione("app2");
        tablet.avviaApplicazione("app3");

        // tramite questi oggetti prendo i valori e li stampo

    }
}
