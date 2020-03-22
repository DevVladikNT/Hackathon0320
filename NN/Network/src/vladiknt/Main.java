package vladiknt;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        while (true) {
            Network nw = new Network(false);
            nw.train();
            double[][] test1 = new double[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; // 0
            System.out.println(Arrays.deepToString(nw.predict(test1)));
            double[][] test2 = new double[][]{{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; // 0.7
            System.out.println(Arrays.deepToString(nw.predict(test2)));
            double[][] test3 = new double[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}; // 1
            System.out.println(Arrays.deepToString(nw.predict(test3)));
            double[][] test4 = new double[][]{{1, 0, 0, 0, 0, 0, 0, 1, 0, 0}}; // 1
            System.out.println(Arrays.deepToString(nw.predict(test4)));
            double[][] test5 = new double[][]{{0, 0, 0, 0, 0, 0, 1, 0, 1, 0}}; // 0.4
            System.out.println(Arrays.deepToString(nw.predict(test5)));

            Thread.sleep(5000);
        }
    }
}
