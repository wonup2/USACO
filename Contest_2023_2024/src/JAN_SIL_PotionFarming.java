import java.util.*;
import java.io.*;
 
public class JAN_SIL_PotionFarming {
	static BufferedReader in;
	static StringTokenizer st;
	static int n, s, p[], l[], cnt, order[];
	static ArrayList<Integer>[] a;
	static boolean v[];

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        s = 0;        
        
        p = new int[n];        
        st= new StringTokenizer(in.readLine());
        for (int i=0; i<n; i++) p[i] = Integer.parseInt(st.nextToken())-1;
        
        a = new ArrayList[n];
        for (int i = 0; i < n; i++) a[i] = new ArrayList<Integer>();
        
        for (int i = 0; i < n - 1; i++) {
            st= new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            a[x].add(y);
            a[y].add(x);
        }
		v = new boolean[n];

        solve();
    }
    
    static void solve(){
    	
    	l = new int[n];
        int leaves = dfs1(s, -1);
        
        //System.out.println(Arrays.toString(l));

        order = new int[n];
        for (int i = 0; i < leaves; i++) order[p[i]]++;
        
        System.out.println(Arrays.toString(order));


        System.out.println(dfs2(s, -1));
    }

    
    public static int dfs1(int cur, int par){
    	System.out.println("cur: " + cur);
        if ((a[cur].size() == 1 && a[cur].get(0) == par)){  //root node 가 아닌 leaf node 갯수
            l[cur] = 1;
            return 1;
        }
        
        int sum = 0;
        for (int node: a[cur]){
            if (node == par) continue;   // 1--> 2  만체크, 2-->1 은 하지마. Cycle 방지         
            sum += dfs1(node,cur);
        }
        l[cur] = sum;  System.out.printf("l[%d] = %d\n", cur, sum);
        return sum;	//마지막으로는 1번 check
    }
    
    public static int dfs2(int cur, int par){
        int sum = 0;
        for (int node : a[cur]){
            if (node == par) continue;
            
            sum += dfs2(node,cur);
        }
        sum += order[cur];  System.out.println("dfs2: " + cur+" "+ sum + " "+ l[cur]);
        return Math.min(sum,l[cur]);
    }
    
    
    public static int dfs(int i){
    	//System.out.println(a[i]);
        if (a[i].size() == 1) return 1;
        v[i] = true;
        int sum = 0;
        for (int node: a[i]){
            if (v[node]) continue;   
            sum += dfs(node); 
        }
        
        //System.out.println(i+" "+sum);
        return sum;
    }
  }