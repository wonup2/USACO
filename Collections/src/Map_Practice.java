import java.util.*;
public class Map_Practice {

	public static void main(String[] args) {

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Tom", 13);
		m.put("Brandon", 14);
		System.out.println(m);
		System.out.println(m.get("Tom"));
		m.put("Brandon", 15);
		System.out.println(m);
		m.put("James", 20);
		System.out.println(m);
		
		
		for(String key:m.keySet()) {
			System.out.println(key+" : "+m.get(key));
		}
	}

}
