package vladiknt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Network {
    private double LEARNING_RATE = 0.001;
    private int EPOCHES = 1000;
    private int NUMBER_OF_EXAMPLES;
    private int INPUT = 13;
    private int HIDDEN_1 = 8;
    private int HIDDEN_2 = 4;
    private int OUTPUT = 1;

    private double[][] mat1 = new double[INPUT][HIDDEN_1]; // Веса рёбер
    private double[][] mat2 = new double[HIDDEN_1][HIDDEN_2];
    private double[][] mat3 = new double[HIDDEN_2][OUTPUT];

    private double[][] inputTrain; // Для loadTrain
    private double[][] expectedOutput;

    private double[][] hiddenTrain1; // Для correctError
    private double[][] hiddenTrain2;

    public Network(boolean a) {
        if (a) {
            // TODO дописать
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
        try {
            File file = new File("data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            NUMBER_OF_EXAMPLES = Integer.parseInt(br.readLine());
            inputTrain = new double[NUMBER_OF_EXAMPLES][INPUT];
            expectedOutput = new double[NUMBER_OF_EXAMPLES][1];
            String str;
            String[] arr;
            for (int i = 0; i < NUMBER_OF_EXAMPLES; i++) {
                str = br.readLine();
                arr = str.split(" ");
                for (int j = 0; j < INPUT; j++) {
                    inputTrain[i][j] = Double.parseDouble(arr[j]);
                }
            }
            str = br.readLine();
            arr = str.split(" ");
            for (int i = 0; i < NUMBER_OF_EXAMPLES; i++) {
                expectedOutput[i][0] = Double.parseDouble(arr[i]);
            }
        } catch(Exception e) {
            System.out.println("Error in data.txt");
            NUMBER_OF_EXAMPLES = 0;
        }
    }

    public double[][] predict(double[][] input) {
        hiddenTrain1 = sigmoid(multiply(input, mat1));
        hiddenTrain2 = sigmoid(multiply(hiddenTrain1, mat2));
        return sigmoid(multiply(hiddenTrain2, mat3));
    }

    public void train() {
        loadTrain();
        double[][] answer;
        double[][] arr = new double[1][INPUT];

        double[][] errorOutput;
        double[][] errorHidden2;
        double[][] errorHidden1;
        double[][] delta1;
        double[][] delta2;
        double[][] delta3;

        for (int i = 0; i < EPOCHES; i++) {
            for (int j = 0; j < NUMBER_OF_EXAMPLES; j++) {
                for (int k = 0; k < INPUT; k++) {
                    arr[0][k] = inputTrain[j][k];
                }
                answer = predict(arr);
                System.out.println(ASE(answer[0][0], expectedOutput[j][0])); //TODO выпилить

                errorOutput = substract(answer, expectedOutput);
                delta3 = multiplyElements(errorOutput, substract(answer, multiplyElements(answer, answer)));
                mat3 = substract(mat3, multiplyOnElement(multiply(transposition(hiddenTrain2), delta3), LEARNING_RATE));

                errorHidden2 = multiply(delta3, transposition(mat3));
                delta2 = multiplyElements(errorHidden2, substract(hiddenTrain2, multiplyElements(hiddenTrain2, hiddenTrain2)));
                mat2 = substract(mat2, multiplyOnElement(multiply(transposition(hiddenTrain1), delta2), LEARNING_RATE));

                errorHidden1 = multiply(delta2, transposition(mat2));
                delta1 = multiplyElements(errorHidden1, substract(hiddenTrain1, multiplyElements(hiddenTrain1, hiddenTrain1)));
                mat1 = substract(mat1, multiplyOnElement(multiply(transposition(arr), delta1), LEARNING_RATE));
            }
        }
    }

    private double ASE(double a, double b) {
        return Math.pow((a - b), 2);
    }

    private double[][] sigmoid(double[][] mat) {
        double[][] result = new double[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                result[i][j] = 1/(1 + Math.exp((-1)*mat[i][j]));
            }
        }
        return result;
    }

    private double[][] multiply(double[][] mat1, double[][] mat2) {
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

    private double[][] multiplyElements(double[][] mat1, double[][] mat2) {
        double[][] result = new double[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat1[0].length; j++) {
                result[i][j] = mat1[i][j] * mat2[i][j];
            }
        }
        return result;
    }

    private double[][] multiplyOnElement(double[][] mat, double a) {
        double[][] result = new double[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                result[i][j] = mat[i][j] * a;
            }
        }
        return result;
    }

    private double[][] substract(double[][] mat1, double[][] mat2) {
        double[][] result = new double[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++) {
            for(int j = 0; j < mat1[0].length; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }

    private double[][] transposition(double[][] mat) {
        double[][] matrix = new double[mat[0].length][mat.length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                matrix[j][i] = mat[i][j];
            }
        }
        return matrix;
    }

}
