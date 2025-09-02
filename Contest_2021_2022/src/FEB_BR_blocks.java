import java.util.*;

public class FEB_BR_blocks {

	static Scanner in;
	static HashSet<Integer>[] a;
	static int n;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
	}
	
	static void init() {
		
		n= in.nextInt();
		a = new HashSet [26];		
		for(int i=0; i<26; i++) a[i] = new HashSet<Integer>();
		
		for(int i=0; i<4; i++) {
			char s[] = in.next().toCharArray();
			for(int c: s) {
				c-='A';
				a[c].add(i);
			}
		}
		
		while(n-->0) {
			solve();
		}
	}
	
	static void solve() {
		
		char s[] = in.next().toCharArray();
		boolean ok = true;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<s.length; i++) {
			int c = s[i]-'A';
			if(a[c].size()==0) ok=false;
			set.addAll(a[c]);
		}

		if(s.length<=set.size() && ok)System.out.println("YES");
		else System.out.println("NO");
	}
}


/*
6
MOOOOO
OOOOOO
ABCDEF
UVWXYZ
COW
MOO
ZOO
MOVE
CODE
FARM

*/