import java.io.*;
import java.util.*;
public class _2021c1jr {
    static Scanner in;
    static int start;
    static int delta;
    static int rows;
    static int answer;
    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            try {
                init();
                solve();
            }
            catch(Exception e) {
                System.out.println("Error");
                          e.printStackTrace();
            }
        }
        in.close();
    }
    public static void init() {
        start = in.nextInt();
        delta = in.nextInt();
        rows = in.nextInt();
    }
    public static int getSum(int n)
    {   
        int sum = 0;
         
        while (n != 0)
        {
            sum = sum + n % 10;
            n = n/10;
        }
     
    return sum;
    }
    public static void solve() {
    	int num = start-delta;
    	int ans = 0;
    	for(int i = 0; i < rows; i++) {
    		for(int u = 0; u < i+1; u++) {
    			num += delta;
    			while(num>=10) {
    				num = getSum(num);
    			}
    			if(i==rows-1) {
    				ans += num;
    			}
    		}
    	}System.out.println(ans);
    	
    }
}