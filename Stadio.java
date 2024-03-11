import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Stadio {
    
    public static void main(String[] args) {
        int spectatorID = 0;
        int incassoTotale = 0;
        int prezzoSabato = 20;
        int prezzoDomenica = 15;
        
        Scanner scanNum = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> spettatoriSabato = new ArrayList<>();
        ArrayList<Integer> spettatoriDomenica = new ArrayList<>();
        
        System.out.println("Inserisci il numero di weekend:\n");
        int weekend = scanNum.nextInt();
        
        if (weekend > 0) {

            // vendita biglietti sabato
            int i = 0;
            while (i < weekend) {
                int spettatori = random.nextInt(30000);  // generazione casuale numero spettatori
                spettatoriSabato.add(spettatori);
                int incasso = spettatori * prezzoSabato;
                incassoTotale += incasso;
                i++;
            }

            // vendita biglietti domenica
            int j = 0;
            while (j < weekend) {
                int spettatori = random.nextInt(30000);  // generazione casuale numero spettatori
                spettatoriDomenica.add(spettatori);
                int incasso = spettatori * prezzoDomenica;
                incassoTotale += incasso;
                j++;
            }
        }else{
            System.out.println("\nhai inserito 0 weekend");
        }

/*
        for (int i = 0; i < spettatoriSabato.size(); i++) {
            System.out.println("Sabato " + (i+1) + ": Spettatori = " + spettatoriSabato.get(i) + ", Incasso = $" + (saturdaySpectators.get(i) * 20));
        }
        
        for (int i = 0; i < sundaySpectators.size(); i++) {
            System.out.println("Domenica " + (i+1) + ": Spettatori = " + sundaySpectators.get(i) + ", Incasso = $" + (sundaySpectators.get(i) * 15));
        }
        */
    }
}
