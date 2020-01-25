import java.util.*;
import java.io.*;
public class USACO2 {
	static Scanner in;
	static PrintWriter out;
	static int n, a[], b[][], c[], hold;
	static String s;
	static ArrayList<Integer> res;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("photo.in"));
		out = new PrintWriter(new File("photo.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	public static void init() {
		s = "";
		n = in.nextInt();
		a = new int[4];
		b = new int[2][n-1];
		c = new int[n+1];
		res = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++) {
			a[i] = in.nextInt();
		}
		for(int i = 1; i < 5; i++) {
			b[0][i-1] = i;
			b[1][i-1] = a[0]-i;
		}
	}
	public static void solve() {
		for(int i = 0; i < n-1; i++) {
			res.add(b[0][i]);
			hold = b[1][i];
			res.add(hold);
				for(int k = 1; k < a.length; k++) {
					hold = a[k]-hold;
					if(hold < 1) {
						res = new ArrayList<Integer>();
						break;
					}
					else {
						res.add(hold);
					}
				}
        
				if(res.size() == n) {
					HashSet<Integer> set = new HashSet<Integer>();
                  	set.addAll(res);
                  if(n==set.size()){
                    s+=res.get(0);
                    for(int j=1; j<res.size(); j++){
                      s+=" "+res.get(j);
	                }
                    break;
                  }
				}
		}
		out.println(s);
	}
}
