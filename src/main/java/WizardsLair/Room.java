package WizardsLair;

import java.util.List;

import static WizardsLair.Rooms.KeyRoom;

abstract class Room {
    boolean isAlreadyDisplayed = false;
    Room up;
    Room down;
    Room left;
    Room right;
    String description;
    Item item;
    @Override
    public String toString() {
        return description + "\n Please give a command: "; 
    }
    void displayRoom(){
        if (!isAlreadyDisplayed) {
            System.out.println(this);
            isAlreadyDisplayed = true;
        }
    }
    
    public Room goToRoom(String room){
        Room roomToGoTo;
        if(room.equals("left")){
            roomToGoTo = left;
        } else if(room.equals("right")){
            roomToGoTo = right;
        } else if(room.equals("up")){
            roomToGoTo = up;
        } else {
            roomToGoTo = down;
        }
        if (roomToGoTo == null){
            System.out.println("You can't go that way");
            return this;
        }
        this.isAlreadyDisplayed = false;
        return roomToGoTo; 
    }
    public static Room generateRoom(Rooms room){
        return switch (room){
            case StartRoom -> new Start();
            case ExitDoorRoom -> new ExitDoorRoom();
            default -> throw new IllegalStateException("Unexpected value: " + room);
        };
    }
    abstract Item getItem();
    abstract void useItem(Item item);
}
