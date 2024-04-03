package Crittografia;

public class CrittografiaCesare {
    private static final String DIZIONARIO = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso <messaggio> <shift> <modalità(0/1)>");
            return;
        }

        String messaggio = args[0].toLowerCase(); 
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
        StringBuilder risultato = new StringBuilder();

        for (char carattere : testo.toCharArray()) {
            int posizioneOriginale = DIZIONARIO.indexOf(carattere);
            
            if (posizioneOriginale != -1) {  // verifico se il carattere è presente nell'array dizionario
                int nuovaPosizione = (posizioneOriginale + shift) % DIZIONARIO.length();

                if (nuovaPosizione < 0) {
                    nuovaPosizione += DIZIONARIO.length(); // Se la nuova posizione è negativa, aggiungi la lunghezza del dizionario
                }
                risultato.append(DIZIONARIO.charAt(nuovaPosizione));
            } else {
                // Mantieni i caratteri non presenti nell'array dizionario invariati
                risultato.append(carattere); 
            }
        }
        return risultato.toString();
    }

    private static String decripta(String testo, int shift) {
        return cripta(testo, -shift); // Decrittografia è come crittografia con shift negativo
    }
}
