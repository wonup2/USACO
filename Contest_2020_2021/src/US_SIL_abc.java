import java.io.*;
import java.util.*;

public class US_SIL_abc {
	static BufferedReader in;
    static StringTokenizer st;
	static int t, nums[];
	
    public static void main(String[] args) throws IOException {
    	
        in = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(in.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());

            nums = new int[n];
            HashSet<Integer> set = new HashSet<>();

            for(int j = 0; j<n; j++) {
            	nums[j] = Integer.parseInt(st.nextToken());
            	set.add(nums[j]);
            }
            Arrays.sort(nums);

            for(int x = 0; x<nums.length; x++)
                for(int y = x+1; y<nums.length; y++) {
                    set.add(nums[y] - nums[x]);
                    set.add(nums[y] + nums[x]);
                }
               
            //System.out.println(set);
            ArrayList<Integer> l = new ArrayList<>(set);
            int ans = 0;

            for(int x: l) for(int y: l) for(int z: l)
               if(x <= y && y <= z && test(x, y, z)) {
            	   ans++;               
               }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    static boolean test(int x, int y, int z){
    	
        HashSet<Integer> set = new HashSet<>();
        set.add(x); set.add(y); set.add(z);
        set.add(x+y); set.add(x+z); set.add(y+z); set.add(x+y+z);
        for(int i: nums)
            if(!set.contains(i)) return false;
        
//        System.out.println("nums " + Arrays.toString(nums));
// 	    System.out.println(x+" "+y+" "+z);
//        System.out.println("set " + set);

        return true;
        
    }
}