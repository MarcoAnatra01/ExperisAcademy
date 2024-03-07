import java.util.Scanner;
import java.util.ArrayList;

public class Statement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        /*
        String username = "marco";
        String password = "ciao123";

        System.out.println("inserisci username: ");
        String campoUsername = scan.nextLine();

        System.out.println("inserisci password: ");
        String campoPassword = scan.nextLine();

        if(campoUsername.equals(username) && campoPassword.equals(password)){
            System.out.println("\naccesso effettuato");
        
        }else{
            if(campoUsername.equals(username) && !campoPassword.equals(password)){
                System.out.println("\nusername corretto, controlla la password");
            }else{
                System.out.println("\nusername sbagliato");
            }
        }
        */




        /*
        System.out.println("inserisci un numero tra 0 e 9:");
        int num = scan.nextInt();

        if (num >= 0 && num <= 9) {
            
            if (num == 0 || num == 1 || num == 2) {
                System.out.println("hai vinto");
            }else{
                System.out.println("numero non corretto");
            }
        }else{
            System.out.println("il numero non è compreso tra 0 e 9");
        }
        */



        /*
        String nomi[] = {"Marco", "Giovanni", "Luca", "Edoardo"};
        String cognomi[] = {"Rossi", "Ferrari", "Balboni", "Centrale"};

        System.out.println("Ecco i nomi e cognomi che puoi scegliere: ");
        for(int i = 0; i < nomi.length; i++) {
            // stampo il nome e il cognome corrispondente 
            System.out.println(nomi[i] + " - " + i);
            System.out.println(cognomi[i] + " - " + i + '\n');
        }

        System.out.println("Digita l'indice corrispondente per scegliere :");
        int num = scan.nextInt();

        if (num >= nomi.length) {
            System.out.println("Numero non valido");
        }else{
            System.out.println("hai scelto l'utente: " + nomi[num] + " " + cognomi[num]);
        }
        */



        
        ArrayList<String> animali = new ArrayList<>();

        System.out.println("Quanti animali vuoi aggiungere ? - min 4 e max 8");
        int n = scan.nextInt();

        if (n < 4 || n > 8) {
            System.out.println("Gli elementi devono essere min 4 e max 8");
        }else{
            System.out.println("Digita " + n  + " elementi da inserire:");

            for(int i = 0; i < n; i++){
                String animale = scanString.nextLine();
                animali.add(animale);
            }
            System.out.println("\ngli elementi sono stati aggiunti\n");
            System.out.println(animali);

            System.out.println("\nDi quale elemento vuoi verificare la presenza ?");
            String animalToFind= scanString.nextLine();
    
            if (animali.contains(animalToFind)) {
                System.out.println("\nL'elemento è presente nella lista:");
                System.out.println(animalToFind);
                System.out.println("posizione: " + animali.indexOf(animalToFind));
            }else{
                System.out.println("\nElemento non presente nella lista");
            }
        }



    }
}
