package Astrazione;

interface Animal {
    // i metodi delle interfacce non hanno corpo (come i metodi astratti)
    public void animalSound(); 
    public void sleep(); 
}
  

// una classe può implementare infinite interfacce
// la classe che implementa deve sovrascrivere tutti i metodi dell'interfaccia
class Pig implements Animal {
    public void animalSound() {
      System.out.println("The pig says: wee wee");  
    }

    public void sleep() {
      System.out.println("Zzz"); 
    }
}


public class TestInterfaccia {  
    public static void main(String[] args) {
        Pig myPig = new Pig();  
        myPig.animalSound();
        myPig.sleep();
    }
}

