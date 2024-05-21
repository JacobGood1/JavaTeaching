package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        Board board = Board.makeBoard(3);

        board.displayBoard();
        System.out.println(board.get(0).getDownRight());
    }
}
