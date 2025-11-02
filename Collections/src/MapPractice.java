import java.util.*;

public class MapPractice {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> m1 = new LinkedHashMap<Integer, String>();
		
		m1.put(10, "Erin");
		m1.put(101, "Tommy");
		m1.put(20, "David");
		m1.put(15, "Jaden");
		m1.put(20, "Connor");
		m1.put(6, "Jaden");
		
		System.out.println(m1);
		System.out.println(m1.get(5));
		if (m1.containsKey(20)) System.out.println("YES");
		
		for(int key:m1.keySet())
			System.out.println(key+ " : " + m1.get(key));
		/*
		HashSet<String> s = new HashSet<String>();
		s.addAll(m1.values());
		System.out.println(s.size()==m1.size());
		
		System.out.println(s);
		*/

	}

}
