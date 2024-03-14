import java.util.Scanner;
import java.util.ArrayList;

public class Smartphone extends DispositivoElettronico{

    public Scanner scan = new Scanner(System.in);

    private String username;
    private String password;

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    public void login(){
        System.out.println("\nLogin");

        System.out.println("\ninserisci lo username:");
        username = scan.nextLine();

        System.out.println("\ninserisci la password:");
        password = scan.nextLine();

        // salvo i dati utente nell'arraylist
        usernames.add(username);
        passwords.add(password);

        System.out.println("\nAccesso effettuato, benvenuto " + username);
    }

    @Override
    public void avviaApplicazione(String nameAPP) {
        System.out.println("\nCaricamento, attendere prego");
        login();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
