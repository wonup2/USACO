import java.io.*;
import java.util.*;
public class JAN_GD_angry1{
    public static ArrayList<Integer> l = new ArrayList<>();
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        N = Integer.parseInt(f.readLine());
        for (int i = 0; i < N; i++) { l.add(Integer.parseInt(f.readLine()));}
        Collections.sort(l);
        int beg=0; int rad = 0; int end = N-1; int rad1 = 0;
        double best = Double.MAX_VALUE;
        while(true){
            double val = Math.max(Math.max(rad,rad1)+1,(double)(l.get(end)-l.get(beg))/2);
            if (val<best){best=val;}
            int pot = Math.max(rad+1,l.get(beg+1)-l.get(beg));
            int pot1 = Math.max(rad1+1,l.get(end)-l.get(end-1));
            if(pot<pot1){
                rad=pot; int index = beg;
                while(index<N-1 && l.get(beg)+pot>=l.get(index+1)){index++; }
                beg=index;
            } else {
                rad1=pot1; int index = end;
                while(index>0 && l.get(end)-pot1<=l.get(index-1)){index--;}
                end=index;
            }
            if(end<=beg){
                best= Math.min(best,Math.max(rad,rad1));
                break;
            }
        }
        out.printf("%.1f",best); out.close();
    }
}