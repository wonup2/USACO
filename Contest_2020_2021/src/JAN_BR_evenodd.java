import java.util.*;
import java.io.*;

public class JAN_BR_evenodd {

	static Scanner in;
	static int n, e, o, ans;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();
		e = 0;
		o = 0;
		
		for(int i=0; i<n; i++) {
			if(in.nextInt()%2==0) e++;
			else o++;
		}		
	}
	
	static void solve() {
		ans = 0;
		while(o>e) {
			o-=2;
			e++;
		}

		if(e == o) ans = o + e;  
		else ans = o * 2 + 1;
		
		System.out.println(ans);
	}	
}


/*
1. e > o ---> o*2 + 1
2. e < o ---> problems.... 왜냐하면 이건 꼭 e 로 끝나야 돼.
   make e >= o 만들자 --> while
*/