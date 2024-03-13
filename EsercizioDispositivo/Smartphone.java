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
    }

    @Override
    public void avviaApplicazione(String nameAPP) {
        super.avviaApplicazione(nameAPP);
        login();
    }

}
