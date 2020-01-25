import java.io.*;
import java.util.*;
public class FEB_BR_hoofball {
	static Scanner in;
	static PrintWriter out;
	static int a[], p[], t[], n, ans;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new FileReader("hoofball.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        init();
        solve();        
        out.close();
        in.close();       
	}
	static void init() throws NumberFormatException, IOException {
		n = in.nextInt();
		a = new int[n];
		p = new int[n];
		t = new int[n];
		
		for(int i=0; i<n; i++)
			a[i] = in.nextInt();
		
		Arrays.sort(a);
		
	}
	
	static void solve() {
		
		t[0]=1;
		t[n-1] = n-2;
		p[1]=1;
		p[n-2]=1;
		
		for(int i=1; i<n-1; i++) {
			int l = a[i]-a[i-1];
			int r = a[i+1] - a[i];
			if(l<=r) {
				p[i-1]++;
				t[i]=i-1;
			}
			else {
				p[i+1]++;
				t[i]=i+1;
			}
		}
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(p));
//		System.out.println(Arrays.toString(t));

		for(int i=0; i<n-1; i++) {
			if(p[i]==0) ans++;
			else if(p[i]==1 && p[i+1]==1) {
				if(t[i]==i+1 && t[i+1]==i){
					ans++;
					i++;
				}
			}
		}
		if(p[n-1]==0) ans++;
		out.println(ans);
	}
	
}