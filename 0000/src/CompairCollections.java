import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CompairCollections {

	public static void main(String[] args) {

		
		pair[] a = new pair[3];
		
		a[0] = new pair(5, 10);
		a[1] = new pair(5, 6);
		a[2] = new pair(20,30);
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));

		Arrays.sort(a, new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				return o1.a-o2.a;
			}			
		});		
	}

	
	
	
	static class pair implements Comparable<pair>{

		int a;
		int b;
		
		pair(int a1, int b1){
			a = a1;
			b = b1;
		}
		
		public String toString() {
			return a+" "+b;
		}
		
		@Override
		public int compareTo(pair that) {
			if(this.a<that.a) return -1;
			else if(this.a>that.a) return 1;
			else {
				if(this.b<=that.b) return -1;
				else return 1;
			}
		}		
	}	
}
