/*
ID: josephj5
LANG: JAVA
PROG: ride
*/
import java.util.*;
import java.io.*;

class ride {
    static BufferedReader in;
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new FileReader("ride.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        try {
            solve();
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void solve() throws IOException {
        
        String a = in.readLine();
        String b = in.readLine();
        
        int at = 1;
        int bt = 1;
        for(int i = 0; i < a.length(); i ++)
            at *= a.charAt(i) - 'A' + 1;
        for(int i = 0; i < b.length(); i ++)
            bt *= b.charAt(i) - 'A' + 1;

        at %= 47;
        bt %= 47;
        if(at == bt)
            out.println("GO");
        else
            out.println("STAY");
        
    }

}