import java.util.Scanner;

public class AsciiCode {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.next().charAt(0)-'A' + 1 ;
		System.out.println(n);
		
		//12345
		
		String input = in.next();
		int sum = 0;
		
		for(int i=0; i<input.length(); i++) {
			
			int d = input.charAt(i) - '0';
			sum += d;
		}
		
		System.out.println(sum);
	}

}
