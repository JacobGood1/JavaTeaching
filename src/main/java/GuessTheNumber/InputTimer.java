package GuessTheNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class InputTimer {
    //i need methods to share some data, i want the data to be reset every time
    private final BufferedReader getInput = new BufferedReader(new InputStreamReader(System.in));
    private final int timeoutDuration;
    private final ExecutorService executors = Executors.newVirtualThreadPerTaskExecutor();
    private String input;
    

    void waitForInput(){
        try {
            while (!getInput.ready()) {Thread.sleep(16);}
            input = getInput.readLine();
            executors.shutdownNow();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    void timerCountdown(){
        IntStream.range(1, timeoutDuration / 1000)
                .mapToObj(i -> i)
                .toList()
                .reversed()
                .forEach(i -> {
                    try {
                        Thread.sleep(1000);
                        System.out.println(STR."Time Left: \{i}");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
    private InputTimer(int timeoutDuration) throws InterruptedException {
        this.timeoutDuration = timeoutDuration;
        // create a virtual thread
        input = "invalid";
        // wait for user input
        executors.submit(this::waitForInput);
        // timer countdown
        executors.submit(this::timerCountdown);
        // timeout
        executors.awaitTermination(timeoutDuration, TimeUnit.MILLISECONDS);
        
        if(input.equals("invalid")) {
            System.out.println("TOOK TOO LONG NUB HAR HAR");
        }
        executors.shutdownNow();
        
    }
    static String getInput(int timeOut) throws InterruptedException {
        return new InputTimer(timeOut).input;
    }
}
