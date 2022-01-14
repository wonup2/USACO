import java.util.*;

public class C1_JR_wraparround {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		//---get data
		char c = in.next().charAt(0);
		//System.out.println(c);
		
		//---process
		//1. convert A-1, B-2 ... Z-26
		int num = c - 'A' + 1;
		
		//2. encoding
		if(1<=num && num<=5) {
			num = num * 2;
		}
		else if(6<=num && num<=10) {
			num = num % 3 * 5;
		}
		else if(11<=num && num<=15) {
			num = num / 4 * 8;
		}
		else if(16<=num && num<=20) {
			num = ((num/10) + (num%10)) *10;
		}
		else {
			num = factor(num) *12;
		}
		
		//3. num > 26
		
		//----------------------make program here
		
		//4. convert 1-A, 2-B...26-Z
		num = num + 'A' - 1;
		
		
		//...result
		c = (char)num;
		
		System.out.println(c);	
		
	}

	
	static int factor(int n) {
	
		//----------------------make program here
		
		return n;
	}
}
