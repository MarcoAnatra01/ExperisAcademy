public class DispositivoElettronico {
    protected String nameAPP;

    public String avviaApplicazione(String nameAPP){
        System.out.println("L'app " + nameAPP + " si sta avviando");
        return nameAPP;
    }
}
