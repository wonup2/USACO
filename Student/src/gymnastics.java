import java.util.*;
import java.io.*;
public class gymnastics {
    static Scanner in;
    static PrintWriter out;
    static int cow, round, count;
    static int[][] a;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            init();
            solve();
            in.close();
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() throws IOException{
        in = new Scanner(new File("gymnastics.in"));
        out = new PrintWriter(new File("gymnastics.out"));
        round = in.nextInt();
        cow = in.nextInt();
        count = 0;
        a = new int[round][cow];
        for(int i = 0; i < round; i++) {
            for(int j = 0; j < cow; j++) {
                a[i][j] = in.nextInt();
            }
        }
    }

    private static void solve() throws IOException{
        for(int i = 0; i < cow-1; i++) {
            for(int j = i+1; j < cow; j++) {
                score(i, j);
            }
        }
        out.println(count);
    }
    //brings the cows that will be compared
    public static void score(int b, int c) {
        b = b+1;
        c = c+1;
        int temp = 0;
        boolean check = false;
        for(int i = 0; i < round; i++) {
            for(int j = 0; j < cow; j++) {
                if(a[i][j] == b)
                    check = true;
                else if(a[i][j] == c && check == true)
                    temp++;
            }
            check = false;
        }
        if(temp == round || temp == 0)
            count++;
    }
}