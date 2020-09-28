import exceptions.RowNegativeException;
import exceptions.NotEnoughRowsAndColumnException;
import exceptions.RowZeroException;
import org.junit.*;

import java.util.ArrayList;

public class ArrayServiceTest {


    @Test
    public void sortArray() {
        int[][] arrayToTest = new int[][]{
                {5, 3, 7, 8, 3},
                {1, 2, 3, 4, 5},
                {4, 7, 2, 7, 5},
                {1, 2, 3, 4, 5},
                {3, 7, 4, 8, 5}
        };

        int[][] expected = new int[][]{
                {5, 3, 7, 8, 3},
                {5, 4, 3, 2, 1},
                {4, 7, 2, 7, 5},
                {5, 4, 3, 2, 1},
                {3, 7, 4, 8, 5}
        };

        int[][] actual = new ArrayService().sortArray(arrayToTest, 2);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAverage() {
        int[][] arrayToTest = {
                {5, 1, 7, 2, 8, 7},
                {10, 7, 9, 3, 6, 1},
                {1, 4, 6, 1, 9, 3},
                {7, 4, 3, 8, 0, 2},
                {2, 3, 4, 4, 11, 12}
        };

        ArrayList<Double> expected = new ArrayList<>();

        expected.add(5d);
        expected.add(4d);
        expected.add(6d);

        ArrayList<Double> actual = new ArrayService().getAverage(arrayToTest, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverage2() {
        int[][] arrayToTest = {
                {5, 1, 7, 2, 8, 7},
                {1, 2, 3, 4, 6, 8},
                {7, 8, 9, 10, 11, 12},
                {1, 8, 9, 7, 5, 6},
                {13, 14, 15, 17, 18, 19}
        };

        ArrayList<Double> expected = new ArrayList<>();

        expected.add(5d);
        expected.add(4d);
        expected.add(6d);
        expected.add(16d);

        ArrayList<Double> actual = new ArrayService().getAverage(arrayToTest, 3);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithEmptyArray() {
        int[][] array = new int[0][0];
        int row = 2;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithEmptyArray2() {
        int[][] array = new int[1][0];
        int row = 2;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageWithEmptyArray() {
        int[][] array = new int[0][0];
        int row = 2;

        ArrayList<Double> actual = new ArrayService().getAverage(array, row);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAverageWithEmptyArray2() {
        int[][] array = new int[1][0];
        int row = 2;

        ArrayList<Double> actual = new ArrayService().getAverage(array, row);
    }

    @Test(expected = RowZeroException.class)
    public void sortWithIndexEqualsZero() {
        int[][] array = new int[2][2];
        int row = 0;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = RowZeroException.class)
    public void getAverageWithIndexEqualsZero() {
        int[][] array = new int[2][2];
        int row = 0;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = NotEnoughRowsAndColumnException.class)
    public void sortWithOneRow() {
        int[][] array = new int[1][2];
        int row = 2;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = NotEnoughRowsAndColumnException.class)
    public void getAverageWithOneRow() {
        int[][] array = new int[1][2];
        int row = 2;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void sortWithRowGreaterThanBounds() {
        int[][] array = new int[5][5];
        int row = 10;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getAverageWithRowGreaterThanBounds() {
        int[][] array = new int[5][5];
        int row = 10;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = RowNegativeException.class)
    public void sortWithNegativeRow() {
        int[][] array = new int[5][5];
        int row = -1;

        int[][] actual = new ArrayService().sortArray(array, row);
    }

    @Test(expected = RowNegativeException.class)
    public void getAverageWithNegativeRow() {
        int[][] array = new int[5][5];
        int row = -1;

        int[][] actual = new ArrayService().sortArray(array, row);
    }
}
