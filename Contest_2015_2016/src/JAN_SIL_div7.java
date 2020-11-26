import java.io.*;
import java.util.*;
public class JAN_SIL_div7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		
		int n = Integer.parseInt(br.readLine());
		int[] first = new int[7];
		int[] last = new int[7];
		Arrays.fill(first, Integer.MAX_VALUE);
		first[0] = 0;
		int currPref = 0;
		for(int i = 1; i <= n; i++) {
			currPref += Integer.parseInt(br.readLine());
			System.out.print(currPref + " ");
			currPref %= 7;
			System.out.println(currPref + " ");

			first[currPref] = Math.min(first[currPref], i);
			last[currPref] = i;
			
			System.out.println(Arrays.toString(first));
			System.out.println(Arrays.toString(last));
		}
		
		System.out.println(Arrays.toString(first));
		System.out.println(Arrays.toString(last));

		int ret = 0;
		for(int i = 0; i < 7; i++) {
			if(first[i] <= n) {
				ret = Math.max(ret, last[i] - first[i]);
			}
		}
		pw.println(ret);
		pw.close();
	}
}