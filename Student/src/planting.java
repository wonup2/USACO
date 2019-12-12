import java.util.*;
import java.io.*;
public class planting {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("planting.in"));
        PrintWriter out = new PrintWriter(new File("planting.out"));
        int n = in.nextInt();
        Map<Integer, Integer> list = new HashMap<Integer, Integer>();
        for(int i = 0; i < (n-1)*2; i++) {
            int a = in.nextInt();
            if(!list.containsKey(a)) {
                list.put(a, 1);
            }else {
                list.put(a, list.get(a) +1);
            }
        }
        int max = 0;
        for (Integer key : list.keySet()) {
            max = Math.max(max, list.get(key));
        }
        out.println(max + 1);
        out.close();
        in.close();
    }
}