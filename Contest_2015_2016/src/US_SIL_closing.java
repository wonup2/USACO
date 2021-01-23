import java.io.*;
import java.util.*;
public class US_SIL_closing {
	
	static boolean v[], closed[];
	static LinkedList<Integer> nodes;
	static ArrayList<LinkedList<Integer>> a;
	static int cnt;
	
    public static void main (String [] args) throws IOException {
    	
        BufferedReader in = new BufferedReader(new FileReader("closing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());    
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        a = new ArrayList<LinkedList<Integer>>(); 
        closed = new boolean[N]; 
        nodes = new LinkedList<Integer>(); 
       
        for(int i = 0; i <N; i++) {
            a.add(new LinkedList<Integer>()); 
            nodes.add(i);
        }
        
        for(int i = 0; i < M; i++){ 
            StringTokenizer tempSt = new StringTokenizer(in.readLine());
            int i1 = Integer.parseInt(tempSt.nextToken())-1;
            int i2 = Integer.parseInt(tempSt.nextToken())-1;
            a.get(i1).add(i2);
            a.get(i2).add(i1);
        }       
        
        cnt=1;
        v = new boolean[N];
        dfs(1);
        if(cnt == N) out.println("YES");
        else out.println("NO");
        
        for(int i = 0; i < N - 1; i++){
            int num = Integer.parseInt(in.readLine())-1;
            closed[num] = true; 
            nodes.remove(nodes.indexOf(num)); 
            
            cnt=1;
            v = new boolean[N];
            dfs(nodes.get(0));
            
            if(cnt == nodes.size()) out.println("YES");
            else out.println("NO");
        }
        out.close();
    }
    
    static void dfs(int i){
         v[i] = true; 
            
         for(int w : a.get(i)){ 
          	 if(!v[w] && !closed[w]){ 
                 cnt++;
                 dfs(w);
             }
         }   
    }
}