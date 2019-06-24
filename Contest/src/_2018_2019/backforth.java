package _2018_2019;
import java.io.*;
import java.util.*;
public class backforth {
	static int[] a;
	static int[] b;
	static Scanner in;
	static PrintWriter out;
	static int n=10;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new FileReader("backforth.in"));
			out = new PrintWriter(new FileWriter("backforth.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void init() {
		a = new int[n];
		b = new int[n];
		
		for(int i=0; i<n; i++)	a[i] = in.nextInt();
		for(int i=0; i<n; i++)	b[i] = in.nextInt();			
	}
	static int solve() {
		int[] ka = a.clone();
		int[] kb = b.clone();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int first = 0-a[i]+b[j];
				swap(i, j, a[i], b[j]);				

				for(int k=0; k<n; k++){
					for(int m=0; m<n; m++){
						int second = first + b[m] - a[k];			
						set.add(second);  System.out.println(set);
					}
				}
				a = ka.clone();
				b = kb.clone();
			}
		}	
		return set.size();
	}
	static void swap(int i, int j, int a1, int b1){
		a[i]=b1;
		b[j]=a1;
	}
}
