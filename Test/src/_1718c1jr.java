import java.io.*;
	import java.util.*;
public class _1718c1jr {
	static class Result {
		public static String method1(String line) {
			line = line.replace(" ", "");
			int[] array = new int[line.length()-1];
			for(int i = 0; i < line.length(); i++) {
				if(i == 0) {
					array[i] = Character.getNumericValue(line.charAt(i))*10+Character.getNumericValue(line.charAt(i+1));
					i++;
				}
				else {
					array[i-1] = Character.getNumericValue(line.charAt(i));	
				}
			}
			String currentguy = "player";
			int currentpoints = array[0];
			String order = "1527394215";
			for(int f = 0; f < 10; f++) {
				int num = array[Character.getNumericValue(order.charAt(f))];
			    if(num == 4) {
			    	currentpoints -= 10;	
			    }
			    else if(num == 0) {
			    	currentpoints += 1;
			    	if(currentpoints + 10 < 100) {
				    	currentpoints += 10;
				    }
			    }
			    else if (num != 9 && num != 4 && num != 0) {
			            currentpoints += num;
			    }
			    if(currentguy.equals("player")){
			            currentguy = "dealer";
			    }
			    else if(currentguy.equals("dealer")){
			            currentguy = "player";
			    }
			    if(currentpoints > 99) {
			            break;
			    }
			}
			String res = currentpoints + currentguy;
			return res;
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