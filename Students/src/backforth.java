import java.io.*;
import java.util.*;
public class backforth {
	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;
	static Set<Integer> set;
	static int[] f1;
	static int[] f2;
	static int n=10;
	public static void main(String[] args) {
		try{
			f = new BufferedReader(new FileReader("backforth.in"));
			out = new PrintWriter(new FileWriter("backforth.out"));
			init();
			out.println(solve());
			out.close();
			f.close();
			
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}

	}

	private static void init()throws IOException{
		set = new HashSet<>();
		f1 = new int[n];
		f2 = new int[n];
		st = new StringTokenizer(f.readLine());
		for(int i=0; i<n; i++){
			f1[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(f.readLine());
		for(int i=0; i<n; i++){
			f2[i]=Integer.parseInt(st.nextToken());
		}
	}
	
	private static int solve(){
		int[] a = f1.clone();
		int[] b = f2.clone();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int first = 0-a[i]+b[j];
				
				int temp = a[i];
				a[i]=b[j];
				b[j]=temp;

				for(int k=0; k<n; k++){
					for(int l=0; l<n; l++){
						int second = first-a[k]+b[l];						
						set.add(second);
						//System.out.println(set);
					}
				}
				a=f1.clone();
				b=f2.clone();
			}
		}
		return set.size();
	}
}
