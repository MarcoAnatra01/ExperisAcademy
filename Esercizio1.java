import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanString = new Scanner(System.in);
        Scanner scanNum = new Scanner(System.in);

        System.out.println("inserisci nome:");
        String nome = scanString.nextLine();

        System.out.println("inserisci cognome:");
        String cognome = scanString.nextLine();

        System.out.println("inserisci età:");
        int eta = scanNum.nextInt();

        System.out.println("Nome: " + nome + '\n' + "Cognome: " + cognome + "\n" + "Eta: " + eta);

        
    }

}
