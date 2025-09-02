import java.util.Scanner;
 
public class cw_ccw {
    static class Pair {
        int y;
        int x;
 
        public Pair(int x, int y) {
            super();
            this.y = y;
            this.x = x;
        }
    }
 
    static int ccw(Pair a, Pair b, Pair c) {
        int op = a.x * b.y + b.x * c.y + c.x * a.y;
        op -= (a.y * b.x + b.y * c.x + c.y * a.x);
 
        //(x[i] - x[i-1])*(y[i+1]-y[i]) - (y[i]-y[i-1]*x[i+1]-x[i])
        
        
        // ccw
        if (op > 0)
            return 1;
        // parallel
        else if (op == 0)
            return 0;
        // cw
        else
            return -1;
 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair a = new Pair(sc.nextInt(), sc.nextInt());
        Pair b = new Pair(sc.nextInt(), sc.nextInt());
        Pair c = new Pair(sc.nextInt(), sc.nextInt());
        System.out.println(ccw(a, b, c));
    }
}

//0 0 1 0 1 -1   cw
//1 1 2 1 3 1  parallel
//0 0 -1 0 -1 -1