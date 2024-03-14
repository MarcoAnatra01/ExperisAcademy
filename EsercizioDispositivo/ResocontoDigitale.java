

public class ResocontoDigitale {
    
    private String nome;
    private String password;
    private int punti;
    private int id;

    public ResocontoDigitale(String nome, String password, int punti, int id) {
        this.nome = nome;
        this.password = password;
        this.punti = punti;
        this.id = id;
    }


    public void stampaDati(){
        System.out.println("\nResoconto Digitale:");
        System.out.println("Username: " + nome);
        System.out.println("id: " + id);
        System.out.println("Score: " + punti);
        System.out.println("\n");
    }
    
    
}
