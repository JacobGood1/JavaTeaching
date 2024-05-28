package WizardsLair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameEngine {
    Room room;
    // create a buffered reader
    private final BufferedReader getInput = new BufferedReader(new InputStreamReader(System.in));   
    public GameEngine(){
        room = Room.generateRoom(Rooms.StartRoom);
    }
    void run() throws IOException {
        // instantiate the buffered reader
        
        while(true){
            room.displayRoom();
            if (getInput.ready()){
                String input = getInput.readLine();
                room = Commands.executeCommand(input, room);
            }
            
        }
    }

    public static void main(String[] args) throws IOException {
        new GameEngine().run();
    }
}
