import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

public class Stadio {
    private static int spectatorID = 0;
    private static int incassoTotale = 0;
    private static int prezzoSabato = 20;
    private static int prezzoDomenica = 15;
    
    static Scanner scanNum = new Scanner(System.in);
    static Random random = new Random();

    public void menu(){
        System.out.println("\nQuale info vuoi avere ?\n1 - affluenza minima\n2 - affluenza massima\n3 - incasso minimo\n4 - incasso massimo\n5 - incasso totale dei weekend\n6 - esci");
        System.out.println("\nDigita il numero corrispondente:");
    }
    
    public static void main(String[] args) {
        // creo un oggetto tipo Stadio
        Stadio stadio = new Stadio();

        // lista con i numeri di spettatori dei vari sabati  
        ArrayList<Integer> spettatoriSabato = new ArrayList<>();

        // lista con i numeri di spettatori delle domeniche
        ArrayList<Integer> spettatoriDomenica = new ArrayList<>();

        // liste con gli incassi 
        ArrayList<Integer> incassiSabato = new ArrayList<>();
        ArrayList<Integer> incassiDomenica = new ArrayList<>();
        
        System.out.println("Inserisci il numero di weekend:\n");
        int weekend = scanNum.nextInt();
        
        if (weekend > 0) {
            // simulazione vendita biglietti weekend
            int i = 0;
            while (i < weekend) {
                // generazione numero casuale di spettatori sabato
                int spettatoriS = random.nextInt(30000);  

                // aggiungo il numero spettatori del singolo sabato alla lista spettaoriSabato
                spettatoriSabato.add(spettatoriS);
                
                // calcolo l'incasso del singolo sabato e lo aggiungo alla lista incassiSabato 
                int incassoS = spettatoriS * prezzoSabato;
                incassiSabato.add(incassoS);

                // generazione numero casuale di spettatori domenica
                int spettatoriD = random.nextInt(30000);  

                // aggiungo il numero spettatori della singola domenica alla lista spettatoriDomenica
                spettatoriDomenica.add(spettatoriD);
    
                // calcolo l'incasso della singola domenica e lo aggiungo alla lista incassiDomenica 
                int incassoD = spettatoriD * prezzoDomenica;
                incassiDomenica.add(incassoD);

                // incremento l'incasso totale
                incassoTotale += (incassoS + incassoD);
                i++;
            }

            // riepilogo dati dei vari weekend
            for (int j = 0; j < spettatoriSabato.size(); j++) {
                System.out.println("Sabato " + (j+1) + ": Spettatori = " + spettatoriSabato.get(j) + ", Incasso = $" + (incassiSabato.get(j)));

                System.out.println("Domenica " + (j+1) + ": Spettatori = " + spettatoriDomenica.get(j) + ", Incasso = $" + (incassiDomenica.get(j)));
            }

            stadio.menu();

            int sceltaUtente = scanNum.nextInt();

            if (sceltaUtente >= 1 && sceltaUtente <= 6) {
                while (sceltaUtente >= 1 && sceltaUtente <= 5) {

                    switch (sceltaUtente) {
                        case 1:
                            // affluenza minima
                            int affluenzaMinimaSabato = spettatoriSabato.get(0);

                            for (int k = 1; k < spettatoriSabato.size(); k++) {
                                if (spettatoriSabato.get(i) < affluenzaMinimaSabato) {
                                    affluenzaMinimaSabato = spettatoriSabato.get(i); 
                                }
                            }

                            System.out.println("\nAffluenza minima:");
                            System.out.println("Sabato " + (spettatoriSabato.indexOf(affluenzaMinimaSabato) + 1) + " : " + affluenzaMinimaSabato + "spettatori");
                            break;
                }
            }
            
        }else{
            System.out.println("\nhai inserito 0 weekend");
        }


        }
    }
}
