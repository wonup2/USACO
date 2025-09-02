import java.util.*;
public class SetPractice {

	public static void main(String[] args) {

		TreeSet<Integer> s = new TreeSet<Integer>();
		
		s.add(1);
		s.add(2);
		s.add(2);
		
		System.out.println(s);
		System.out.println(Math.abs(s.first() - s.last()));
		
		HashSet<Integer> a = new HashSet<Integer>();
		
		a.addAll(s);
		a.add(3);
		
		a.clear();
		a.addAll(s);
//		System.out.println(a);
//		System.out.println(s);
	

	}

}
