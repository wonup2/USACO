
import java.io.*;
import java.lang.*;
import java.util.*;

public class YearOfTheCow {

    public static void main (String [] args) throws IOException {

        // Input:
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
            set.add((Integer.parseInt(f.readLine()) + 11) / 12);
        }

        int[] years = new int[set.size()];
        int index = 0;
        for(int i : set)
        {
            years[index] = i;
            index++;
        }
        Arrays.sort(years);

        ArrayList<Integer> gaps = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < years.length; i++)
        {
            int gap = years[i] - last - 1;
            if (gap > 0)
            {
                gaps.add(gap);
            }
            last = years[i];
        }
        Collections.sort(gaps, Collections.reverseOrder());

        int result = years[years.length-1];
        for (int i = 0; i < k-1 && i < gaps.size(); i++)
        {
            result -= gaps.get(i);
        }

        // Output:
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(result*12);
        out.close();
    }
}