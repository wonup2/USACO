<<<<<<< HEAD
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
		
		long e=1;
		long o=100000000000l;
		ans = 0;
        
		long startTime = System.nanoTime();
		
		while(o>e) {
			o-=2;
			e++;
		}
		
		long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

		System.out.println(timeElapsed);
		
		
		startTime = System.nanoTime();
		if(o>e) {
			int t = (int)(Math.ceil((o-e)/3.0));
			o-=t*2;
			e+=t;
		}
		
		endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

		System.out.println(timeElapsed);
//		
//		if(e == o) ans = o + e;  
//		else ans = o * 2 + 1;
//		
//		System.out.println(ans);
		
	}	
}


/*
1. e > o ---> o*2 + 1
2. e < o ---> problems.... 왜냐하면 이건 꼭 e 로 끝나야 돼.
   make e >= o 만들자 --> while
=======
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
		//e = 1
		//o = 6
		
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
2. e < o ---> problems.... ì™œëƒ�í•˜ë©´ ì�´ê±´ ê¼­ e ë¡œ ë��ë‚˜ì•¼ ë�¼.
   make e >= o ë§Œë“¤ìž� --> while
>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
*/