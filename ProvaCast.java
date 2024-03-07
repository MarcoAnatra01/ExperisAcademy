public class ProvaCast {
    public static void main(String[] args) {
        double myDouble = 9.78d;    
        int myInt = (int) myDouble;    // casting manuale: double to int
    
        System.out.println(myDouble);  // Outputs 9.78
        System.out.println(myInt);     // Outputs 9
        
        System.out.println(Math.ceil(myDouble));
    }
}
