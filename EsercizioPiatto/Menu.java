package EsercizioPiatto;

import java.util.ArrayList;

public class Menu {
    private static ArrayList<String> tipiPane = new ArrayList<>();    
    private double[] prezziPane = {1.0, 1.30, 1.50};

    public static void main(String[] args) {
        tipiPane.add("normale");
        tipiPane.add("integrale");
        tipiPane.add("sesamo");
    }    
}
