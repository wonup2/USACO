import java.io.*;
import java.util.*;

public class DistinctNumber {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
						
		StringTokenizer st = new StringTokenizer(in.readLine());

		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<n; i++) 
			set.add(Integer.parseInt(st.nextToken()));
		
		System.out.println(set.size());
	}

}
