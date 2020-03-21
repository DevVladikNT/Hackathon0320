package vladiknt;

import java.util.Arrays;

public class Network {
    private double LEARNING_RATE = 0.1;
    private int HIDDEN_1 = 10;
    private int HIDDEN_2 = 6;
    private double[][] mat1 = new double[13][HIDDEN_1];
    private double[][] mat2 = new double[HIDDEN_1][HIDDEN_2];
    private double[][] mat3 = new double[HIDDEN_2][1];

    public Network(boolean a) {
        if (a) {
            //
        } else {
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    mat1[i][j] = Math.random()*2 - 1; // Диапазон случайных начальных весов (-1; 1)
                }
            }
            for (int i = 0; i < mat2.length; i++) {
                for (int j = 0; j < mat2[0].length; j++) {
                    mat2[i][j] = Math.random()*2 - 1;
                }
            }
            for (int i = 0; i < mat3.length; i++) {
                for (int j = 0; j < mat3[0].length; j++) {
                    mat3[i][j] = Math.random()*2 - 1;
                }
            }
        }
    }

    public void show() {
        System.out.println(Arrays.deepToString(mat1));
        System.out.println(Arrays.deepToString(mat2));
        System.out.println(Arrays.deepToString(mat3));
    }

    private void load() {
        //
    }

    private void save() {
        //
    }

    private  void loadInput() {
        //
    }

    private void loadTrain() {
        //
    }

    public double predict(double[][] input) {
        double[][] answer;
        answer = sigmoid(multiply(input, mat1));
        answer = sigmoid(multiply(answer, mat2));
        answer = sigmoid(multiply(answer, mat3));
        return answer[0][0];
    }

    private void train(double[][] mat, double[] vec) {
        //
    }

    private void correctError() {
        //
    }

    private void ESE() {
        //
    }

    private double[][] sigmoid(double[][] mat) {
        double[][] result = new double[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                result[i][j] = 1/(1 + Math.exp(-mat[i][j]));
            }
        }
        return result;
    }

    public static double[][] multiply(double[][] mat1, double[][] mat2) {
        double[][] result = new double[mat1.length][mat2[0].length];
        double sum;

        if (mat1[0].length == mat2.length) {
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat2[0].length; j++) {
                    sum = 0;
                    for (int k = 0; k < mat1[0].length; k++) {
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
