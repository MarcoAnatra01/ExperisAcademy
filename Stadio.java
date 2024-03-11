import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Stadio {
    private int incassiTotali = 0;
    private Scanner scanNum = new Scanner(System.in);
    private Random random = new Random();

    public void simulaWeekend() {
        System.out.println("Inserisci il numero di weekend:\n");
        int weekend = scanNum.nextInt();

        if (weekend > 0) {
            int spettatoriSabato = random.nextInt(30000);
            int spettatoriDomenica = random.nextInt(30000);
    
            int incassiSabato = spettatoriSabato * 20;
            int incassiDomenica = spettatoriDomenica * 15;

            incassiTotali += (incassiSabato + incassiDomenica);
        }
    }

    public int getTotalIncome() {
        return incassiTotali;
    }
}
