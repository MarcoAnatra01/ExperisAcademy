public class Main {
    private String nome;
    private int eta; 

    // esempio con Costruttore()

    public Main(String nome, int eta) {
      this.nome = nome;
      this.eta = eta;  
    }

    public Main(){}

    public void setName(String name){
      nome = name;
    }
  
    public static void main(String[] args) {
      Main persona = new Main();
      persona.setName("pippo");
   }
}