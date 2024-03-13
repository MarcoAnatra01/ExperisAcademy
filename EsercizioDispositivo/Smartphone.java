import java.util.Scanner;

public class Smartphone extends DispositivoElettronico{

    public Scanner scan = new Scanner(System.in);

    @Override
    public String avviaApplicazione(String nameAPP) {
        return super.avviaApplicazione(nameAPP);
    }

    public void login(String username, String psw){
        System.out.println("\nLogin");

        System.out.println("\ninserisci lo username:");
        scan.nextLine();

        System.out.println("\ninserisci la password:");
        scan.nextLine();
    }
}
