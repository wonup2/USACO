import java.util.*;

public class bronze3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
		
		long pre = 0;
		long cur = in.nextLong()-1;
		for(int i=1; i<n; i++) {
			cur += pre;
			map.put(cur, i);
			pre = cur;
			cur = in.nextLong();
		}
		cur += pre;
		map.put(cur, n);
		
		//System.out.println(map);
		for(int i=0; i<m; i++) {
			cur = in.nextLong();
			if(map.containsKey(cur)) {
				System.out.println(map.get(cur));
			}
			else {
				cur = map.higherKey(cur);
				System.out.println(map.get(cur));
			}
		}
	}
}
