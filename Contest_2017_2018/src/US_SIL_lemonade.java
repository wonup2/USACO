//US Open Contest, Silver
//lemonade
import java.util.*;
import java.io.*;

public class US_SIL_lemonade {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter out = new PrintWriter(new FileWriter("lemonade.out"));
		
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		
		int ans=0;
		for(int i=n-1; i>=0; i--){
			if(a[i]<ans) break;
			ans++;
			//System.out.print(ans+" ");
		}
		
		out.println(ans);
		in.close();
		out.close();
	}
}
