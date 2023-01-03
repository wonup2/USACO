import java.io.*;
import java.util.*;
public class JAN_BR_promotion {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("promote.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		
		int bronzeBefore = in.nextInt();
		int bronzeAfter = in.nextInt();
		
		int silverBefore = in.nextInt();
		int silverAfter = in.nextInt();
		
		int goldBefore = in.nextInt();
		int goldAfter = in.nextInt();
		
		int platinumBefore = in.nextInt();
		int platinumAfter = in.nextInt();
		
		// do the computations
		int goldToPlatinum = platinumAfter - platinumBefore;
		int silverToGold = goldAfter - goldBefore +  goldToPlatinum;
		int bronzeToSilver = silverAfter - silverBefore + silverToGold;
		
		// print the answers
		out.println(bronzeToSilver);
		out.println(silverToGold);
		out.println(goldToPlatinum);
		
		// close output stream
		out.close();
	}
}