package u5pp1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.*;


public class Connect4Test {
    
	@SuppressWarnings("unchecked")
	@Test
	public void testTest() {
		List<String> mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertTrue(mockList.size()==5);
	}

	/*
	 * test for...
	 * isFull 
	 * - half black half red
	 * - empty
	 * - everything except 1 corner
	 * - everything except other corner
	 * 
	 * isBoardValid
	 * - col of 6,5,4,3,2,1
	 * - empty
	 * - full
	 * - 1 piece floating (r2, col 1)
	 * - 1 piece floating (row max-1, col max)
	 * - full, but 1 piece missing (row 2, col 1)
	 * - full, but 1 piece missing (max row, max col)
	 * 
	 * getWinner
	 * - black
	 *   - horz (high, col 1)
	 *   - vert (high, col 1)
	 *   - diag up right (simple board)
	 *   - diag up left (full board)
	 *   
	 * 
	 * - red
	 *   - horz (low, col max)
	 *   - vert (low, col max)
	 *   - diag up right (simple board)
	 *   - diag up left (full board)
	 * 
	 * - tie
	 * 
	 *   - vert black, horz red
	 *   - diagonal black, diagonal red, full board
	 * 
	 * - no winner
	 *   - full board (lots of 3 in a rows)
	 *   - empty board
	 * 
	 */
}
