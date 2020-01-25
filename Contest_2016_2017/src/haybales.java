import java.util.*;
import java.io.*;
public class haybales {
    static BufferedReader br;
    static PrintWriter pw;
    static int n, q;
    static int[] nums;
    static int[][] queries;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File("haybales.in")));
            pw = new PrintWriter(new File("haybales.out"));
            init();
            pw.print(solve());
            pw.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	q = Integer.parseInt(st.nextToken());
    	nums = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++)
    		nums[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(nums);
    	//System.out.println(Arrays.toString(nums));
    }
    private static String solve() throws IOException {
    	StringBuilder result = new StringBuilder();
    	StringTokenizer st;
    	//System.out.println(q);
    	for(int i = 0; i < q; i++) {
    		st = new StringTokenizer(br.readLine());
    		int index1 = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken()));
    		int index2 = Arrays.binarySearch(nums, Integer.parseInt(st.nextToken())+ 1);
    		//System.out.println(i+" "+index1+" "+index2);
    		if(index1 < 0)
    			index1 = Math.abs(index1 + 1);
    		if(index2 < 0)
    			index2 = Math.abs(index2 + 1);
    		result.append(index2 - index1).append("\n");
    	}
        return result.toString();
    }
}