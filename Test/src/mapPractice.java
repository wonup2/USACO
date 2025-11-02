import java.util.*;

public class mapPractice {

	public static void main(String[] args) {


		//HashMap<Integer, String> map = new HashMap<Integer, String>();
		//TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(100, "Julia");
		map.put(95, "Yujin");
		map.put(98, "Ian");
		map.put(105, "Eric");
		map.put(106, "Eric");
		
		System.out.println(map);
		System.out.println(map.get(105));
		System.out.println(map.containsKey(95));
		System.out.println(map.remove(106));
		System.out.println(map);

		for(int key:map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
