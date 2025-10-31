import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MatrixTest {

    @Test
    void testAdd() {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = {{7, 8, 9}, {10, 11, 12}};
        Matrix m1 = new Matrix(2, 3, arr1);
        Matrix m2 = new Matrix(2, 3, arr2);

        boolean result = m1.add(m2);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{8, 10, 12}, {14, 16, 18}}, m1.getMatrix());

        int[][] arr3 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr4 = {{1, 2}, {3, 4}};
        Matrix m3 = new Matrix(2, 3, arr3);
        Matrix m4 = new Matrix(2, 2, arr4);

        result = m3.add(m4);
        Assertions.assertFalse(result);
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, m3.getMatrix());

        int[][] arr5 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr6 = {};
        Matrix m5 = new Matrix(2, 3, arr5);
        Matrix m6 = new Matrix(0, 0, arr6);

        result = m5.add(m6);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, m5.getMatrix());

        int[][] arr7 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr8 = {{0, 0, 0}, {0, 0, 0}};
        Matrix m7 = new Matrix(2, 3, arr7);
        Matrix m8 = new Matrix(2, 3, arr8);

        result = m7.add(m8);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, m7.getMatrix());

        int[][] arr9 = {{5}};
        int[][] arr10 = {{10}};
        Matrix m9 = new Matrix(1, 1, arr9);
        Matrix m10 = new Matrix(1, 1, arr10);

        result = m9.add(m10);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{15}}, m9.getMatrix());
        }

    @Test
    void testMultiply() {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = {{7, 8}, {9, 10}, {11, 12}};
        Matrix m1 = new Matrix(2, 3, arr1);
        Matrix m2 = new Matrix(3, 2, arr2);

        boolean result = m1.multiply(m2);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{58, 64}, {139, 154}}, m1.getMatrix());

        int[][] arr3 = {{1, 2}, {3, 4}};
        int[][] arr4 = {{5, 6}, {7, 8}, {9, 9}};
        Matrix m3 = new Matrix(2, 2, arr3);
        Matrix m4 = new Matrix(3, 2, arr4);

        result = m3.multiply(m4);
        Assertions.assertFalse(result);
        Assertions.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, m3.getMatrix());

        int[][] arr5 = {{2, 3}, {4, 5}};
        int[][] arr6 = {{1, 0}, {0, 1}};
        Matrix m5 = new Matrix(2, 2, arr5);
        Matrix m6 = new Matrix(2, 2, arr6);

        result = m5.multiply(m6);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{2, 3}, {4, 5}}, m5.getMatrix());

        int[][] arr7 = {{3}};
        int[][] arr8 = {{4}};
        Matrix m7 = new Matrix(1, 1, arr7);
        Matrix m8 = new Matrix(1, 1, arr8);

        result = m7.multiply(m8);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{12}}, m7.getMatrix());


        int[][] arr9 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr10 = {{10, 20}, {30, 40}, {50, 60}};
        Matrix m9 = new Matrix(2, 3, arr9);
        Matrix m10 = new Matrix(3, 2, arr10);

        result = m9.multiply(m10);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{{220, 280}, {490, 640}}, m9.getMatrix());

        int[][] arr11 = {};
        int[][] arr12 = {};
        Matrix m11 = new Matrix(0, 0, arr11);
        Matrix m12 = new Matrix(0, 0, arr12);

        result = m11.multiply(m12);
        Assertions.assertTrue(result);
        Assertions.assertArrayEquals(new int[][]{}, m11.getMatrix());

    }

    @Test
    void testTranspose() {
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix m1 = new Matrix(3, 3, arr1);
        m1.transpose();
        Assertions.assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, m1.getMatrix());

        int[][] arr3 = {{1, 2, 3}};
        Matrix m3 = new Matrix(1, 3, arr3);
        m3.transpose();
        Assertions.assertArrayEquals(new int[][]{{1}, {2}, {3}}, m3.getMatrix());

        int[][] arr4 = {{1}, {2}, {3}};
        Matrix m4 = new Matrix(3, 1, arr4);
        m4.transpose();
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}}, m4.getMatrix());

        int[][] arr5 = {};
        Matrix m5 = new Matrix(0, 0, arr5);
        m5.transpose();
        Assertions.assertArrayEquals(new int[][]{}, m5.getMatrix());

        int[][] arr6 = {{1}};
        Matrix m6 = new Matrix(1, 1, arr6);
        m6.transpose();
        Assertions.assertArrayEquals(new int[][]{{1}}, m6.getMatrix());
    }

    @Test
    void testRotate(){
        int[][] arr1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Matrix m1 = new Matrix(3,3,arr1);
        m1.rotate();
        Assertions.assertArrayEquals( new int[][]{{7,4,1},{8,5,2},{9,6,3}}, m1.getMatrix());

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
        Matrix m2 = new Matrix(2, 3, arr2);
        m2.rotate();
        Assertions.assertArrayEquals(new int[][]{{4, 1}, {5, 2}, {6, 3}}, m2.getMatrix());

        int[][] arr3 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix m3 = new Matrix(3, 2, arr3);
        m3.rotate();
        Assertions.assertArrayEquals(new int[][]{{5, 3, 1}, {6, 4, 2}}, m3.getMatrix());

        int[][] arr4 = {{1, 2, 3}};
        Matrix m4 = new Matrix(1, 3, arr4);
        m4.rotate();
        Assertions.assertArrayEquals(new int[][]{{1}, {2}, {3}}, m4.getMatrix());

        int[][] arr5 = {{1}, {2}, {3}};
        Matrix m5 = new Matrix(3, 1, arr5);
        m5.rotate();
        Assertions.assertArrayEquals(new int[][]{{3, 2, 1}}, m5.getMatrix());

        int[][] arr6 = {};
        Matrix m6 = new Matrix(0, 0, arr6);
        m6.rotate();
        Assertions.assertArrayEquals(new int[][]{}, m6.getMatrix());

        int[][] arr7 = {{1}};
        Matrix m7 = new Matrix(1, 1, arr7);
        m7.rotate();
        Assertions.assertArrayEquals(new int[][]{{1}}, m7.getMatrix());
    }

    @Test
    void testSet(){
        int[][] arr1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Matrix m1 = new Matrix(3, 3, arr1);
        m1.set(0,0,0);
        Assertions.assertArrayEquals(new int[][]{{0,2,3},{4,5,6},{7,8,9}}, m1.getMatrix());

        m1.set(0,1,0);
        Assertions.assertArrayEquals(new int[][]{{0,0,3},{4,5,6},{7,8,9}}, m1.getMatrix());

        m1.set(100, 100, 0);
        Assertions.assertArrayEquals(new int[][]{{0,0,3},{4,5,6},{7,8,9}}, m1.getMatrix());
    }

    @Test
    void testToString(){
        int[][] arr1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Matrix m1 = new Matrix(3, 3, arr1);

        Assertions.assertEquals( "[[1, 2, 3], [4, 5, 6], [7, 8, 9]]", m1.toString());

        int[][] arr2 = new int[][]{};
        Matrix m2 = new Matrix(0, 0, arr2);

        Assertions.assertEquals( "[]", m2.toString());
    }
}
