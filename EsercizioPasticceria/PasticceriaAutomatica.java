import java.util.Scanner;
import java.util.ArrayList;

public class PasticceriaAutomatica {
    
    public static void main(String[] args) {

        // creo gli oggetti tipo Scanner per prendere gli input utente
        Scanner scanString = new Scanner(System.in);
        Scanner scanNum = new Scanner(System.in);

        // ArrayList con gli ingredienti scelti dall'utente 
        ArrayList<String> ingredientiUtente = new ArrayList<>();

        // array per gli ingredienti del dolce
        String[] basi = {"Pan di Spagna", "Frolla", "Biscotto"};
        String[] ripieni = {"Crema pasticcera", "Marmellata", "Cioccolato"};
        String[] frutta = {"Banana", "Fragole", "Mirtilli"};
        String[] decorazioni = {"Glassa", "Zucchero a velo", "Cacao"};

        // chiedo all'utente quale composizione desidera
        System.out.println("\nDesideri comporre il dolce oppure vuoi la composizione casuale ?\n");

        // scelte sul tipo composizione:
        // 'compongo'
        // 'casuale' 
        System.out.println("\nScrivi 'compongo' se vuoi comporre tu stesso o 'casuale' se vuoi un dolce random");

        String tipoComposizione = scanString.nextLine();

        if(tipoComposizione != ""){

            if (tipoComposizione.toLowerCase().equals("compongo")) {   // COMPOSIZIONE PERSONALIZZATA

                // SCELTA BASE

                // stampo gli elementi dell'array basi
                for(int i = 0; i < basi.length; i++){
                    System.out.println(basi[i] + " - " + i);
                }

                System.out.println("\nScegli la base del dolce con il numero corrispondente");
                int numeroBase = scanNum.nextInt();

                // controllo che il numero scelto dall'utente sia presente tra gli indici dell'array

                if (numeroBase >= 0 && numeroBase < basi.length) {  
                    String sceltaBase = basi[numeroBase];
                }else{
                    System.out.println("\ningrediente non presente");
                }

                //----------------------------------------------------------------------------------------------------
                
                // SCELTA RIPIENO 

                // stampo gli elementi dell'array ripieni
                for(int i = 0; i < ripieni.length; i++){
                    System.out.println(ripieni[i] + " - " + i);
                }

                System.out.println("\nScegli il ripieno del dolce con il numero corrispondente");
                int numeroRipieno = scanNum.nextInt();

                if (numeroRipieno >= 0 && numeroRipieno < ripieni.length) {  
                    String sceltaRipieno = ripieni[numeroRipieno];
                }else{
                    System.out.println("\ningrediente non presente");
                }

                //----------------------------------------------------------------------------------------------------

                // SCELTA FRUTTA 

                // stampo gli elementi dell'array frutta
                for(int i = 0; i < frutta.length; i++){
                    System.out.println(frutta[i] + " - " + i);
                }

                System.out.println("\nScegli la frutta con il numero corrispondente");
                int numeroFrutta = scanNum.nextInt();

                if (numeroFrutta >= 0 && numeroFrutta < frutta.length) {  
                    String sceltaFrutta = frutta[numeroFrutta];
                }else{
                    System.out.println("\ningrediente non presente");
                }

                //----------------------------------------------------------------------------------------------------

                // SCELTA DECORAZIONE

                // stampo gli elementi dell'array decorazioni
                for(int i = 0; i < decorazioni.length; i++){
                    System.out.println(decorazioni[i] + " - " + i);
                }

                System.out.println("\nScegli la decorazione con il numero corrispondente");
                int numeroDecorazione = scanNum.nextInt();

                if (numeroDecorazione >= 0 && numeroDecorazione < decorazioni.length) {  
                    String sceltaDecorazione = decorazioni[numeroDecorazione];
                }else{
                    System.out.println("\ningrediente non presente");
                }
                //----------------------------------------------------------------------------------------------------


            }else if (tipoComposizione.toLowerCase().equals("casuale")) {   // COMPOSIZIONE RANDOM
                

            }else{
                System.out.println("\ntipo composizione non presente");
            }
        }else{
            System.out.println("Non hai inserito nessun tipo di composizione");
        }
    }
}
