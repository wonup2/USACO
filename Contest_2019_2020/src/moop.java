import java.util.*;
import java.io.*;

public class moop {

    static BufferedReader in;
    static PrintWriter out;
    static String file = "moop";
    
    static int N, count;
    static spin spinList[];
    static ArrayList<Integer>[] a;
    static boolean[] v;
    
    
    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new FileReader(file + ".in"));
        out = new PrintWriter(new File(file + ".out"));
    	//in = new BufferedReader (new InputStreamReader (System.in));
                
        init();
        solve();
        
        in.close();   
        out.close();
    }

    
    static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	N = Integer.parseInt(st.nextToken());
    	
    	v = new boolean[N];
    	spinList = new spin[N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		spinList[i] = new spin(x, y);
    	}
    	
    	Arrays.sort(spinList);
    	System.out.println(Arrays.toString(spinList));
    	
    	a = new ArrayList[N];
    	for(int i = 0; i < N; i++) {
    		a[i] = new ArrayList<Integer>();
    	}
    	
    	//TIMEOVER
    	//Arrays.sort(a);
//    	for(int i = 0; i < N - 1; i++) {
//    		for(int j = i + 1; j < N; j++) {
//    			if(spinList[i].x >= spinList[j].x && spinList[i].y > spinList[j].y) {
//    				a[i].add(j);
//    				a[j].add(i);
//    			}
//    		}
//    	}
//    	
    	
    	for(int i = 0; i < N; i++) {
    		if(!v[i]) {
    			dfs1(i);
    			
    		}
        	//v = new boolean[N];
    	}
    	
    	
    	System.out.println(Arrays.toString(a));
    }
    
    static void dfs1(int start) {
    	v[start] = true;
    	
    	for(int i:a[start]) {
    		if(!v[i]&&spinList[i].x >= spinList[start].x && spinList[i].y >= spinList[start].y) {
    			a[i].add(start);
				a[start].add(i);
    			dfs(i);
    		}
    	}
    }
    
    
    
    
    static void solve() {
    	count = 0;
    	
    	for(int i = 0; i < N; i++) {
    		if(!v[i]) {
    			dfs(i);
    			count++;
    		}
    	}
    	System.out.println(count);
    	out.println(count);
    }
    
    static void dfs(int start) {
    	v[start] = true;
    	
    	for(int i:a[start]) {
    		if(!v[i]) {
    			dfs(i);
    		}
    	}
    }
    
    static class spin implements Comparable<spin>{
    	int x, y;
    	
    	spin(int xSpin, int ySpin){
    		x = xSpin;
    		y = ySpin;
    	}
    	
    	public String toString() {
    		return "(" + x + ", " + y + ")";
    	}
    	
    	public int compareTo(spin o) {
			// TODO Auto-generated method stub
			if(o.x == this.x) {
				return o.y - this.y;
			}
			else {
				return o.x - this.x;
			}
		}
    }
}
