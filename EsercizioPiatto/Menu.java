package EsercizioPiatto;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> tipiPane = new ArrayList<>();    
    public static double[] prezziPane = {1.0, 1.30, 1.50};

    private static String pane;
    private static String farcitura;
    private static double prezzo;

    public static void main(String[] args) {
        tipiPane.add("normale");
        tipiPane.add("integrale");
        tipiPane.add("sesamo");

        System.out.println("\nMenu");
        System.out.println("\nScegli il tipo di pane con il numero corrispondente");

        for(int i = 0; i < tipiPane.size(); i++){
            System.out.println(i + " - " + tipiPane.get(i) + " prezzo: " + prezziPane[i]);
        }

        int sceltaPane = scanner.nextInt();

        if (sceltaPane >= 0 && sceltaPane < tipiPane.size()) {
            pane = tipiPane.get(sceltaPane);
            
        }
    }    
}
