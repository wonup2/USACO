import java.io.*;
import java.util.*;


public class DEC_SIL_shuffle1  {
	
	static Scanner in; 
	static PrintWriter out;
	
	static boolean[] isCheck=new boolean[100001],partLoop=new boolean[100001],isLoop=new boolean[100001];
	static int[] read=new int[100001];
	static int ans=0,firstNode=0, n=0;	
	
	public static void main(String[] args) throws IOException{
		in =new Scanner(new File("shuffle.in"));
		out =new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
				
		n=in.nextInt();		
		isCheck=new boolean[n];
		partLoop=new boolean[n];
		isLoop=new boolean[n];
		read=new int[n];
		
		for(int i=0;i<n;i++)read[i]=in.nextInt()-1;	
		
		System.out.println(Arrays.toString(read));
	}
	
	static void solve() {
		
		for(int i=0;i<n;i++) {
			if(!isCheck[read[i]]) loop(i);
			System.out.println(i);
			System.out.println(Arrays.toString(isCheck));
			System.out.println(Arrays.toString(partLoop));
			System.out.println(Arrays.toString(isLoop));
		}


		out.println(ans);
	}
	
	public static boolean loop(int i) {//check for end

		if(isCheck[i]) {

			firstNode=i;
			return partLoop[i]&&!isLoop[i];

		}
		isCheck[i]=true;
		partLoop[i]=true;
		if(loop(read[i])) {
			ans++;
			isLoop[i]=true;
			partLoop[i]=false;
			return firstNode!=i;
		}
		partLoop[i]=false;
		return false;
	}

}