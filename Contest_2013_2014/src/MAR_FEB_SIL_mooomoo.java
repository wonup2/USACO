
import java.util.*;
import java.io.*;

public class MAR_FEB_SIL_mooomoo {

	public static void main(String[] args) throws Exception {
		
		// Read in the input.
		Scanner stdin = new Scanner(new File("mooomoo.in"));
		int n = stdin.nextInt();
		int numTypes = stdin.nextInt();
		int[] vals = new int[numTypes];
		
		for (int i=0; i<numTypes; i++)
			vals[i] = stdin.nextInt();
		
		int[] totalSound = new int[n];
		for (int i=0; i<n; i++)
			totalSound[i] = stdin.nextInt();
			
		// Adjust sound, to subtract out extra effects.
		int cur = 0, max = 0;
		
		for (int i=0; i<n; i++) {
			int newcur = totalSound[i];
			totalSound[i] -= cur;
			cur = newcur;
			if (cur > 0) cur--;
			max = Math.max(max, totalSound[i]);
		}
		
		System.out.println(Arrays.toString(totalSound)+" "+max + " "+numTypes);
		
		// Run an adjusted knapsack here. dp[i] = min # of cows to get to sound i, or -1 if impossible.
		int[] dp = new int[max+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		// Go through the cows.
		for (int i=0; i<numTypes; i++)
			
			// We go forward through the DP array since duplicates are allowed.
			for (int j=vals[i]; j<dp.length; j++)
				
				// We have a valid solution to build off of.
				if (dp[j-vals[i]] != -1)
					
					// And the new solution we build is better!
					if (dp[j] == -1 || dp[j-vals[i]] + 1 < dp[j])
						dp[j] = dp[j-vals[i]] + 1;
		
		System.out.println(Arrays.toString(dp));
		// Just put the fewest number of cows necessary to make each new sum of sounds.
		int res = 0;
		for (int i=0; i<n; i++) {
			if (dp[totalSound[i]] == -1) {
				res = -1;
				break;
			}
			res += dp[totalSound[i]];
		}
		
		// Output to file.
		PrintWriter out = new PrintWriter(new FileWriter("mooomoo.out"));
		out.println(res);
		out.close();		
		stdin.close();
	}
}