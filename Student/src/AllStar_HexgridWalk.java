import java.util.*;
import java.io.*;

/*
 * Caden Kang
 * ACSL All-Star Contest 2017-2018 3. Hexgrid Walk
 */

public class AllStar_HexgridWalk {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("1718as.in"));

        for (int i = 0; i < 20; i++) {
            String s = in.next();
            char c = s.charAt(0);
            int n = Integer.parseInt(s.substring(1));

            String temp = in.next();
            String[] m = new String[temp.length()];
            m = temp.split("");

            int[][] move1 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, 1 } }; //for A, C, E, ...
            int[][] move2 = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 } }; //for B, D, F, ...

            for (int j = 0; j < m.length; j++) {
                int let = 0;
                int num = 0;
                //for A, C, E, ...
                if (c % 2 == 1) {
                    let = move1[Integer.parseInt(m[j])][0];
                    num = move1[Integer.parseInt(m[j])][1];
                }
                //for B, D, F, ...
                else {
                    let = move2[Integer.parseInt(m[j])][0];
                    num = move2[Integer.parseInt(m[j])][1];
                }

                c += let; //moving
                n += num; //moving

                //in case of moving off grid
                if (c < 'A' || c > 'Z' || n <= 0) {
                    c -= let;
                    n -= num;
                }
            }

            System.out.println(c + "" + n);
        }
    }

}