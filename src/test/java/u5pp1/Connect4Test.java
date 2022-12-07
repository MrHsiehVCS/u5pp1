package u5pp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class Connect4Test {

	private int[][] BOARD_EMPTY = new int[6][7];

	private int[][] BOARD_FULL_RED = {
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 },
	};

	private int[][] BOARD_FULL_BLACK = {
			{ -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1 },
	};

	private int[][] BOARD_FULL_CHECKERED = {
			{ -1, 1, -1, 1, -1, 1, -1 },
			{ 1, -1, 1, -1, 1, -1, 1 },
			{ -1, 1, -1, 1, -1, 1, -1 },
			{ 1, -1, 1, -1, 1, -1, 1 },
			{ -1, 1, -1, 1, -1, 1, -1 },
			{ 1, -1, 1, -1, 1, -1, 1 },
	};

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

	@Test
	public void isBoardValid_fullBoard_returnsTrue() {
		assertTrue(Connect4.isBoardValid(BOARD_FULL_BLACK));
		assertTrue(Connect4.isBoardValid(BOARD_FULL_RED));
		assertTrue(Connect4.isBoardValid(BOARD_FULL_CHECKERED));
	}

	@Test
	public void isBoardValid_emptyBoard_returnsTrue() {
		assertTrue(Connect4.isBoardValid(BOARD_EMPTY));
	}

	@Test
	public void isBoardValid_stairsBoard_returnsTrue() {
		int[][] boardStairs = {
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 0 },
		};

		assertTrue(Connect4.isBoardValid(boardStairs));
	}

	@Test
	public void isBoardValid_floatingPieceBoard_returnsFalse() {
		int[][] board1 = {
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		assertFalse(Connect4.isBoardValid(board1));
		assertFalse(Connect4.isBoardValid(board2));
		assertFalse(Connect4.isBoardValid(board3));
	}

	@Test
	public void isBoardValid_nearlyFullBoard_returnsFalse() {
		int[][] board1 = {
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
		};

		int[][] board2 = {
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0 },
		};

		int[][] board3 = {
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 },
		};

		assertFalse(Connect4.isBoardValid(board1));
		assertFalse(Connect4.isBoardValid(board2));
		assertFalse(Connect4.isBoardValid(board3));
	}

	@Test
	public void getWinner_horizontalRedWin_returnsRedWin() {
		int[][] board1 = {
				{ 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1 },
		};

		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board3));
	}

	@Test
	public void getWinner_verticalRedWin_returnsRedWin() {
		int[][] board1 = {
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 1 },
		};

		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board3));
	}

	@Test
	public void getWinner_diagonalUpRedWin_returnsRedWin() {
		int[][] board1 = {
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
		};

		int[][] board4 = {
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
		};

		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board3));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board4));
	}

	@Test
	public void getWinner_diagonalDownRedWin_returnsRedWin() {
		int[][] board1 = {
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1 },
		};

		int[][] board4 = {
				{ 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 1 },
		};

		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board3));
		assertEquals(Connect4.RED_WIN, Connect4.getWinner(board4));
	}

	@Test
	public void getWinner_horizontalBlackWin_returnsBlackWin() {
		int[][] board1 = {
				{ -1, -1, -1, -1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, -1, -1, -1, -1, -1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board3 = {
				{ -1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, -1, -1, -1 },
		};

		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board3));
	}

	@Test
	public void getWinner_verticalBlackWin_returnsBlackWin() {
		int[][] board1 = {
				{ -1, 0, 0, 0, 0, 0, 0 },
				{ -1, 0, 0, 0, 0, 0, 0 },
				{ -1, 0, 0, 0, 0, 0, 0 },
				{ -1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, 0, -1 },
		};

		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board3));
	}

	@Test
	public void getWinner_diagonalUpBlackWin_returnsBlackWin() {
		int[][] board1 = {
				{ -1, 0, 0, 0, 0, 0, 0 },
				{ -1, -1, 0, 0, 0, 0, 0 },
				{ 0, 0, -1, 0, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ 0, -1, 0, 0, 0, 0, 0 },
				{ 0, 0, -1, -1, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, -1 },
				{ 0, 0, 0, 0, -1, 0, -1 },
				{ 0, 0, 0, 0, 0, -1, 0 },
				{ 0, 0, 0, 0, 0, 0, -1 },
		};

		int[][] board4 = {
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, 0, -1, 0, 0 },
				{ 0, 0, 0, -1, 0, -1, -1 },
				{ 0, 0, 0, 0, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, -1, 0 },
				{ 0, 0, 0, 0, 0, 0, -1 },
		};

		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board3));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board4));
	}

	@Test
	public void getWinner_diagonalDownBlackWin_returnsBlackWin() {
		int[][] board1 = {
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ -1, 0, -1, 0, 0, 0, 0 },
				{ 0, -1, -1, 0, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ 0, 0, -1, 0, 0, 0, 0 },
				{ 0, -1, 0, -1, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, -1, -1 },
				{ 0, 0, 0, 0, -1, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, -1 },
		};

		int[][] board4 = {
				{ 0, 0, 0, -1, 0, 0, -1 },
				{ 0, 0, 0, 0, -1, -1, 0 },
				{ 0, 0, 0, -1, -1, 0, -1 },
				{ 0, 0, 0, -1, 0, 0, -1 },
				{ 0, 0, 0, 0, 0, -1, 0 },
				{ 0, 0, 0, 0, 0, 0, -1 },
		};

		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board3));
		assertEquals(Connect4.BLACK_WIN, Connect4.getWinner(board4));
	}

	@Test
	public void getWinner_tie_returnsBothWin() {
		int[][] board1 = {
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ -1, 0, -1, 0, 0, 0, 0 },
				{ 0, -1, -1, 0, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0 },
		};

		int[][] board2 = {
				{ 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, -1, 0, 1, 0 },
				{ -1, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, -1, 1, 0, 0, 0 },
				{ -1, -1, -1, -1, 0, 0, 0 },
				{ -1, 0, 0, -1, 0, 0, 0 },
		};

		int[][] board3 = {
				{ 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, -1, 0, 0, -1 },
				{ 0, 0, 0, 1, 0, -1, -1 },
				{ 0, 0, 0, 0, -1, 0, 0 },
				{ 0, 0, 0, -1, 0, 0, -1 },
		};

		assertEquals(Connect4.BOTH_WIN, Connect4.getWinner(board1));
		assertEquals(Connect4.BOTH_WIN, Connect4.getWinner(board2));
		assertEquals(Connect4.BOTH_WIN, Connect4.getWinner(board3));
		assertEquals(Connect4.BOTH_WIN, Connect4.getWinner(BOARD_FULL_CHECKERED));
	}

	@Test
	public void getWinner_noWinnerBoard_returnsNoWinner() {
		int[][] board1 = {
			{ 1, 1, 1, 0,-1,-1,-1},
			{-1,-1,-1, 0, 1, 1, 1},
			{ 1, 1, 1, 0,-1,-1,-1},
			{-1,-1,-1, 0, 1, 1, 1},
			{ 1, 1, 1, 0,-1,-1,-1},
			{-1,-1,-1, 0, 1, 1, 1},
		};
		assertEquals(Connect4.NO_WINNER, Connect4.getWinner(BOARD_EMPTY));
		assertEquals(Connect4.NO_WINNER, Connect4.getWinner(board1));
	}

	private int[][] copyBoard(int[][] board) {
		int[][] output = new int[board.length][board[0].length];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				output[r][c] = board[r][c];
			}
		}
		return output;
	}

}
