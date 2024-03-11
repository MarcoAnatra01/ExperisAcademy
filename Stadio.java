import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Stadio {
    
    public static void main(String[] args) {
        int spectatorID = 0;
        int incassiTotali = 0;
        int prezzoSabato = 20;
        int prezzoDomenica = 15;
        
        Scanner scanNum = new Scanner(System.in);
        Random random = new Random();

        
        System.out.println("Inserisci il numero di weekend:\n");
        int weekend = scanNum.nextInt();
        
        if (weekend > 0) {
            int i = 0;
            while (i < weekend) {
                // simulazione vendita biglietti sabato
                int spettatoriSabato = random.nextInt(30000);
                int incassoSabato = spettatoriSabato * prezzoSabato;
                spectatorID += spettatoriSabato;
    
                // simulazione vendita biglietti domenica
                int spettatoriDomenica = random.nextInt(30000);
                int incassoDomenica = spettatoriDomenica * prezzoDomenica;
                spectatorID += spettatoriDomenica;
                
                incassiTotali += (incassoSabato + incassoDomenica);
                i++;
            }
        }else{
            System.out.println("\nhai inserito 0 weekend");
        }
    }
}
