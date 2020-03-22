package vladiknt;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception{
        while (true) {
            Network nw = new Network(false);
            nw.train();
//            double[][] test1 = new double[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//            System.out.println(Arrays.deepToString(nw.predict(test1)));
            double[][] test2 = new double[][]{{0, 100, 0, 100, 0, 0, 0, 0, 0, 0, 250, 17, 2015}};
            System.out.println(Arrays.deepToString(nw.predict(test2)));
            double[][] test3 = new double[][]{{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 110, 20, 2000}};
            System.out.println(Arrays.deepToString(nw.predict(test3)));
            double[][] test4 = new double[][]{{100, 0, 0, 0, 0, 0, 0, 0, 100, 0, 3000, 12, 2018}};
            System.out.println(Arrays.deepToString(nw.predict(test4)));
            double[][] test5 = new double[][]{{100, 0, 0, 0, 0, 0, 0, 0, 100, 0, 110, 12, 2018}};
            System.out.println(Arrays.deepToString(nw.predict(test5)));

            Thread.sleep(5000);
        }
    }
}
