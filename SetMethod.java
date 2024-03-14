public class SetMethod {
    private String nome;
    private int eta; 

    // esempio con Costruttore()

    public SetMethod(String nome, int eta) {
      this.nome = nome;
      this.eta = eta;  
    }

    public SetMethod(){
      // costruttore vuoto
    }

    // setter
    public void setName(String name){
      nome = name;
    }
  
    public static void main(String[] args) {
      
      SetMethod persona = new SetMethod();
      persona.setName("pippo");
   }
}