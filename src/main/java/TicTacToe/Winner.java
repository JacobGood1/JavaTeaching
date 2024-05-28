package TicTacToe;

import java.util.HashMap;
import java.util.Map;

public class Winner {
    int boardDimensions;
    public Winner(int boardDimensions){
        this.boardDimensions = boardDimensions;
    }
    HashMap<String,Integer> letterCount = new HashMap<>(Map.of(
            "X",0,
            "O",0,
            "-",0
    ));
    String whoIsWinner(){
        for (var entry :letterCount.entrySet()){
            if (entry.getValue()==boardDimensions){
                return entry.getKey();
            }
        };
        return "-"; 
    }
    public boolean isThereAWinner(){
        for (var val: letterCount.values()){
            if (val==boardDimensions)return true;
        }
        return false;
    }
    void updateSquareCount(String letter){
        letterCount.put(letter,letterCount.get(letter)+1);
    }
}
