package Dec2019silver;
import java.util.*;
import java.io.*;
public class milkvisits {
	static Scanner in;
	static PrintWriter out;
	static int n;
	static String[] type;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("milkvisits.in"));
		out = new PrintWriter (new File("milkvisits.out"));
		Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
		StringTokenizer st = new StringTokenizer(in.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ans = new int[M]; 
		String line = in.nextLine();
		type = line.split("");
		for(int x = 0; x < N-1; x++) {
			st = new StringTokenizer(in.nextLine());
			int cow1 = Integer.parseInt(st.nextToken());
			int cow2 = Integer.parseInt(st.nextToken());
			if(!adj.containsKey(cow1)) {
				adj.put(cow1, new ArrayList<Integer>());
			}
			if(!adj.containsKey(cow2)) {
				adj.put(cow2, new ArrayList<Integer>());
			}
			// constructing adjacency list
			adj.get(cow1).add(cow2);
			adj.get(cow2).add(cow1);
		}
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(in.nextLine());
			int start = Integer.parseInt(st.nextToken());
			System.out.println(start);
			int end = Integer.parseInt(st.nextToken());
			String milk = st.nextToken();
			ArrayList<String> list = new ArrayList<String>();
			boolean[] visited = new boolean[N];
			dfs(start, end,milk, adj, visited, list);
			if(list.contains(milk)) {
				ans[i] = 1;
			}else {
				ans[i] = 0;
			}
		}
		System.out.println(Arrays.toString(ans));
		
	}
	static boolean y = false;
	public static void dfs(int start, int end, String milk, Map<Integer, ArrayList<Integer>> adj, boolean[] visited,ArrayList<String> list  ) {
		if(visited[start-1]== true)
			return;
		if(start == end) {
			y = true;
			return;
		}
		visited[start -1] =true;
		System.out.println(Arrays.toString(visited));
		list.add(type[start-1]);
		System.out.println(list);
		
		for(int i = 1; i <= adj.get(start).size(); i++){
			dfs(adj.get(start).get(i-1), end, milk, adj, visited, list); 
			if(y == false) {
				list.remove(list.size()-1);
			}
		}
		
	}
}
