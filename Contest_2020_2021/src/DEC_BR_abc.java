import java.util.*;

public class DEC_BR_abc {
    static Scanner in;
    static int a[];
    public static void main(String[] args) {
        in = new Scanner(System.in);

        a = new int[7];
        for(int i=0; i<7; i++) a[i] = in.nextInt();
        Arrays.sort(a);
        
        System.out.println(a[0] + " " + a[1] + " "  + (a[6]-a[0]-a[1]));
    }
}