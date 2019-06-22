//package Section_1_3;
/*
ID: samueln1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;
public class milk2 {	
	static BufferedReader f;
	static PrintWriter out;
	static Set<Integer> m;
	public static void main(String[] args) {
		try{
			f = new BufferedReader(new FileReader("milk2.in"));
			out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
			init();
			out.println(solve());
			f.close();
			out.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private static void init() throws IOException{
		m = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n=Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++){
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j=a; j<b; j++){
				m.add(j);
			}
		}
	}
	
	private static String solve(){
		int maxl=0;
		int maxi=0;
		int countl=0;
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(m);
		Collections.sort(a);
		int previous = a.get(0);
		for(int num:a){
			if(num-previous<=1){
				countl++;
			}
			else{
				countl=0;
			}
			maxi=Math.max(maxi, num-previous-1);
			maxl=Math.max(maxl, countl);
			previous=num;
		}
		return maxl+" "+(maxi);
	}

}
