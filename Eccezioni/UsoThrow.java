public class UsoThrow {

    static void checkAge(int age) {

        if (age < 18) {
            // throw ci permette di creare un errore personalizzato
            // viene utilizzata insieme a un tipo di eccezione
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");}
        else {
            System.out.println("Access granted - You are old enough!"); 
        }
    }

    public static void main(String[] args) {
      checkAge(15); // Set age to 15 (which is below 18...) 
    }
}