import java.io.*;
import java.util.*;

public class bucketlist {
//    static Scanner in;
    static BufferedReader in;
    static PrintWriter out;
    static int n, nums[];
    
    
    public static void main(String[]args) throws IOException {
//        in = new Scanner(System.in);
        in = new BufferedReader(new FileReader("blist.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        
        
        init();
        solve();
        in.close();
        out.close();
    }
    
    static void init() throws IOException {
        n = Integer.valueOf(in.readLine());
        nums = new int[1001];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int s = Integer.valueOf(st.nextToken());
            int e = Integer.valueOf(st.nextToken());
            int add = Integer.valueOf(st.nextToken());
            
            for (int a = s; a <= e; a++) {
                nums[a] += add;
            }
        }

    }
    
    static void solve() {
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > ans) {
                ans = nums[i];
            }
        }
        
        out.println(ans);
        
    }
}