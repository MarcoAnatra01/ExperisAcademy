import java.util.Random;

public class Tablet extends DispositivoElettronico{

    public Random random = new Random();
    private static int idIncrementale = 0;
    private int punti;
    private int id;

    public Tablet(){
        this.punti = random.nextInt(100);
        this.id = idIncrementale++;
    }

    @Override
    public void avviaApplicazione(String nameAPP) {
        super.avviaApplicazione(nameAPP);
    }


}
