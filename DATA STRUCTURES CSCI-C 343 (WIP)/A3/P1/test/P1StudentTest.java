import org.junit.jupiter.api.Test;

import java.util.Random;

class P1StudentTest {

    @Test
    void test1_basicMixedPenalties() {
        int[][] twoLanes = {{1, 1}};
        int[][] constructions = {{2, 3}};
        int[][] crossings = {{2, 2}};
        int[][] oneWays = {{0, 2}};
        AutonomousVehicle av = new AutonomousVehicle(
                5, 4, 4,
                twoLanes, constructions, crossings, oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 10));
    }

    @Test
    void test2_rowWallDetour() {
        // A low “wall” near the bottom row, forcing a detour earlier.
        int[][] oneWays = {{3, 0}, {3, 1}, {3, 2}, {3, 3}};
        AutonomousVehicle av = new AutonomousVehicle(
                5, 4, 4,
                new int[0][0], new int[0][0], new int[0][0], oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 10));
    }

    @Test
    void test3_blockingColumn_mayBeUnreachable() {
        // Entire column y=1 is “one-way penalty” cells — path might still be chosen via reward tradeoffs,
        // but if your semantics treat these as terminal penalties, the plan will reflect that.
        int n = 10;
        int[][] oneWays = new int[n][2];
        for (int i = 0; i < n; i++) oneWays[i] = new int[]{i, 1};
        AutonomousVehicle av = new AutonomousVehicle(
                n, 0, 2,
                new int[0][0], new int[0][0], new int[0][0], oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 10));
    }

    @Test
    void test4_sparseObstacles_smallGrid() {
        int[][] oneWays = {{1, 1}, {1, 2}, {2, 3}};
        AutonomousVehicle av = new AutonomousVehicle(
                4, 3, 3,
                new int[0][0], new int[0][0], new int[0][0], oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 10));
    }

    @Test
    void test5_denseBands_largerGrid() {
        // A band of each penalty type along diagonals, encouraging careful routing.
        int[][] twoLanes = {
                {1, 1}, {1, 2}, {1, 3}, {1, 4},
                {1, 5}, {1, 6}, {1, 7}
        };
        int[][] constructions = {
                {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}
        };
        int[][] crossings = {
                {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3, 7}
        };
        int[][] oneWays = {
                {4, 4}, {4, 5}, {4, 6}, {4, 7}
        };
        AutonomousVehicle av = new AutonomousVehicle(
                12, 7, 7,
                twoLanes, constructions, crossings, oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 15));
    }

    @Test
    void test6_symmetricPairs() {
        int[][] twoLanes = {{1, 1}, {1, 10}};
        int[][] constructions = {{2, 2}, {2, 9}};
        int[][] crossings = {{3, 3}, {3, 8}};
        int[][] oneWays = {{4, 4}, {4, 7}};
        AutonomousVehicle av = new AutonomousVehicle(
                12, 7, 7,
                twoLanes, constructions, crossings, oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 15));
    }

    @Test
    void test7_seededRandomSprinkle() {
        int n = 10;
        int sprinkle = 6; // keep small for speed/stability
        int[][] twoLanes = new int[sprinkle][2];
        int[][] constructions = new int[sprinkle][2];
        int[][] crossings = new int[sprinkle][2];
        int[][] oneWays = new int[sprinkle][2];

        Random r = new Random(42); // fixed seed for reproducibility
        for (int i = 0; i < sprinkle; i++) {
            twoLanes[i] = new int[]{r.nextInt(n), r.nextInt(n)};
            constructions[i] = new int[]{r.nextInt(n), r.nextInt(n)};
            crossings[i] = new int[]{r.nextInt(n), r.nextInt(n)};
            oneWays[i] = new int[]{r.nextInt(n), r.nextInt(n)};
        }

        AutonomousVehicle av = new AutonomousVehicle(
                n, n - 1, n - 1,
                twoLanes, constructions, crossings, oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, n + 3));
    }

    @Test
    void test8_wallWithGap() {
        // Vertical “wall” at x=2, with a single gap at (2,3)
        int[][] oneWays = {
                {2, 0}, {2, 1}, {2, 2}, {2, 4}, {2, 5}
        };
        AutonomousVehicle av = new AutonomousVehicle(
                7, 6, 6,
                new int[0][0], new int[0][0], new int[0][0], oneWays
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 14));
    }

    @Test
    void test9_startIsGoal() {
        AutonomousVehicle av = new AutonomousVehicle(
                5, 0, 0,
                new int[0][0], new int[0][0], new int[0][0], new int[0][0]
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 6));
    }

    @Test
    void test10_depthZero_noPlanning() {
        AutonomousVehicle av = new AutonomousVehicle(
                5, 4, 4,
                new int[0][0], new int[0][0], new int[0][0], new int[0][0]
        );
        System.out.println(av);
        System.out.println(av.findBestPath(0, 0, 0)); // depth cap = 0
    }
}
