package Astrazione;

abstract class Animal {
    
    // i metodi astratti non hanno corpo
    public abstract void animalSound();  
  
    public void sleep() {
      System.out.println("Zzz");
    } 
}

class Pig extends Animal {
    public void animalSound() {
      System.out.println("The pig says: wee wee");
    } 

}
class Dog extends Animal {
    public void animalSound() {
      System.out.println("The dog says: bow wow");
    } 
}

class Main {
    public static void main(String[] args) {
      //Animal myAnimal = new Animal();   non si possono istanziare classi astratte 
      Animal myPig = new Pig();  
      Animal myDog = new Dog();  
     // myAnimal.animalSound();
      myPig.animalSound();
      myDog.animalSound();
   }  }
  

public class Tigre {
    
}
