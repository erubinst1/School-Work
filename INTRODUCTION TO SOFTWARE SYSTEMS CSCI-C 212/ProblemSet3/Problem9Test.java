import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem9Test {
    //boards
    char[][] board1 = new char[3][3];

    char[][] board2 = new char[][]{ {'B', ' ', ' '},
                                    {' ', ' ' ,'B'},
                                    {'B', ' ', ' '},
    };

    //next Boards
    char[][] boardInitial1 = new char[][]{ {'B', '-', '-'},
                                          {'-', '-', '-'},
                                          {'B', '-', '-'},
    };
    char[][] boardRevealed1 = new char[][]{ { 'B', '1', '0'},
                                            { '-', '2' ,'0'},
                                            { 'B', '1', '0'},
    };

    char[][] boardInitial2 = new char[][]{ {'-', '-', '-', '-'},
                                           {'-', '-', '-', '-'},
                                           {'-', '-', '-', 'B'},
                                           {'B', '-', '-', '-'},

    };
    char[][] boardRevealed2 = new char[][]{ { '0', '0', '0', '0'},
                                            { '0', '0', '1', '1'},
                                            { '1', '1' ,'1', 'B'},
                                            { 'B', '-', '-', '-'},
    };

    @Test
    void testProblem9a() {
        //isValidMove
        Assertions.assertAll(
                //isValidMove
                () -> Assertions.assertEquals( true, Problem9.isValidMove(board1, 0,0)),
                () -> Assertions.assertEquals( true, Problem9.isValidMove(board1, 0,2)),
                () -> Assertions.assertEquals( true, Problem9.isValidMove(board1, 2,0)),
                () -> Assertions.assertEquals( true, Problem9.isValidMove(board1, 2,2))
        );
    }

    @Test
    void testProblem9b() {
        //getValidNeighbors
        for(int i = 0; i < 3; i++) {
            Assertions.assertArrayEquals(
                    new int[][]{{1, 1}, {1, 2}, {2, 1}}[i], Problem9.getValidNeighbors(board1, 2, 2).get(i)
            );
        }

        for(int i = 0; i < 3; i++) {
            Assertions.assertArrayEquals(
                    new int[][]{{0, 0}, {0, 1}, {0, 2},
                                {1, 0}, {1, 1}, {1, 2},
                                {2, 0}, {2, 1}, {2, 2},
                    }[i],

                    Problem9.getValidNeighbors(board1, 1, 1).get(i)
            );
        }
    }

    @Test
    void testProblem9c() {
        //getNonMineNeighbors
        for(int i = 0; i < 3; i++) {
            Assertions.assertArrayEquals(
                    new int[][]{ {0, 1}, {0, 2},
                            {1, 0}, {1, 1},
                            {2, 1}, {2, 2},
                    }[i],

                    Problem9.getNonMineNeighbors(board2, 1, 1).get(i)
            );
        }
    }

    @Test
    void testProblem9d() {
        //getMineNeighbors
        for(int i = 0; i < 3; i++) {
            Assertions.assertArrayEquals(
                    new int[][]{ {0, 0},
                                            {1, 2},
                                 {2, 0}
                    }[i],

                    Problem9.getMineNeighbors(board2, 1, 1).get(i)
            );
        }
    }

    @Test
    void testProblem9e() {
        //countAdjacentMines
        Assertions.assertEquals(3, Problem9.countAdjacentMines(board2, 1, 1));
    }

    @Test
    void testProblem9f() {
        //extPath, tested in play
    }

    @Test
    void testProblem9g() {
        //makeBoard
        int N1 = 3;
        int M1 = 3;
        int B1 = 2;
        char[][] madeBoard1 = Problem9.makeBoard(N1, M1, B1);
        int bombCount1 = 0;
        for( char [] row: madeBoard1){
            for( char col: row){
                if( col == 'B'){
                    bombCount1+=1;
                }
            }
        }
        int finalBombCount1 = bombCount1;

        int N2 = 5;
        int M2 = 5;
        int B2 = 6;
        char[][] madeBoard2 = Problem9.makeBoard(N2, M2, B2);
        int bombCount2 = 0;
        for( char [] row: madeBoard2){
            for( char col: row){
                if( col == 'B'){
                    bombCount2+=1;
                }
            }
        }
        int finalBombCount2 = bombCount2;

        Assertions.assertAll(
                () -> Assertions.assertEquals(finalBombCount1, B1),
                () -> Assertions.assertEquals( madeBoard1.length, N1),
                () -> Assertions.assertEquals( madeBoard1[0].length, M1),
                () -> Assertions.assertEquals(finalBombCount2, B2),
                () -> Assertions.assertEquals( madeBoard2.length, N2),
                () -> Assertions.assertEquals( madeBoard2[0].length, M2)
        );

    }

    @Test
    void testProblem9h() {
        //play
        char[][] boardProcessed1 = Problem9.play(boardInitial1, 1, 2);
        Assertions.assertArrayEquals(boardRevealed1, boardProcessed1);

        char[][] boardProcessed2 = Problem9.play(boardInitial2, 0, 0);
        Assertions.assertArrayEquals(boardRevealed2, boardProcessed2);
    }
}
