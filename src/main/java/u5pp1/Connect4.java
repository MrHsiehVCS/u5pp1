package u5pp1;

public class Connect4 {

    public static final int RED_WIN = 0;
    public static final int BLACK_WIN = 1;
    public static final int NO_WINNER = 2;
    public static final int BOTH_WIN = 3;

    public static boolean isFull(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBoardValid(int[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            boolean foundAPiece = false;
            for (int r = 0; r < board.length; r++) {

                if (foundAPiece && board[r][c] == 0) {
                    return false;
                }

                if (board[r][c] != 0) {
                    foundAPiece = true;
                }
            }
        }
        return true;
    }

    public static int getWinner(int[][] board) {
        // TODO
        return RED_WIN;
    }

}
