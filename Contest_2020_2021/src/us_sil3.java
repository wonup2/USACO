import java.io.*;
import java.util.*;

public class us_sil3 {
	static BufferedReader in;
    static StringTokenizer st;
	static int t;
	
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(in.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());

            Integer[] nums = new Integer[n];
            for(int j = 0; j<n; j++)
            	nums[j] = Integer.parseInt(st.nextToken());
            
           // System.out.println(Arrays.toString(nums));

            Arrays.sort(nums);
            
           // HashSet<Integer> s = new HashSet<Integer>();
            
          //  s.addAll(Arrays.asList(nums));
            
            int ans = 0;
            HashSet<Integer> diff = new HashSet<>();
            diff.addAll(Arrays.asList(nums));
            for(int a = 0; a<nums.length; a++){
                for(int b = a+1; b<nums.length; b++){
                    diff.add(nums[b]- nums[a]);
                }
            }
            ArrayList<Integer> l = new ArrayList<>(diff);
            for(int x: l){
                for(int y: l){
                    for(int z: l){
                        if(x <= y && y <= z){
                            if(test(x, y, z, nums)){
                                ans++;
                            }
                        }

                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
    static boolean test(int x, int y, int z, Integer[] nums){
        HashSet<Integer> hset = new HashSet<>();
        hset.add(x);
        hset.add(y);
        hset.add(z);
        hset.add(x+y);
        hset.add(x+z);
        hset.add(y+z);
        hset.add(x+y+z);
        for(int i: nums){
            if(!hset.contains(i)){
                return false;
            }
        }
        return true;
    }
}