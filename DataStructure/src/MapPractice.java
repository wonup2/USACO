import java.util.*;


public class MapPractice {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> m = new LinkedHashMap<Integer, String>();
		
		m.put(10, "AAA");
		m.put(20, "bbb");
		m.put(40, "ccc");		
		m.put(1, "AAA");
		m.put(2, "bbb");
		m.put(4, "ccc");

		
		System.out.println(m);
		
		for(int key:m.keySet()) {
			System.out.println(key+" " +m.get(key));
		}
		
		
		

	}

}
