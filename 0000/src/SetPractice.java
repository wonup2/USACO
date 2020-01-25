import java.util.*;
public class SetPractice {

	public static void main(String[] args) {

		HashSet<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		HashSet<Integer> a = new HashSet<Integer>();
		
		a.addAll(s);
		a.add(3);
		
		a.clear();
		a.addAll(s);
		System.out.println(a);
		System.out.println(s);
	

	}

}
