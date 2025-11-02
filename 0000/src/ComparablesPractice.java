import java.util.*;

public class ComparablesPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		
		report a[] = new report[n];
		
		for(int i=0; i<n; i++) {
			a[i] = new report(in.next(), in.nextInt(), in.nextInt(), in.nextInt());
		}
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		for(report o:a)
			System.out.println(o.name);
	}

	
	static class report implements Comparable<report>{

		String name;
		int k, e, m;
		
		report(String n, int x, int y, int z){
			name = n;
			k = x;
			e = y; 
			m = z;
		}
		
		public String toString() {
			return name+" "+k+" "+e+" "+m;
		}
		@Override
		public int compareTo(ComparablesPractice.report that) {
			
			if(this.k==that.k) {
				if(this.e==that.e) {					
					return that.m-this.m;
				}
				
				else return this.e-that.e;
			}
			
			else return that.k-this.k;
		}
		
	}
}
