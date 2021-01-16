import java.io.*;
import java.util.*;

public class BS_1B{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
                
        st = new StringTokenizer(in.readLine());
        
        for(int i=0; i<n; i++)
        	a[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(a);
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	num = Arrays.binarySearch(a, num);
        	if(num >=0) System.out.println(num+1);
        	else System.out.println(Math.abs(num+1));
        }
    }
}
/*
5 5
3 3 5 8 9
2 4 8 1 10
0
2
4
0
5
*/