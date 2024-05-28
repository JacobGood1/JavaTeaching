package WizardsLair;

import java.util.Map;
import java.util.function.Function;

public class Commands {
    
    static Map<String, Function<Room, Room>> commandMap = 
            Map.of("go left", (Room room) -> room.goToRoom("left"),
                    "go right" , (Room room) -> room.goToRoom("right"),
                    "go up" , (Room room) -> room.goToRoom("up"),
                    "go down" , (Room room) -> room.goToRoom("down"));
    
    public static Room executeCommand(String command, Room room) {
        var result = commandMap.get(command);
        if (result == null) {
            System.out.println("invalid command");
            return room;
        }
        return result.apply(room);
    }
}
