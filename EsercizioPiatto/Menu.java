package EsercizioPiatto;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> tipiPane = new ArrayList<>();    
    public static double[] prezziPane = {1.0, 1.30, 1.50};

    public static ArrayList<String> tipiFarcitura = new ArrayList<>();    
    public static double[] prezziFarciture = {0.50, 1.0, 1.20};

    private static String pane;
    private static String farcitura;
    private static double prezzo;

    public static void main(String[] args) {
        tipiPane.add("normale");
        tipiPane.add("integrale");
        tipiPane.add("sesamo");

        tipiFarcitura.add("marmellata");
        tipiFarcitura.add("nutella");
        tipiFarcitura.add("burro di arachidi");

        System.out.println("\nMenu");
        System.out.println("\nScegli il tipo di pane:");

        for(int i = 0; i < tipiPane.size(); i++){
            System.out.println(i + " - " + tipiPane.get(i) + ", prezzo: " + prezziPane[i]);
        }

        int sceltaPane = scanner.nextInt();

        if (sceltaPane >= 0 && sceltaPane < tipiPane.size()) {
            pane = tipiPane.get(sceltaPane);
        }

        PiattoSpeciale piatto = new PiattoSpeciale();
        piatto.calcolaPrezzoTotale(prezziPane[sceltaPane]);  // incremento il prezzo totale con il prezzo del pane
        
        System.out.println("\nScegli il tipo di farcitura:");

        for(int i = 0; i < tipiFarcitura.size(); i++){
            System.out.println(i + " - " + tipiFarcitura.get(i) + ", prezzo: " + prezziFarciture[i]);
        }
    }    
}
