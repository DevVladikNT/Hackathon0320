package vladiknt;

public class Matrix {
    public static double[][] multiply(double[][] mat1, double[][] mat2) {
//        double[][] arr = {
//                {1, 2},
//                {3, 4}
//        };
        double[][] result = new double[mat1.length][mat2[0].length];
        double sum;

        if(mat1[0].length == mat2.length) {
            for(int i = 0; i < mat1.length; i++){
                for(int j = 0; j < mat2[0].length; j++) {
                    sum = 0;
                    for(int k = 0; k < mat1[0].length; k++) {
                        sum += mat1[i][k] * mat2[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return result;
        }
        return null;
    }
}
