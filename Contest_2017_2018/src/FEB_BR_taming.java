import java.util.*;
import java.io.*;

public class FEB_BR_taming {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("taming.in"));
		PrintWriter out = new PrintWriter(new File("taming.out"));
		
		int n = in.nextInt();
		int[] log = new int[n];
		log[0]=0; in.nextInt();
		for(int i=1; i<n; i++)
			log[i] = in.nextInt();
		
		System.out.println(Arrays.toString(log));
		int m=0;
		int M=0;
		
		for(int i=n-1; i>0; i--){
			int day = log[i];
			if(day<1) continue;
			while(day>0){
				if(log[i-1]==-1 || log[i-1]==day-1)
					log[--i] = --day;
				else {					
					out.println(-1);
					in.close(); out.close(); 				
					System.exit(0);
				}
			}			
		}
	
		for(int i=0; i<n; i++){
			if(log[i]==0) m++;
			else if(log[i]==-1) M++;
		}
		out.println(m+ " " + (M+m));
		out.close();
		in.close();
	}	
}
