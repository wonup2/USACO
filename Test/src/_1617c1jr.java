import java.io.*;
import java.util.*;
public class _1617c1jr{
    static class Result {
        public static String method1(String line) {   
        	line = line.replace(", ", "");
        	String cardtype = Character.toString(line.charAt(1));
        	int minimum = Character.getNumericValue(line.charAt(0));
        	String substring = line.substring(2);
        	while(substring.indexOf(cardtype) != -1) {
        		if(Character.toString(substring.charAt(1)).equals(cardtype)) { //check if suite is same
        			int cardnum = Character.getNumericValue(substring.charAt(0));
        			if(cardnum > Character.getNumericValue(line.charAt(0))) {
        				if(cardnum < minimum || minimum == Character.getNumericValue(line.charAt(0))) {
        					minimum = cardnum;
        				}
        			}
        		}
        		substring = substring.substring(2);
        	}
        	if(minimum == Character.getNumericValue(line.charAt(0))) {
        		if(line.substring(2).indexOf(cardtype) != -1) {
        			for(int i = 1; i <= 5; i ++) {
        				if(Character.toString(line.charAt(i*2+1)).equals(cardtype)){
        					int cardnum1 = Character.getNumericValue(line.charAt(i*2));
                			if(cardnum1 < minimum) {
                				minimum = cardnum1;
                			}
        				}
            		}
        		}
        	}
        	if(minimum == Character.getNumericValue(line.charAt(0))) {
        		return "None";
        	}
        	else {
        		return minimum + ", "+cardtype;
        	}
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String result = Result.method1(in.nextLine().trim());
            System.out.println(result);
        }
        in.close();
    }
}