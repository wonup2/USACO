import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int[] cnt = new int[len + 1]; // cnt[i]: s.substring(0, i)에서 bessie의 개수
        for (int i = 0; i < len; i++) {
            if (i >= 5 && s.substring(i - 5, i).equals("bessie")) {
                cnt[i + 1] = cnt[i - 4] + 1;
            } else {
                cnt[i + 1] = cnt[i];
            }
        }
        long ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                ans += cnt[j] - cnt[i]; // i부터 j-1까지의 부분문자열에서 bessie의 개수를 더함
            }
        }
        System.out.println(ans);
    }
}
