import java.io.*;
import java.util.*;


public class DEC_BR_cowsignal {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<m; i++)
		{
			String result = "";
			String s = br.readLine();
			for(int j=0; j<n; j++)
				for(int a=0; a<k; a++)
					result += s.charAt(j)+"";
			
			for(int a=0; a<k; a++)
				pw.println(result);
		}
					
		pw.close();
	}
}
