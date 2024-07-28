package Teaching;

import java.util.Scanner;

public class DragonCave {
    public static String chooseCave(String cave){
        if (cave.equals("1")){
            return "you win";
        } else {
            return "you lose";
        }
    }
    public static void main(String[] args) {
        chooseCave("1");
    }
}
