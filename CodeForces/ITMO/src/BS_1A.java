import java.io.*;
import java.util.*;

public class BS_1A{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
                
        st = new StringTokenizer(in.readLine());
        
        for(int i=0; i<n; i++)
        	a[i] = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	if(Arrays.binarySearch(a, num) >=0) sb.append("YES");
        	else sb.append("NO");
        	sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

/*
10 10
1 61 126 217 2876 6127 39162 98126 712687 1000000000
100 6127 1 61 200 -10000 1 217 10000 1000000000
*/