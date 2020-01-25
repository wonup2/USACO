//2017 Feb. Bronze

import java.io.*;
import java.util.*;
public class FEB_BR_crossroad {

	public static void main(String[] args) throws IOException  {
		Scanner in = new Scanner(new FileReader("crossroad.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")),true);
		
		int n = in.nextInt();
		int[] cow = new int[11];
		Arrays.fill(cow, -1);
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			int index = in.nextInt();
			int val = in.nextInt();			
			if(cow[index]!=-1 && cow[index]!=val) cnt++;			
			cow[index] = val;			
		}
		
		out.println(cnt);
		out.close();
		in.close();
	}
}
