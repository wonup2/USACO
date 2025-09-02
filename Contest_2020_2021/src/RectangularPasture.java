import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class RectangularPasture {
    static int[][] sums;
 
    static int getSum(int fromX, int toX, int fromY, int toY) {
        return sums[toX][toY] - sums[fromX - 1][toY] - sums[toX][fromY - 1] + sums[fromX - 1][fromY - 1];
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cows = new Integer[n];
        for (int j = 0; j < n; j++) {
            xs[j] = in.nextInt();
            ys[j] = in.nextInt();
            cows[j] = j;
        }
        System.out.println(Arrays.toString(xs));
        Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
        System.out.println("cowX "+Arrays.toString(cows));
        for (int x = 1; x <= n; x++) {
            xs[cows[x - 1]] = x;
        }
        Arrays.sort(cows, Comparator.comparingInt(j -> ys[j]));
        System.out.println("cowY "+Arrays.toString(cows));
        for (int y = 1; y <= n; y++) {
            ys[cows[y - 1]] = y;
        }
        
        System.out.println(Arrays.toString(xs));
        System.out.println(Arrays.toString(ys));

        sums = new int[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            sums[xs[j]][ys[j]]++;
        }
        
        print(sums);
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (x > 0) {
                    sums[x][y] += sums[x - 1][y];
                }
                if (y > 0) {
                    sums[x][y] += sums[x][y - 1];
                }
                if (x > 0 && y > 0) {
                    sums[x][y] -= sums[x - 1][y - 1];
                }
            }
        }
        
		print(sums);

        long answer = n + 1;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                answer += getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), 1, Math.min(ys[j], ys[k]))
                        * getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), Math.max(ys[j], ys[k]), n);
            }
        }
        System.out.println(answer);
    }
    
    static void print(int[][]a) {
    	for(int i=0; i<a.length; i++) {
    		for(int j=0; j<a[0].length; j++) {
    			System.out.print(a[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	
    }
}