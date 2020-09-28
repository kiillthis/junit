import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 5; //(int) (Math.random() * 11);
        int j = 5; // (int) (Math.random() * 11);
        int[][] array = new int[i][j];

        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                array[k][l] = (int) (Math.random() * 11);
            }
        }
        System.out.println("My array");
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                System.out.print(array[k][l] + " ");
            }
            System.out.println(" ");
        }


        ArrayService as = new ArrayService();

        array = as.sortArray(array, 2);


        System.out.println("My array after work");
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                System.out.print(array[k][l] + " ");
            }
            System.out.println(" ");
        }
    }
}
