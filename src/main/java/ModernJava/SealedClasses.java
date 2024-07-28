package ModernJava;

public sealed class SealedClasses permits A, B, C{
    public static void main(String[] args) {
        // exhaustive pattern matching with switch
        switch(new SealedClasses()) {
            case A a -> System.out.println("A");
            case B b-> System.out.println("B");
            case C c -> System.out.println("C");
            case SealedClasses s -> System.out.println("SealedClasses"); 
        }
    }
    
}
