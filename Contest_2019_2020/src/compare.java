import java.util.Arrays;

public class compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		report a[] = new report[4];
		a[0] = new report("Hemosoo", 100, 90);
		a[1] = new report("Solomon", 100, 95);
		a[2] = new report("Eric", 95, 100);
		a[3] = new report("Joshua", 100, 100);
				
		for(int i=0; i<4; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
		Arrays.sort(a);
		
		for(int i=0; i<4; i++) {
			System.out.println(a[i]);
		}
	}

	static class report implements Comparable<report>{
		String name;
		int eng;
		int math;
		
		report(String n, int e, int m){
			name=n;
			eng=e;
			math=m;
		}
		
		public String toString() {
			return name+"\t"+eng+"\t"+math;
		}

		@Override
		public int compareTo(report that) {
			
			if(this.name.compareTo(that.name) < 0)
				return -1;
			else return 1;
			
			/*
			if(this.eng==that.eng)
				return this.math-that.math;
			return that.eng - this.eng;*/
		}
	}
}
