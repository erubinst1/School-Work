import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MazeSolver {

    private final char[][] MAZE;

    MazeSolver(String in) {
        try (Scanner s = new Scanner(new File(in))) {
            String[] dimensions = s.nextLine().split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);

            MAZE = new char[row][col];

            for (int i = 0; i < row; i++) {
                String line = s.nextLine().trim();

                for (int j = 0; j < col; j++) {
                    MAZE[i][j] = line.charAt(j);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found: " + in, e);
        }
    }


    /**
     * Recursively solves the maze, returning a solution if it exists,
     * and null otherwise. We use a simple backtracking algorithm
     * in the helper.
     * @return a solution to the maze, or null if it does not exist.
     */
    char[][] solve() {
        char[][] soln = new char[MAZE.length][MAZE[0].length];

        for(int i = 0; i < MAZE.length; i++) {
            System.arraycopy(MAZE[i], 0, soln[i], 0, MAZE[0].length);
        }

        return this.solveHelper(0, 0, soln) ? soln : null;
    }

    /**
     * Recursively solves the maze, returning true if we ever reach the exit
     * We try al possible paths from the current cell, if they are reachable
     * If a path ends up being a dead end, we backtrack and try another path
     * @param r the row of the current cell
     * @param c the column of the current cell
     * @param sol the current maze
     * @return true if we are at the exit, false otherwise
     */
    private boolean solveHelper(int r, int c, char[][] sol) {
        if(r < 0 || r >= MAZE.length || c < 0 || c >= MAZE[0].length) {
            return false;
        }

        if(sol[r][c] != '.') {
            return false;
        }

        //base case
        if(r == MAZE.length - 1 && c == MAZE[0].length - 1) {
            sol[r][c] = '*';
            return true;
        }

        sol[r][c] = '*';

        if(solveHelper(r + 1, c, sol) || solveHelper(r, c + 1, sol) || solveHelper(r - 1, c, sol) || solveHelper(r, c - 1, sol)) {
            return true;
        }

        sol[r][c] = '.';
        return false;
    }

    /**
     * outputs the given solution to the maze to a file specified by the parameter
     * @param fileName input file containing the maze
     * @param soln maze solution, if it exists, null otherwise
     */
    void output(String fileName, char[][] soln) {
        if(soln == null) {
            throw new RuntimeException("There is no solution for this maze");
        }

        try(FileWriter writer = new FileWriter(fileName)) {
            for (char[] row : soln) {
                writer.write(new String(row) + "\n");
            }
        }catch (IOException e){
            throw new RuntimeException("Error writing to file: " + fileName, e);
        }
    }
}
