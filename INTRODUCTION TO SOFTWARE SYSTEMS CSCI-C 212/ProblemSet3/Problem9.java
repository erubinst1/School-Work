// Exercise 3.66

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem9 {

    /**
     * Tells if a move is valid based on the coordinates of the move and the board size
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the move
     * @param my y coordinate of the move
     * @return true if the move is within the bounds of the board, false if not
     */
    static boolean isValidMove(char[][] board, int mx, int my) {
        int boardWidthMin = 0;
        int boardWidthMax = board[0].length-1;
        int boardHeightMin = 0;
        int boardHeightMax = board.length-1;

        return boardWidthMin <= mx && mx <= boardWidthMax && boardHeightMin <= my && my <= boardHeightMax;
    }

    /**
     * Makes a list of all valid or in-bounds neighbors to a given cell on a minesweeper board
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the position
     * @param my y coordinate of the position
     * @return list of arrays, each containing the coordinates of valid moves, x coordinate in index 0 and y coordinate in index 1
     */
    static List<int[]> getValidNeighbors(char[][] board, int mx, int my) {
        List<int[]> close = new ArrayList<>();
        for( int x = -1; x < 2; x++){
            for(int y = -1; y < 2; y++){
                if( x == 0 && y == 0){
                    continue;
                }
                int[] tempArr = new int[2];
                tempArr[0] = mx + x;
                tempArr[1] = my + y;
                if(isValidMove(board, tempArr[0], tempArr[1])){
                    close.add(tempArr);
                }
            }
        }
        return close;
    }

    /**
     * Makes a list of all the neighbors that do not have mines, given a position and a minesweeper board
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the position
     * @param my y coordinate of the position
     * @return list of arrays, each containing the coordinates of neighbors with no mines, x coordinate in index 0 and y coordinate in index 1
     */
    static List<int[]> getNonMineNeighbors(char[][] board, int mx, int my) {
        List<int[]> valid = getValidNeighbors(board, mx, my);
        List<int[]> safe = new ArrayList<>();

        for (int[] move : valid) {
            int x = move[0];
            int y = move[1];

            if (board[x][y] != 'B') {
                safe.add(move);
            }
        }
        return safe;
    }

    /**
     * Makes a list of all the neighbors that have mines, given a position and a minesweeper board
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the position
     * @param my y coordinate of the position
     * @return list of arrays, each containing the coordinates of neighbors with no mines, x coordinate in index 0 and y coordinate in index 1
     */
    static List<int[]> getMineNeighbors(char[][] board, int mx, int my) {
        List<int[]> valid = getValidNeighbors(board, mx, my);
        List<int[]> mine = new ArrayList<>();

        for (int[] move : valid) {
            int x = move[0];
            int y = move[1];

            if (board[x][y] == 'B') {
                mine.add(move);
            }
        }
        return mine;
    }

    /**
     * Counts the adjacent mines, given a position and a minesweeper board
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the position
     * @param my y coordinate of the position
     * @return number of mines in adjacent positions to the position given
     */
    static int countAdjacentMines(char[][] board, int mx, int my) {
        return getMineNeighbors(board, mx, my).size();
    }

    /**
     * Searches through a position and reveals all non-mine adjacent positions
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the position
     * @param my y coordinate of the position
     */
    static void extPath(char[][] board, int mx, int my) {

        if(!isValidMove(board,mx,my)){
            return;
        }

        List<int[]> valid = getValidNeighbors(board,mx,my);
        boolean returnFlag = false;


        if(board[mx][my] != '-'){
            return;
        }

        int numAdjacentMines = countAdjacentMines(board, mx, my);

        if(  numAdjacentMines != 0){
            board[mx][my] = (char) ('0'+ numAdjacentMines);
        }
        else{
            board[mx][my] = '0';
            List<int[]> nonMine = getNonMineNeighbors(board, mx, my);
            for( int[] arr: nonMine){
                extPath(board, arr[0], arr[1]);
            }
        }
    }

    /**
     * Generates a minesweeper board
     *
     * @param N number of rows
     * @param M number of columns
     * @param B number of mines
     * @return The created board
     */
    static char[][] makeBoard(int N, int M, int B) {
        char[][] board = new char[N][M];
        List<int[]> allCells = new ArrayList<>();

        for( int row = 0; row < board.length; row++){
            for( int col = 0; col < board[0].length; col++){
                allCells.add(new int[]{col, row});
            }
        }

        Collections.shuffle(allCells);

        for( char[] row: board){
            for( char col: row){
                col = '-';
            }
        }
        for( int i = 1; i <= B; i++){
            int[] tempCell = allCells.get(i);
            board[tempCell[0]][tempCell[1]] = 'B';
        }

        return board;
    }

    /**
     * Plays one state of minesweeper
     *
     * @param board char 2d array representing a minesweeper board
     * @param mx x coordinate of the position
     * @param my y coordinate of the position
     * @return Next board state, or null if a mine is hit
     */
    static char[][] play(char[][] board, int mx, int my) {
        if(board[mx][my] == 'B'){
            return null;
        }

        extPath(board, mx, my);
        return board;
    }
}
