import java.util.*;
public class SetPractice {

	public static void main(String[] args) {

		HashSet<Integer> s1 = new HashSet<Integer>();
		
		s1.add(10);
		s1.add(101);
		s1.add(5);
		s1.add(22);
		s1.add(10);
		System.out.println(s1);
		
		for(int n:s1)
			System.out.println(n+" ");
		
		if (s1.contains(5)) System.out.println("yes");  //O(1)
		
		
		//
		TreeSet<Integer> s2 = new TreeSet<Integer>();
		s2.add(10);
		s2.add(101);
		s2.add(5);
		s2.add(22);
		s2.add(10);
		
		System.out.println(s2);
		System.out.println(s2.first() +" "+ s2.last());
		
		//
		LinkedHashSet<Integer> s3 = new LinkedHashSet<Integer>();
		s3.add(10);
		s3.add(101);
		s3.add(5);
		s3.add(22);
		System.out.println(s3);

		
	}

}
