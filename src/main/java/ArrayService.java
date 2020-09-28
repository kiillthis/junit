import exceptions.RowNegativeException;
import exceptions.NotEnoughRowsAndColumnException;
import exceptions.RowZeroException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayService {
    public ArrayService() {
    }

    public int[][] sortArray(int[][] array, int row) {

        checkEmptyArray(array);

        checkZeroRow(row);

        checkIfOnlyOneRow(array);

        checkRowAndBounds(array, row);

        checkIfRowIsNegative(row);

        for (int i = 0; i < array.length; i++) {

            if ((i + 1) % row == 0) {

                for (int k = 0; k < array[i].length; k++) {
                    for (int l = array[i].length - 1; l > k; l--) {
                        if (array[i][l - 1] < array[i][l]) {
                            int tmp = array[i][l - 1];
                            array[i][l - 1] = array[i][l];
                            array[i][l] = tmp;
                        }
                    }
                }
            }

        }

        return array;
    }


    public ArrayList<Double> getAverage(int[][] array, int row) {

        checkEmptyArray(array);

        checkZeroRow(row);

        checkIfOnlyOneRow(array);

        checkRowAndBounds(array, row);

        checkIfRowIsNegative(row);

        ArrayList<Double> avg = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % row != 0) {
                OptionalDouble avgOfRow = Arrays.stream(array[i]).average();
                avg.add(avgOfRow.orElseThrow(IllegalStateException::new));
            }
        }

        return avg;
    }


    private void checkEmptyArray(int[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        if (array[0].length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
    }

    private void checkZeroRow(int row) {
        if (row == 0) {
            throw new RowZeroException("Input 0 in row argument");
        }
    }

    private void checkIfOnlyOneRow(int[][] array) {
        if (array.length == 1) {
            throw new NotEnoughRowsAndColumnException("Array has only one row");
        }
    }

    private void checkRowAndBounds(int[][] array, int row) {
        if (row >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Row is greater than bounds of array");
        }
    }

    private void checkIfRowIsNegative(int row) {
        if (row < 0) {
            throw new RowNegativeException("Row is negative number");
        }
    }
}
