import java.util.*;

public class FEB_BR_photo2 {
	static int n, a[], b[];
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
		solve();
		in.close();
	}
	
	static void init(){
		n= in.nextInt();
		a = new int[n+1];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		b = new int[n+1];
		for(int i=0; i<n; i++) b[i] = in.nextInt();
	}
	
	static void solve() {
		int cnt = 0;
		boolean move[] = new boolean[n+1];
		
		int i=0;
		for(int j=0; j<n; j++) {
			
			while(move[a[i]]) i++;
			
			if(a[i]!=b[j]) {
				cnt++;
				move[b[j]]=true;
			}
			else i++;
		}
		
		System.out.println(cnt);
	}
}
