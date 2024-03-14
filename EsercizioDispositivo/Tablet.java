import java.util.Random;

public class Tablet extends DispositivoElettronico{

    public Random random = new Random();
    private static int idIncrementale = 0;
    private int punti;
    private int id;


    @Override
    public void avviaApplicazione(String nameAPP) {

        System.out.println("\nL'applicazione " + nameAPP + " si è avviata");

        punti = random.nextInt(100);
        id = idIncrementale++;
    }

    public int getPunti() {
        return punti;
    }

    public int getId() {
        return id;
    }
}
