import java.util.*;
import java.io.*;
public class lifeguards{
	static Scanner in;
  	static PrintWriter out;
  	static int[][] a;
	static int[] b, c;
	static int temp;
  static int n, max = 0, tempIndex, ans;
  
	public static void main(String[] args) throws IOException{
  	in = new Scanner(new File("lifeguards.in"));
    out = new PrintWriter(new File("lifeguards,out"));
    init();
    solve();
  }
	
  static void init(){
  	n = in.nextInt();
    a = new int[n][2];
    b = new int[n];
    c = new int[n];
    for(int i = 0; i < n; i++){
    	
    	a[i][0] = in.nextInt();
        a[i][1] = in.nextInt();
      
    }
  }
      
  static void solve(){
  Arrays.sort(a, new Comparator<int[]>(){
  	public int compare(int[] a, int[] b) {
  		return Integer.compare(a[0], b[0]);
  	}
  });  
  System.out.println(Arrays.deepToString(a));
  	for(int i = 0; i < n - 1; i++){
  		temp = 0;
    	for(int j = 0; j < n - 1; j++){
    		if(i == j) {
    			b[i] = 0;
    			out.println("true");
    			continue;
    		}
    		else{
    			out.println("false");
    			if(a[j][1] > a[j + 1][0]){
    				b[i] = a[j + 1][0] - a[j][0];
    			}else{
    				b[i] = a[j][1] - a[j][0];
    			}
    		}
    		
    		if(j == n - 2){
          		b[n - 1] = a[n - 1][1] - a[n - 1][0];
         	}
    	}
    	
    	System.out.println(Arrays.toString(b));
    	for(int j = 0; j < n; j++) {
    		temp += b[j];
    	}
    	c[i] = temp;
    	out.println(Arrays.toString(b));
    }
  	for(int j = 0; j < n; j++){
    	max = Math.max(max, c[j]);
    }
    System.out.println(max);
    in.close();
    out.close();
  }

}