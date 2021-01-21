import java.util.Arrays;
import java.util.Scanner;

public class UnionFind {	
	
	int[] parent;
	
	public UnionFind(int n) {
		parent = new int[n+1];
		for (int i =1; i<parent.length ; i++) {
			parent[i] = i;
		}
	}
	
	int getParent(int parent[], int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	boolean union(int a, int b) {
		boolean flag = false;
		
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		if(a==b) flag = true;
		
		if(a<b) parent[b]=a; 
		else parent[a]=b;
		
		return flag;
	}
	
	int find(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b) return 1;
		else return 0;		
	}	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int a[][] = new int[m][2];
		
		UnionFind uf = new UnionFind(n);
		System.out.println(Arrays.toString(uf.parent));

		for(int i=0; i<m; i++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}
		
		while(true) {
			boolean flag = true;
			int cnt=0;
			for(int i=0; i<m; i++) {
				flag = uf.union(a[i][0] , a[i][1]);
				
				if(flag==false) cnt++;
//				System.out.println(a[i][0] +" "+a[i][1] +" "+ flag +" "+cnt);
//				System.out.println(Arrays.toString(uf.parent));
			}
			if(cnt==0) break;
		}
		
//		uf.union(2, 3);
//		uf.union(3, 4);
//		uf.union(5, 6);
//		uf.union(6, 7);
//		uf.union(7, 8);
//		uf.union(9, 10);

		
	}
}