import java.util.*;
import java.io.*;

public class FEB_SIL_snowboot {
    static List<Pair<Integer, Integer>> B = new ArrayList<>();
    static int[] D;
    static boolean[][] vist;
    static int N, M, A=10000;
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader("snowboots.in");
        N = in.nextInt(); M = in.nextInt(); D = new int[N]; vist = new boolean[N+1][M+1];
        for (int i = 0; i < N; i++) {
            D[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int a,b; a = in.nextInt(); b = in.nextInt();
            B.add(new Pair<>(a, b));
        }

        dfs(0,0);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
        out.println(A);
        out.close();
    }

    private static void dfs(int n, int t){
        //If we have explored that path then return out of it
        if(vist[n][t]) return ;
        vist[n][t] = true;

        //If it reaches the destination we want to take the minimum of what we have and what we got
        if(n == N-1) { A = Math.min(A, t); System.out.println("A " +A +" \n");}
        
        //Trying to go the every farm it can with one boot
        for (int i = n+1; i < N && i-n<=B.get(t).last(); i++) {
            if(D[i] <= B.get(t).first) {
            	System.out.println("first  " +i+" "+ B.get(t).first +" "+t);
            	dfs(i, t);
            }
        }
        
        //Trying all boot switches at the current farm
        for (int i = t+1; i < B.size(); i++) {
            if(D[n] <= B.get(i).first) {
            	System.out.println("Second  " + i+" "+ B.get(t).first +" "+t);

            	dfs(n, i);
            }
        }

    }
    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            try {
                reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            } catch (Exception e) {
                throw new NullPointerException("Could not create input stream");
            }
        }

        public InputReader(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(new File(fileName)), 32768);
            } catch (Exception ex) {
                throw new NullPointerException("Input file does not exist! Put it in the project folder.");
            }
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public boolean hasNextInt() throws IOException { return reader.ready(); }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        /**
         * When you call next(), that entire line will be skipped.
         * No flushing buffers.
         * Doesn't work when you want to scan the remaining line.
         *
         * @return entire line
         */

        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
                tokenizer = null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }

    private static class Pair<F, S> {
        F first;
        S second;

        public Pair(F a, S b) {
            first = a;
            second = b;
        }

        public F one() {
            return first;
        }

        public S last() {
            return second;
        }

        @Override
        public String toString() {
            return "[" + first.toString() + ", " + second.toString() + "]";
        }
    }
}
