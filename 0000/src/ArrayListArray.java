import java.util.*;

public class ArrayListArray {

	public static void main(String[] args) {

		
		ArrayList<Integer> a[] = new ArrayList[3];
		
		for(int i = 0; i<3; i++)
			a[i] = new ArrayList<Integer>();
		
		a[0].add(1);
		a[0].add(2);
		
		a[1].add(3);
		a[1].add(4);
		a[1].add(5);
		
		a[2].add(10);
		

		System.out.println(Arrays.toString(a));
		
		
		for(int i = 0; i<3; i++) {
			
			for(int n: a[i]) {
				System.out.print(n+" ");				
			}
			System.out.println();			
		}
		

	}

}
