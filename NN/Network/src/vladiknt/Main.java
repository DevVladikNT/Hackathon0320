package vladiknt;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[][] test = new double[][]{{100, 0, 0, 0, 0, 0, 0, 0, 100, 0, 100, 12, 2018}};
        Network nw = new Network(false);

        nw.show();
        System.out.println(nw.predict(test));
    }
}
