import java.util.*;
import java.io.*;
public class guess {
	static Scanner in;
	static PrintWriter out;
	static ArrayList<String> [] a ;
	static ArrayList<Integer> last ;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("guess.in"));
		out = new PrintWriter(new File("guess.out"));
		init();
		solve();
	}
	
	static void init() {
		int n = in.nextInt();
		a = new ArrayList[n];
		last = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			a[i] = new ArrayList<String>();
			in.next();
			int k = in.nextInt();
			for(int j = 0; j < k; j++) {
				a[i].add(in.next());
			}
		}
		
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int count = 1;
		for(int x = 1; x < a.length; x++) {
			for(int k = x; k < a.length; k++) {
				for(int i = 0; i < a[x - 1].size(); i++) {
					for(int j = 0; j < a[k].size(); j++) {
						if(a[x - 1].get(i).equals(a[k].get(j)))
							count+=1;
					}
				}
				last.add(count);
				count = 1;
			}
		}
		Collections.sort(last);
		out.println(last.get(last.size() - 1));
		out.close();
	}
}
