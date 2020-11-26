import java.util.*;

public class MakeClass {

	public static void main(String[] args) {

		pair a[] = new pair[3];
		
		//300 1000
		//700 1200
		//1500 2100

		a[0] = new pair(700, 1000);
		a[1] = new pair(300, 1200);
		a[2] = new pair(300, 700);
		
		System.out.println(Arrays.toString(a));

		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
	}
	
	
	static class pair implements Comparable<pair>{

		int start;
		int end;
		
		pair(int s, int e){
			start = s;
			end = e;
		}		
		
		@Override
		public int compareTo(pair that) {
			
			if(this.start < that.start) return -1;
			else if (this.start > that.start) return 1;
			else {
				if(this.end < that.end) return -1;
				else return 1;
			}
		}	
		
		public String toString() {
			return start+" "+end;
		}
		
	}
}
