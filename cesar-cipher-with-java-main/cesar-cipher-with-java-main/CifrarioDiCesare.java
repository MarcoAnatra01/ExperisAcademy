public class CifrarioDiCesare {
    private static final String DIZIONARIO = "abcdefghijklmnopqrstuvwxyz"; //Questo è il dizionario che useremo

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso <messaggio> <shift> <modalità(0/1)>");
            return;
        }
        //l'utente passa <messaggio_da_criptare_o_decriptare> <numero_di_shift> <modalità (1/0> 1 -> Crittografia , 2 -> Decrittografia)

        String messaggio = args[0].toLowerCase(); //convertiamo tutti i caratteri in lower case per semplicità
        int shift = Integer.parseInt(args[1]);
        int modalità = Integer.parseInt(args[2]);
        String risultato = "";

        if (modalità == 1) {
            risultato = cripta(messaggio,shift);
        } else if (modalità == 0) {
            risultato = decripta(messaggio,shift);
        } else {
            System.out.println("Modalità non valida. Usa 1 per Crittografia e 0 per decrittografia");
            return;
        }
        System.out.println("Risultato : " + risultato);
    }

    private static String cripta(String testo, int shift) {
        return trasforma(testo,shift);
    }

    private static String decripta(String testo, int shift) {
        return trasforma(testo,-shift);
    }

    public static String trasforma(String testo, int shift) {
        StringBuilder risultato = new StringBuilder();

        for (char carattere : testo.toCharArray()) {
            if(DIZIONARIO.indexOf(carattere) != -1) {  // verifico se il carattere è presente nell'array dizionario
                int posizioneOriginale = DIZIONARIO.indexOf(carattere);
                int nuovaPosizione = (DIZIONARIO.length() + posizioneOriginale + shift ) % DIZIONARIO.length(); 
                //int nuovaPosizione = posizioneOriginale + shift;
                risultato.append(DIZIONARIO.charAt(nuovaPosizione));
            } else {
                // Mantieni i caratteri non alfabetici invariati (spazi, numeri, punteggiatura ecc)
                // i numeri non vengono shiftati perchè non presenti nell'array dizionario
                risultato.append(carattere);
            }
        }
        return risultato.toString();
    }
    
}