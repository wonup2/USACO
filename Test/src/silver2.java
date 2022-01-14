import java.util.*;
public class silver2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int[n+1];
		int[] b = new int[n+1];
		int[] c = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			int id = in.nextInt();
			a[i] = a[i-1];
			b[i] = b[i-1];
			c[i] = c[i-1];
			
			if(id==1) a[i]++;
			else if(id==2) b[i]++;
			else c[i]++;
		}
					
		for(int i=0; i<m; i++) {
			int s = in.nextInt()-1;
			int e = in.nextInt();
			int x = a[e]-a[s];
			int y = b[e]-b[s];
			int z = c[e]-c[s];
			System.out.println(x+" "+y+" "+z);
		}
	}

}
