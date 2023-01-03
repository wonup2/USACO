import java.util.*;
public class ReverseEngineering1 {
	static Scanner in;
	static boolean ok;
	static int n, m;
	static char a[][], b[];
	static boolean c[][];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-->0) {
			solve();
		}
	}

	static void solve() {
		n = in.nextInt();
		m = in.nextInt();

		a = new char[m][];
		b = new char[m];
		c = new boolean[m][n];
		for(int i = 0; i<m; i++) {
			a[i] = in.next().toCharArray();
			b[i] = in.next().charAt(0);
		}



		//00, 11
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(a[j][i]== b[j]) c[j][i] = true;
				else c[j][i] = false;
			}
		}		
		boolean ok1 = true;

		
		boolean d[] = new boolean[m];
		for(int i=0; i<n; i++) {			
			for(int j=i+1; j<n; j++) {
				
					boolean ok = true;
					d = new boolean[j-i];
					
					for(int l=0; l<m; l++) {
						
						for(int k = i; k<j; k++) {
							if(c[l][k]) {d[i]=true;break;}
						}
					}
				
					for(int o=0; o<m; o++) {
						
						if(!d[o]) ok1 = false;
					}
				
			}
			
		}
				


		
		
		
		
		//01, 10
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(a[j][i]== b[j]) c[j][i] = false;
				else c[j][i] = true;
			}
		}
		
		d = new boolean[m];
		for(int i=0; i<m; i++) {			
			for(int j=0; j<n; j++) {
				
				if(c[i][j]) {d[i]=true;break;}
				
			}
		}		


		boolean ok2 = true;
		for(int i=0; i<m; i++) {
			
			if(!d[i]) ok2 = false;
		}
		
		
		if(ok1 || ok2) System.out.println("OK");
		else System.out.println("LIE");
	}		
}

/*
4

1 3
0 0
0 0
1 1

2 4
00 0
01 1
10 1
11 1

1 2
0 1
0 0

2 4
00 0
01 1
10 1
11 0

*/
