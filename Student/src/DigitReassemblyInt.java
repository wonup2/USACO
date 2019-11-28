import java.util.*;
import java.io.*;
public class DigitReassemblyInt {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("DigitReassemblyInt.in"));
		for(int x = 0; x < 5; x++) {
			String input = in.next();
			int set = in.nextInt();
			Long res = 0l;
			
			for(int i = 0; i <= input.length()-set; i++) {
				res += Long.parseLong(input.substring(i, i+set));
			}
			
			System.out.println(res);
		}
	}
}