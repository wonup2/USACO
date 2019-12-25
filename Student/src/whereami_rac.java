import java.util.*;
import java.io.*;
public class whereami_rac {
    static Scanner in;
    static PrintWriter out;
    static int size;
    static String[] letters;
    static int count;
    static String temp;
    static int j;
    public static void main(String [] args) {
        try {
            init();
            solve();
            in.close();
            out.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    static public void init() throws IOException{
        in = new Scanner(new File("whereami.in"));
        out = new PrintWriter(new File("whereami.out"));
        size = in.nextInt();
        letters = in.nextLine().split("");

    }
    static public void solve() throws IOException{
        j = 0;
        temp = letters[j];
        for(int i = j+1; i < letters.length; i++) {
            if(letters[j].equals(letters[i])) {
                j++;
                count++;
            }
        }
        out.println(size-count);


    }
}
