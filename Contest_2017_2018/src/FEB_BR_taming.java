import java.util.*;
import java.io.*;

public class FEB_BR_taming {
	static Scanner in;
	static PrintWriter out;
	static int n, log[], m, M;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("taming.in"));
		out = new PrintWriter(new File("taming.out"));
		
		init();
		out.println(solve());
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		log = new int[n];
		log[0]=0; in.nextInt();
		for(int i=1; i<n; i++)log[i] = in.nextInt();		
	}
	
	static String solve() {
		
		for(int i=n-1; i>0; i--){
			int day = log[i];
			if(day<1) continue;
			
			while(day>0){
				
				if(log[i-1]==-1 || log[i-1]==day-1)
					log[--i] = --day;
				
				else return -1+"";				
			}			
		}
	
		for(int i=0; i<n; i++){
			if(log[i]==0) m++;
			else if(log[i]==-1) M++;
		}
		
		return m + " " + (M+m);
	}	
}
