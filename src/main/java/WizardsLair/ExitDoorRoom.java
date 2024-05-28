package WizardsLair;

public class ExitDoorRoom extends Room {
    public ExitDoorRoom() {
        description = 
                """
                There is an exit door to the right, a room above and a room below...
                There appears to be some squirrel chanting in the corner as well.
                """;
    }

    @Override
    Item getItem() {
        System.out.println("There is no item in this room");
        return null;
    }

    @Override
    void useItem(Item item) {
//        if (item instanceof Key)
    }
}
