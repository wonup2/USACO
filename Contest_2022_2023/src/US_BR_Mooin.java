import java.io.*;
import java.util.*;

public class US_BR_Mooin{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String sRaw = br.readLine().trim();
        char[] s = new char[N + 1];
        for (int i = 1; i <= N; i++) s[i] = sRaw.charAt(i - 1);
        System.out.println(Arrays.toString(s));
        
        
        // 각 알파벳별 등장 위치 TreeSet
        TreeSet<Integer>[] pos = new TreeSet[26];
        for (int i = 0; i < 26; i++) pos[i] = new TreeSet<>();
        for (int i = 1; i <= N; i++) pos[s[i] - 'a'].add(i);
        System.out.println(Arrays.toString(pos));
        
        // nextDiffStart[p] : 같은 문자가 끝나고 다음 문자 시작 인덱스
        int[] nextDiffStart = new int[N + 2];
        int x = 1;
        while (x <= N) {
            int j = x;
            while (j + 1 <= N && s[j + 1] == s[x]) j++;
            int next = j + 1;
            for (int k = x; k <= j; k++) nextDiffStart[k] = next;
            x = j + 1;
        }
        System.out.println(Arrays.toString(nextDiffStart));

        
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (r - l + 1 < 3) {
                sb.append(-1).append('\n');
                continue;
            }

            long best = -1;
            // 26개 알파벳 반복
            for (int c = 0; c < 26; c++) {
                TreeSet<Integer> set = pos[c]; 
                if (set.isEmpty()) continue;
                System.out.println((char)(c+65)+" "+set);
                
                // i: 구간 왼쪽에서 c가 아닌 첫 위치
                int i = (s[l] != (char)('a' + c)) ? l : nextDiffStart[l];
                if (i >= r) continue;
                System.out.print("i: " + i + "\t");
                
                // k: r 이하의 가장 오른쪽 c
                Integer rc = set.floor(r);  
                if (rc == null) continue;
                int k = rc;
                System.out.print("k: "+k + "\t");
                
                // j 후보가 존재하려면 (i, k) 사이에 최소 하나의 c가 있어야 함
                Integer jMin = set.higher(i);
                Integer jMax = set.lower(k);
                if (jMin == null || jMax == null || jMin >= k) continue;
                System.out.print("j: "+ jMin +" " + jMax + "\t");

                

                // 중점 m
                double m = (i + k) / 2.0;
                int floorM = (int)Math.floor(m);
                int ceilM = (int)Math.ceil(m);

                Integer j1 = set.floor(floorM);
                Integer j2 = set.ceiling(ceilM);

                // 후보 둘 다 체크
                if (j1 != null && j1 > i && j1 < k) {
                    long val = (long)(j1 - i) * (long)(k - j1);
                    best = Math.max(best, val);
                }
                if (j2 != null && j2 > i && j2 < k) {
                    long val = (long)(j2 - i) * (long)(k - j2);
                    best = Math.max(best, val);
                }
            }
            sb.append(best).append('\n');
        }

        System.out.print(sb.toString());
    }
}
/*
12 1
abcabbacabac
1 12

*/