package GuessTheNumber;

public class GuessTheNumber {
    
    static String guessTheNumberFeedBack(int guess, int secretNumber) {
        if (guess > secretNumber) {
            return "Too high";
        } else if (guess < secretNumber) {
            return "Too low";
        } 
        return "you win";
    }
    int tries = 0;
    void playGame() throws InterruptedException {
        System.out.println("welcome to guess the number!");
        // could choose this but im lazy for now
        DifficultyFactory difficulty = DifficultyFactory.chooseDifficulty(DifficultyLevel.Easy);
        while (true){
            if(tries > difficulty.allowedAttempts){
                System.out.println("you lose");
                break;
            }
            String stringGuess = InputTimer.getInput(difficulty.timeOut);
            if(stringGuess.equals("invalid")){
                System.out.println("invalid input");
                tries++;
                continue;
            }
            try {
                Integer.parseInt(stringGuess);
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
                tries++;
                continue;
            }
            int guess = Integer.parseInt(stringGuess);
            tries++;
            String feedBack = guessTheNumberFeedBack(guess, difficulty.secretNumber);
            System.out.println(feedBack);
            if (feedBack.equals("you win")) {
                break;
            }
        }
        
    }
    
    
}
