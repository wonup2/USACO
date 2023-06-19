import java.util.*;


public class US20_FEB_BR_Triangle {

	static Scanner in;
	static int n, x[], y[], ans;
	static TreeSet<Integer> setx, sety;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		
		x = new int[n];
		y = new int[n];
		
		for(int i=0; i<n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		setx = new TreeSet<Integer>();
		sety = new TreeSet<Integer>();
		
	}

	static void solve() {
		
		ans = 0;

		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				for(int k =j+1; k<n; k++) {
					
					if(check(i, j, k)) 
						ans =Math.max(ans, setx.last()-setx.first()) * (sety.last()-sety.first());			
					
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean check(int a, int b, int c) {
		
		setx.clear();
		sety.clear();
		
		setx.add(x[a]);setx.add(x[b]);setx.add(x[c]);
		sety.add(y[a]);sety.add(y[b]);sety.add(y[c]);
		
		return setx.size()==2 && sety.size()==2;
	}
}
