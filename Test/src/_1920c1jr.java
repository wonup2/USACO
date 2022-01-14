import java.util.*;
import java.io.*;
public class _1920c1jr {
	static String num;
	static int position;
	static int transition;
    static Scanner in;
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
    	num = in.next();
        position = in.nextInt();
        transition = in.nextInt();
    }
    public static void solve() {
    	String newnum = "";
    	int digits = num.length();
        for(int i = 0; i < digits; i++ ) {
        	if(digits-i>position)
        		newnum += num.charAt(i);
        	else if(digits-i==position) {
        		int intdigit = Character.getNumericValue(num.charAt(i));
        		if(intdigit <= 4) {
        			char b = (char)((intdigit+transition)%10+'0');
        			newnum += b;
        		}else {
        			int x = Math.abs(intdigit-transition);
        			while(x>=10)
          			  x/=10;
        			char b = (char)(x + '0');
        			newnum += b;
        		}
        	}else {
        		newnum += "0";
        	}
        }System.out.println(newnum);
    }
}