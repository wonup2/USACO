import java.util.*;
import java.io.*;
public class JAN_BR_race {
	
	static int t, n, x, num, total, count;
	static boolean f;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("race.in"));
		PrintWriter out = new PrintWriter(new File("race.out"));
		
		t=in.nextInt(); 
		n=in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			x = in.nextInt();
			num=(int) Math.round(Math.sqrt(t*2));
			if(num <= x) { sb.append(num).append("\n");	continue; }

			total=0; 		
			count=0;			
			f=false;
			num=1;
			
			while(true) {
				total+=num;
				count++;
				if(total>=t) { sb.append(count).append("\n");	break;	}
				
				if(num<x) num++;
				else if(f) num++;
				
				f = !f;
			}
		}
		
		out.print(sb.toString());
		in.close();
		out.close();
	}
}
