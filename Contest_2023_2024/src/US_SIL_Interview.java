import java.util.*;
import java.io.*;

public class US_SIL_Interview {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, k;
	static PriorityQueue<Long> pq;
	static long a[];
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        init();
        solve();
    }
    
    static void init() throws IOException {
    	
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        n -= k; // 첫 k개의 소는 이미 처리됨

        pq = new PriorityQueue<Long>();
        a = new long[k];
        
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < k; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
            pq.add(a[i]); 
        }
        
        System.out.println(Arrays.toString(a));
        System.out.println(pq);
    }
    
    static void solve() {
    	
        StringBuilder sb = new StringBuilder();        
    	HashMap<Long, Set<Long>> map = new HashMap<Long, Set<Long>>();
        for (int i = 0; i < n; ++i) {
            long t = Integer.parseInt(st.nextToken());
            long f = pq.poll(); 	// 현재 가장 빨리 끝나는 면접
            pq.add(f + t); 		// 새 면접 시간 추가
            map.computeIfAbsent(t + f, k1 -> new HashSet<>()).add(f);
            System.out.println(map);
            System.out.println(pq);
        }
        
        

        
        
        long t = pq.peek(); 
        sb.append(t).append("\n");
        
        HashSet<Long> v = new HashSet<Long>();
        Queue<Long> q = new LinkedList<Long>();
        q.add(t);

        while (!q.isEmpty()) {
            System.out.println("bfs: "+q);
            System.out.println("vis: "+v);

            long cur = q.poll();
            if (map.containsKey(cur)) {
                for (long x : map.get(cur)) {
                    if (!v.contains(x)) {
                        v.add(x);
                        q.add(x);
                    }
                }
            }
        }
        

        // 가능한 모든 면접관을 출력
        for (int i = 0; i < k; ++i) {
            if (v.contains(a[i])) sb.append(1);
            else sb.append(0);
        }
        System.out.println(sb.toString());
    }
}

/*
6 3
3 1 1 1 1 1

*/

