# u5pp1

In this project, you will create a couple of helper methods for the game of Connect 4. You will not be making the main gameplay loop. :)

## Connect 4 Rules

TLDR: If you don't know the rules, google it, or watch a youtube play through.

Boards are 6 tall, but 7 wide. Pieces are added from the top, and pieces fall to the lowest available spot in their column, due to gravity. Pieces may not be added to columns that are full. First person to have 4-in-a-row (vertically, horizontally, or diagonally) wins. 

## `Connect4.java`

- `public static boolean isFull(int[][] board)` - returns true if all the board spaces have a piece in them. Red pieces are indicated by `1` and black pieces are indicated by `-1`. Empty spaces are indicated by `0`.
- `public static boolean isBoardValid(int[][] board)` - returns true if the board is a valid configuration. A board is valid if there are no empty spaces under any pieces.
- `public static int getWinner(int[][] board)` - returns `RED_WIN` if red wins, and `BLACK_WIN` if black wins. Returns `NO_WINNER` there is no winner. Returns `BOTH_WIN` if both red and black have a 4-in-a-row. Each of the return variables are found at the top of the class.

**Note**: boards are formatted as row-major 2D arrays, as is convention. This means that `board[0][4]` will access the top row, 5th column.

## Extra credit

- actual gameplay (`play()` method)
  - possible helper methods: `dropPiece(int color, int column)`, `takePlayerTurn()`, `takeAiTurn()`
- AI to play against (picks move randomly)
- AI (picks winning moves)
- AI (tries to make 3 in a row if possible)
- AI (anything more complicated)

## Grading Breakdown

- Proper formatting/indentation: 2 points
- Commented all code: 2 points
- Has no public members other than those specified: 2 points
- Pass all test cases : 6 pts
Total: 12 points
