package vladiknt;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[][] mat1 = new double[][] {
                {1, 2, 4, 5},
                {3, 4, 12, 78},
                {1, 4, 18, 7}
        };
        double[][] mat2 = new double[][] {
                {5, 7, 1, 6},
                {1, 7, 1, 7},
                {5, 12, 13, 9},
                {45, 16, 6, -1}
        };

        System.out.println(Arrays.deepToString(Matrix.multiply(mat1, mat2)));
    }
}
