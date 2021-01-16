import java.io.*;
import java.util.*;

public class BS_1D{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        List<Integer> a = new ArrayList<Integer>();
                
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        for(int i=0; i<n; i++)
        	a.add(Integer.parseInt(st.nextToken()));
        
        Collections.sort(a);
        int m = Integer.parseInt(in.readLine());

        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(in.readLine());
        	int _x = Integer.parseInt(st.nextToken());
        	int _y = Integer.parseInt(st.nextToken());
        	int low = Math.min(_x, _y);
        	int high = Math.max(_x, _y);

        	int x = a.indexOf(low);
        	int y = a.lastIndexOf(high);

        	if(x<0) x = Math.abs(Collections.binarySearch(a, low)+1);
        	if(y<0) y = Math.abs(Collections.binarySearch(a, high)+2);

        	System.out.print(y-x+1+" ");
        }
    }
}
/*
5
10 1 10 3 4
4
1 10
2 9
3 4
2 2

*/