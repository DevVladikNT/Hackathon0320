package vladiknt;

public class Network {
    private double LEARNING_RATE = 0.1;
    private double[][] mat1;
    private double[][] mat2;
    public Network(){

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

}
