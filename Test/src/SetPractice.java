import java.util.*;

public class SetPractice {

	public static void main(String[] args) {

		//HashSet<Integer> set = new HashSet<Integer>();
		
		//TreeSet<Integer> set = new TreeSet<Integer>();
		
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		
		set.add(10);
		set.add(100);
		set.add(21);
		set.add(35);
		set.add(312);
		set.add(10);
		
		System.out.println(set.size());
		System.out.println(set.contains(21));
		System.out.println(set);
		
		for(int n:set)
			System.out.println(n);
				
	}
}
