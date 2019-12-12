import java.util.*;
import java.io.*;
public class Digit_Reassembly {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("sendr"));
		for(int j = 0; j < 5; j++) {
			String[] temp = in.nextLine().split(" ");
			String numbers = temp[0];
			int take = Integer.parseInt(temp[1]);
			int sum = 0;
			for(int i = 0; i < numbers.length()-take; i+=take) {
				//System.out.println(i);
				sum += Integer.parseInt(numbers.substring(i, i+take));
			}
			int mod = numbers.length()%take;
			if(mod != 0) {
				String remainder = numbers.substring(numbers.length()-mod);
				for(int i = 0; i < remainder.length(); i++) {
					if(remainder.charAt(0) == '0') {
						remainder.substring(1);
					}
				}
				if(remainder.length() != take) {
					while(remainder.length() != take ) {
						remainder+= "0";
					}
				}
				sum += Integer.parseInt(remainder);
			}else {
				sum += Integer.parseInt(numbers.substring(numbers.length()-take));
			}
			System.out.println(sum);
		}
		
	}
}
