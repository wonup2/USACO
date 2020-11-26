
public class ConvertBase {

	public static void main(String[] args) {
		
		//convert base
		
		int n = 20;
		for(int i=2; i<=20; i++) {
			String s = Integer.toString(n, i);
			System.out.println("Base "+i+": " + s);
		}


		
		//check palindrome
		String s = "Hello";
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.reverse().toString());
		
	
		String rev = new StringBuilder(s).reverse().toString(); //<-------		
		System.out.println(rev.equals(s));		
	}
}
