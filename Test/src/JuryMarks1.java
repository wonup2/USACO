import java.io.*;
import java.util.*;

public class JuryMarks1 {
	
	static BufferedReader in;
	static String s[];
	static int k, n, a[], b[];
    public static void main(String[] args) throws IOException {
    	
    	init();
    	solve();
    	
    	in.close();
    }
    
    static void init() throws IOException {
    	in = new BufferedReader(new InputStreamReader(System.in));
        s = in.readLine().split(" ");
        
        k = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        a = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        b = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    
    static void solve() {
    	
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int v : b) {
        	
            int sum = 0;
            
            Set<Integer> set = new HashSet<>();
            
            for (int i = 0; i < k; ++i) {
                sum += a[i];
                set.add(v - sum);
            }
            
            for (int e : set) { 
                if (map.containsKey(e)) map.put(e, map.get(e) + 1);
                else map.put(e, 1);                
            }
        }
        
        int count = 0;
        for (Integer v : map.values()) 
            if (b.length == v) count++;
            
     
        System.out.println(count);
    }
}