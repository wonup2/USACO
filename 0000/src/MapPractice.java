import java.util.*;
public class MapPractice {

	static double t1[], t2[];
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			try {
				init();
				solve();
				
			}
			catch(Exception e) {
				
			}
		}
		
	}
	
	static void init(){
		for(int i=0; i<3; i++)
			t1[i] = in.nextDouble();
		
		for(int i=0; i<3; i++)
			t2[i] = in.nextDouble();	
		
		System.out.println(Arrays.toString(t1));
		System.out.println(Arrays.toString(t2));
	}

	static void solve() {
		
	}
}
