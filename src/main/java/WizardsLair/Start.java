package WizardsLair;

public class Start extends Room {
    
    public Start() {
        right = generateRoom(Rooms.ExitDoorRoom);
        description = 
                STR."""
                You are in the start of the Wizards' Lair.
                There is a door to the right.
                What does your stupid self do?
                \{1 + 1}
                """;
    }

    @Override
    Item getItem() {
        System.out.println("There is nothing in this room");
        return null;
    }

    @Override
    void useItem(Item item) {
        
    }
}
