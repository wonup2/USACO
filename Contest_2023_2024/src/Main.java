import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = scanner.nextInt();
    for (int testCase = 0; testCase < t; testCase++) {
      int n = scanner.nextInt();
      int x1 = scanner.nextInt();
      int[][] targets = new int[n][3];
      for (int i = 0; i < n; i++) {
        targets[i][0] = scanner.nextInt();
        targets[i][1] = scanner.nextInt();
        targets[i][2] = scanner.nextInt();
      }
      int[] slopes = new int[4 * n];
      for (int i = 0; i < 4 * n; i++) {
        slopes[i] = scanner.nextInt();
      }
      Arrays.sort(targets, (a, b) -> Integer.compare(a[2], b[2]));
      boolean possible = true;
      for (int i = 1; i < n; i++) {
        if (targets[i][0] < targets[i - 1][1]) {
          possible = false;
          break;
        }
      }
      if (!possible) {
        out.println("-1");
        continue;
      }
      int[] yPositions = new int[4 * n];
      for (int i = 0; i < n; i++) {
        yPositions[i] = targets[i][0];
        yPositions[2 * n + i] = targets[i][1];
        yPositions[n + i] = targets[i][2];
        yPositions[3 * n + i] = targets[i][2];
      }
      Arrays.sort(yPositions);
      int minDistance = Integer.MAX_VALUE;
      for (int i = 0; i < 3 * n - 1; i++) {
        minDistance = Math.min(minDistance, yPositions[i + 3 * n] - yPositions[i]);
      }
      out.println(minDistance);
    }
    out.flush();
    out.close();
    scanner.close();
  }
}
