
import java.util.*;


public class ArrayArrayList {
	static ArrayList<String> [] a;
	static ArrayList<String> p;
	static int n;
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		p = new ArrayList<String>();
		
		n = in.nextInt();
		a = new ArrayList[n];
		for(int i=0; i<n; i++)
			a[i] = new ArrayList<String>();
	

		for(int i=0; i<n; i++) {
			int m = in.nextInt();
			for(int j = 0; j<m; j++) {
				String t = in.next();
				a[i].add(t);
				if(!p.contains(t))p.add(t);
			}
		}
				
		System.out.println(Arrays.toString(a));
		System.out.println(p);
		
		boolean ok = true;
		for(int i=0; i<p.size()-1; i++) {
			for(int j=i+1; j<p.size(); j++) {
				if(check(i,j)) { ok = false; }
			}
		}
		if(ok) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static boolean check(int i, int j) {
		
		String b = p.get(i);
		String c = p.get(j);
		
		int _bc=0;
		int _b = 0;
		int _c = 0;
		
		for(int x = 0; x<n; x++) {
			if(a[x].contains(b) && a[x].contains(c)) _bc++;
			else if(a[x].contains(b)) _b++;
			else if(a[x].contains(c)) _c++;
		}
		
		return _bc>0 && _b>0 && _c>0;
	}
	
	
	//[[spots, firebreathing], [], [spots, flying], [firebreathing, telepathic, flying]]
}
/*
4
2 spots firebreathing
0
1 flying
2 telepathic flying
*/