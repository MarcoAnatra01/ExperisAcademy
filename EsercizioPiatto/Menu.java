package EsercizioPiatto;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> tipiPane = new ArrayList<>();    
    public double[] prezziPane = {1.0, 1.30, 1.50};

    public static void main(String[] args) {
        tipiPane.add("normale");
        tipiPane.add("integrale");
        tipiPane.add("sesamo");

        System.out.println("\nMenu");
        System.out.println("Scegli il tipo ");
    }    
}
