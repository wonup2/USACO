import java.util.*;

public class US_SIL_1 {
    static int N, Q;
    static long[] sum, sqsum;
    static int[] a, idx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Q = sc.nextInt();
        a = new int[N + 1];
        idx = new int[N + 1];
        sum = new long[N + 1];
        sqsum = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
            idx[i] = i*a[i];
        }

        Arrays.sort(idx);

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + a[idx[i]] * i;
            sqsum[i] = sqsum[i - 1] + a[idx[i]] * (long) i * i;
        }

        while (Q-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            a[i] = j;
            System.out.println(sum[N]);
        }

        sc.close();
    }

    static void update(int k) {
        for (int i = k; i <= N; i++) {
            sum[i] = sum[i - 1] + a[idx[i]] * i;
            sqsum[i] = sqsum[i - 1] + a[idx[i]] * (long) i * i;
        }
        for (int i = k; i <= N; i++) {
            int j = i;
            while (j < N && a[idx[j]] < a[idx[j + 1]]) {
                swap(j, j + 1);
                j++;
            }
            while (j > k && a[idx[j]] > a[idx[j - 1]]) {
                swap(j, j - 1);
                j--;
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = idx[i];
        idx[i] = idx[j];
        idx[j] = tmp;
    }
}
