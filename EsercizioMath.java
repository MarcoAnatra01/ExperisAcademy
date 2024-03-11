import java.util.Scanner;
import java.util.Random;

public class EsercizioMath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanNum = new Scanner(System.in);

        Random random = new Random();

        int x = 11;
        int y = 21;
        int z;
        int counter = 0;

        String scelta = "";

        while (!scelta.equals("si") && !scelta.equals("no")) {
            System.out.println("Vuoi procedere con le operazioni ? - si/no");
    
            scelta = scan.nextLine();
    
            if(scelta.equals("no")){
                System.out.println("Non hai eseguito alcun operazione");
            }else if(scelta.equals("si")){
                System.out.println("hai scelto di procedere");

                while (scelta.equals("si")) {
                    System.out.println("i numeri sono : " + x + " e " + y);
    
                    System.out.println("Che operazione vuoi fare ?\n1 - somma\n2 - sottrazione\n3 - moltiplicazione\n4 - divisione");
                    
                    // l'utente sceglie il tipo operazione
                    int operazione = scanNum.nextInt();
    
                    if (operazione >= 1 && operazione <= 4) {
                        switch (operazione) {
                            case 1:
                                //somma
                                z = x + y; 
                                counter++;
                                System.out.println("somma = " + z);
                                System.out.println("somma random = " + random.nextInt(100));
                                break;
        
                            case 2:
                                //sottrazione
                                z = x - y; 
                                counter++;
                                System.out.println("sottrazione = " + z);
                                System.out.println("sottrazione random = " + random.nextInt(100));
                                break;
        
                            case 3:
                                //moltiplicazione
                                z = x * y; 
                                counter++;
                                System.out.println("moltiplicazione = " + z);
                                System.out.println("moltiplicazione random = " + random.nextInt(100));
                                break;
        
                            case 4:
                                //divisione
                                z = x / y; 
                                counter++;
                                System.out.println("divisione = " + z);
                                System.out.println("divisione random = " + random.nextInt(100));
                                break;
                        }
                    }
    
                    System.out.println("\nVuoi eseguire un altra operazione ? - si/no");
                    scelta = scan.nextLine();
                }

                if (!scelta.equals("si")) {
                    // quando scelgo di non procedere con altre operazioni, mi appare il numero di operazioni che ho eseguito
                    System.out.println("\nnumero di operazioni eseguite: " + counter);
                    break;
                }
                }else{
                    System.out.println("Scelta non valida, riprova");
                }
        }
  }
}
