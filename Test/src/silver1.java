import java.util.*;

public class silver1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int ans = 0;
		int n2 = n*2;
		int[] a = new int[n];
		
		TreeSet<Integer> s = new TreeSet<Integer>();
		for(int i=1; i<=n2; i++) s.add(i);
		
		for(int i=0; i<n; i++) {
			a[i]=in.nextInt();
			s.remove(a[i]);
		}

		Arrays.sort(a);
		
		for(int i=n-1; i>=0; i--) {
			int find = a[i];
			if(s.higher(find)!=null) {
				int h = s.higher(find);
				s.remove(h);
			}
		}
		
		
		System.out.println(n-s.size());
	
				
	}

}
