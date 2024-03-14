public class Hub {
    public static void main(String[] args) {
        
        DispositivoElettronico dispositivo = new DispositivoElettronico();
        Smartphone cellulare = new Smartphone();
        Tablet tablet = new Tablet();

        dispositivo.avviaApplicazione("kahoot");
        cellulare.avviaApplicazione("kahoot");
        tablet.avviaApplicazione("kahoot");

        // tramite questi oggetti prendo i valori e li stampo
        ResocontoDigitale datiUtente = new ResocontoDigitale(cellulare.getUsername(), cellulare.getPassword(), tablet.getPunti(), tablet.getId());

        datiUtente.stampaDati();
    }
}
