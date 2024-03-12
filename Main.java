public class Main {
    String nome;
    int eta; 

    // esempio con Costruttore()

    public Main(String nome, int eta) {
      this.nome = nome;
      this.eta = eta;  
    }
  
    public static void main(String[] args) {
      Main persona = new Main("pippo", 34);
      System.out.println(persona.nome); 
   }
}