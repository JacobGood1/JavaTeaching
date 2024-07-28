package Teaching;

import java.util.function.Function;
import java.util.stream.Stream;

public class ScratchPad {
    static Function<Integer, Integer> adder(Integer x){
        return (Integer y) -> x + y; 
    }
    public static void main(String[] args) {
        var add3 = adder(3);
        var add5 = adder(5);
        System.out.println(add3.apply(5));
    }
    
}
