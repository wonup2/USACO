import java.io.*;
import java.util.*;

public class BS_1C{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> a = new ArrayList<Integer>();
                
        st = new StringTokenizer(in.readLine());
        
        for(int i=0; i<n; i++)
        	a.add(Integer.parseInt(st.nextToken()));
        Collections.sort(a);
                
        st = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	int ind = a.indexOf(num);
        	if(ind >=0) System.out.println(ind+1);
        	else System.out.println(Math.abs(Collections.binarySearch(a, num))-1);
        }
    }
}
