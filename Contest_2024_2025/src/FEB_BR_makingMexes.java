import java.util.*;

public class FEB_BR_makingMexes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = sc.nextInt();
        sc.close();

        // 1. 각 숫자가 몇 번 나오는지 센다.
        int[] cnt = new int[N + 1];
        for (int x : a) cnt[x]++;
        
        // 2. missing[i] 계산: 0~i-1 중 빠진 숫자의 개수
        int missing = 0;
        boolean[] seen = new boolean[N + 1];
        int[] answer = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            // i보다 작은 수 중 없는 게 몇 개인지 계산
            if (i>0 && cnt[i - 1] == 0) missing++;

            // 최소 연산 수 = max(missing, cnt[i])
            answer[i] = Math.max(missing, cnt[i]);            
        }

        // 3. 출력
        for (int i = 0; i <= N; i++) System.out.println(answer[i]);
    }
}
