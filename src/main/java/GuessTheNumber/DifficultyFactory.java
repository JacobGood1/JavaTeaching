package GuessTheNumber;

import java.util.concurrent.ThreadLocalRandom;

//Factory Method is a creational design pattern that provides an interface for creating objects 
// in a superclass, but allows subclasses to alter the type of objects that will be created.

abstract class DifficultyFactory {
    int secretNumber;
    int allowedAttempts;
    int timeOut;

    public int secretNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    

    static DifficultyFactory chooseDifficulty(DifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case Easy -> new EasyMode();
            case Medium -> new MediumMode();
            case Hard -> new HardMode();
        };
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    static class HardMode extends DifficultyFactory {
        HardMode() {
            this.secretNumber = super.secretNumber(1, 500);
            this.allowedAttempts = 5;
            this.timeOut = 5000;
        }
    }

    static class MediumMode extends DifficultyFactory {
        MediumMode() {
            this.secretNumber = super.secretNumber(1, 100);
            this.allowedAttempts = 10;
            this.timeOut = 10000;
        }
    }

    static class EasyMode extends DifficultyFactory {
        EasyMode() {
            this.secretNumber = super.secretNumber(1, 50);
            this.allowedAttempts = 15;
            this.timeOut = 15000;
        }
    }
}
