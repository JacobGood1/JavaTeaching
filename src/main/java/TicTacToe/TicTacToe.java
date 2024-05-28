package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board(3);

        board.placeLetter("O", 2, 0);
        board.placeLetter("O", 1, 0);
        board.placeLetter("O", 0, 0);
        var result = board.checkHorizontal();
        System.out.println(result);
        board.displayBoard();
    }
}
