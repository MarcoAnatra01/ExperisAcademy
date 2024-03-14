package Astrazione;

interface Animal {
    // l'interfaccia non contiene costruttori poichè non può essere usata per creare oggetti
    // i metodi delle interfacce non hanno corpo (il corpo è fornito dalla classe che implementa)
    // i metodi delle interfacce sono public e abstract per impostazione predefinita
    // gli attributi delle interfacce invece sono public, static e final per impostazione predefinita
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

