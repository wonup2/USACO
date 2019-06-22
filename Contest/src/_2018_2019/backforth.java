package _2018_2019;
import java.io.*;
import java.util.*;
public class backforth {
	static int[] a;
	static int[] b;
	static Scanner in;
	static PrintWriter out;
	
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
		a = new int[10];
		b = new int[10];
		
		for(int i=0; i<10; i++)	a[i] = in.nextInt();
		for(int i=0; i<10; i++)	b[i] = in.nextInt();			
	}
	static int solve() {
		int[] ka = a.clone();
		int[] kb = b.clone();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				int first = 0-a[i]+b[j];
				swap(i, j, a[i], b[j]);				

				for(int k=0; k<10; k++){
					for(int m=0; m<10; m++){
						int milk = first + b[m] - a[k];						
						set.add(milk);
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
