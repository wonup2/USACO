import java.util.*;
import java.io.*;
public class JAN_BR_race {
	
	static int k, n, x, num, total, count, speedSet;
	static boolean f;
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("race.in"));
		PrintWriter out = new PrintWriter(new File("race.out"));
		
		k=in.nextInt(); 
		n=in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			x = in.nextInt();
			total=0; 		
			count=0;			
			speedSet=0;
			num=1;
			
			// if x is 3 and k is 20 make speed lists such as 1, 2, 3, 3, 4, 4, 5 .....	
			// Bessie can replace the speed numbers such as 1, 2, 3, 4, 5, 4, 3
			
			while(true) {
				total+=num;
				count++;
				if(total>=k) { 
					sb.append(count).append("\n");	
					break;	
				}
				
				if(num<x) num++;    
				else speedSet++;
				
				if(speedSet==2) { 	 
					num++; 
					speedSet=0;
				}
			}
		}
		
		out.print(sb.toString());
		in.close();
		out.close();
	}
}
