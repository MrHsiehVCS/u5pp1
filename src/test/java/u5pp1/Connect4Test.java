package u5pp1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.*;


public class Connect4Test {
    
	private  int[][] BOARD_EMPTY = new int[6][7];

	private  int[][] BOARD_FULL_RED = {
		{1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1},
	};
	private  int[][] BOARD_FULL_BLACK = {
		{-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1},
	};

	private  int[][] BOARD_FULL_SPLIT = {
		{-1,-1,-1,-1,1,1,1},
		{1,1,1,-1,-1,-1,-1},
		{-1,-1,-1,-1,1,1,1},
		{1,1,1,-1,-1,-1,-1},
		{-1,-1,-1,-1,1,1,1},
		{1,1,1,-1,-1,-1,-1},
	};

	private  int[][] BOARD_FULL_CHECKERED = {
		{-1,1,-1,1,-1,1,-1},
		{1,-1,1,-1,1,-1,1},
		{-1,1,-1,1,-1,1,-1},
		{1,-1,1,-1,1,-1,1},
		{-1,1,-1,1,-1,1,-1},
		{1,-1,1,-1,1,-1,1},
	};

	@BeforeAll
	public static void setUp() {
		
	}

	/*
	 * isFull 
	 * - half black half red
	 * - empty
	 * - everything except 1 corner
	 * - everything except other corner
	 * */ 

	@Test
	public void isFull_fullBoard_returnsTrue() {
		assertTrue(Connect4.isFull(BOARD_FULL_CHECKERED));
		assertTrue(Connect4.isFull(BOARD_FULL_BLACK));
		assertTrue(Connect4.isFull(BOARD_FULL_RED));
	}

	@Test
	public void isFull_emptyBoard_returnsFalse() {
		assertFalse(Connect4.isFull(BOARD_EMPTY));
	}

	@Test
	public void isFull_almostFullBoard_returnsFalse() {
		int[][] board1 = copyBoard(BOARD_FULL_BLACK);
		board1[0][0] = 0;
		int[][] board2 = copyBoard(BOARD_FULL_RED);
		board2[5][6] = 0;

		assertFalse(Connect4.isFull(board1));
		assertFalse(Connect4.isFull(board2));
	}



	/*
	 * isBoardValid
	 * - col of 6,5,4,3,2,1
	 * - empty
	 * - full
	 * - 1 piece floating (r2, col 1)
	 * - 1 piece floating (row max-1, col max)
	 * - full, but 1 piece missing (row 2, col 1)
	 * - full, but 1 piece missing (max row, max col)
	 */ 

	 @Test
	 public void isBoardValid_fullBoard_returnsTrue() {
		assertTrue(Connect4.isBoardValid(BOARD_FULL_BLACK));
		assertTrue(Connect4.isBoardValid(BOARD_FULL_RED));
		assertTrue(Connect4.isBoardValid(BOARD_FULL_CHECKERED));
		assertTrue(Connect4.isBoardValid(BOARD_FULL_SPLIT));
	 }

	 @Test
	 public void isBoardValid_emptyBoard_returnsTrue() {
		assertTrue(Connect4.isBoardValid(BOARD_EMPTY));
	 }

	 @Test
	 public void isBoardValid_stairsBoard_returnsTrue() {
		 int[][] boardStairs = {
			{1,0,0,0,0,0,0},
			{1,1,0,0,0,0,0},
			{1,1,1,0,0,0,0},
			{1,1,1,1,0,0,0},
			{1,1,1,1,1,0,0},
			{1,1,1,1,1,1,0},
		};
		
		assertTrue(Connect4.isBoardValid(boardStairs));
	 }

	 @Test
	 public void isBoardValid_floatingPieceBoard_returnsFalse() {
		 int[][] board1 = {
			{1,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
		};

		int[][] board2 = {
			{0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
		};

		int[][] board3 = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0},
		};
		
		assertFalse(Connect4.isBoardValid(board1));
		assertFalse(Connect4.isBoardValid(board2));
		assertFalse(Connect4.isBoardValid(board3));
	 }

	 @Test
	 public void isBoardValid_nearlyFullBoard_returnsFalse() {
		 int[][] board1 = {
			{1,1,1,1,1,1,1},
			{0,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
		};

		int[][] board2 = {
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,0},
		};

		int[][] board3 = {
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,0,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
		};
		
		assertFalse(Connect4.isBoardValid(board1));
		assertFalse(Connect4.isBoardValid(board2));
		assertFalse(Connect4.isBoardValid(board3));
	 }


	/*
	 * getWinner
	 * 
	 * - black
	 *   - horz (high, col 1)
	 *   - vert (high, col 1)
	 *   - diag up right (simple board)
	 *   - diag up left (full board)
	 * 
	 * - red
	 *   - horz (low, col max)
	 *   - vert (low, col max)
	 *   - diag up right (simple board)
	 *   - diag up left (full board)
	 * 
	 * - tie
	 *   - vert black, horz red
	 *   - diagonal black, diagonal red, full board
	 * 
	 * - no winner
	 *   - full board (lots of 3 in a rows)
	 *   - empty board
	 */

	 private int[][] copyBoard(int[][] board) {
		int[][] output = new int[board.length][board[0].length];
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				output[r][c] = board[r][c];
			}
		}
		return output;
	 }

}
