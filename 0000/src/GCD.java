
public class GCD {

	public static void main(String[] args) {
		
		int a = 15;
		int b = 9;
		
		System.out.println(gcd(a, b));
	
	}
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}

}
