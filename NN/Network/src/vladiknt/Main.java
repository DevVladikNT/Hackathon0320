package vladiknt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 - to create and train new neural network, 2 - to predict with existing");
        if(sc.nextInt() == 1) {
            Network nw = new Network(false);
            try {
                nw.save();
            } catch(Exception e) {
                System.out.println("file has been crushed");
            }
        } else {
            Network nw = new Network(true);
            double[][] test1 = new double[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; // должно быть 0
            System.out.println(Arrays.deepToString(nw.predict(test1)));
            double[][] test2 = new double[][]{{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; // должно быть 0.7
            System.out.println(Arrays.deepToString(nw.predict(test2)));
            double[][] test3 = new double[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}; // должно быть 1
            System.out.println(Arrays.deepToString(nw.predict(test3)));
            double[][] test4 = new double[][]{{1, 0, 0, 0, 0, 0, 0, 1, 0, 0}}; // должно быть 1
            System.out.println(Arrays.deepToString(nw.predict(test4)));
            double[][] test5 = new double[][]{{0, 0, 0, 0, 0, 0, 1, 0, 1, 0}}; // должно быть 0.4
            System.out.println(Arrays.deepToString(nw.predict(test5)));
            double[][] test6 = new double[][]{{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}}; // ? наверно стоит
            System.out.println(Arrays.deepToString(nw.predict(test6)));
        }
    }
}
