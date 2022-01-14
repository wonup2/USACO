import java.util.*;
import java.io.*;
public class _1819c1jr {
    static Scanner in;
    static String num;
    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);
        try {
            init();
            solve1();
            init();
            solve2();
            init();
            solve3();
            init();
            solve4();
            init();
            solve5();
        }
        catch(Exception e) {
           System.out.println("Error");
           e.printStackTrace();
        }
        in.close();
    }

    public static void init() {
    	num = in.next();
    }

    public static void solve1() {
    	System.out.println(num.length());
    }
    public static void solve2() {
    	int ans = 0;
    	for(int i = 0;i < num.length(); i++) {
    		int intdigit = Character.getNumericValue(num.charAt(i));
    		ans += intdigit;
    	}System.out.println(ans);
    }
    public static void solve3() {
    	int ans = 0;
    	boolean flag = true;
    	for(int i = 0;i < num.length(); i++) {
    		if(flag) {
    			int intdigit = Character.getNumericValue(num.charAt(i));
    			ans += intdigit;
    			flag = false;
    		}
    		else { flag = true; }
    	}System.out.println(ans);
    }
    public static void solve4() {
    	int ans = 0;
    	for(int i = 0;i < num.length(); i++) {
    		int intdigit = Character.getNumericValue(num.charAt(i));
    		if(intdigit == 4) {
    			ans ++;
    		}
    	}System.out.println(ans);
    }
    public static void solve5() {
    	char character = num.charAt(((int)num.length()-1)/2);
    	System.out.println(Character.getNumericValue(character));
    }
}