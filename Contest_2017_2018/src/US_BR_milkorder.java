import java.io.*;
import java.util.*;

public class US_BR_milkorder {
	static Scanner in;
	static PrintWriter out;
	static String file = "milkorder";
	
    // Tracks whether each cow has already been placed
    static boolean[] usedCow = new boolean[100];
    
    // Tracks whether each position is already taken
    static boolean[] usedPos = new boolean[100];
    
    // Stores the final position of each cow
    static int[] pos = new int[100];

    // Array of cows in a fixed social hierarchy (0-based)
    static int[] ord = new int[100];
    
    // Array of cows with fixed positions (0-based)
    static int[] cFixed = new int[101];
    
    // Array of fixed positions corresponding to cFixed (0-based)
    static int[] pFixed = new int[101];

    static int nCows, M, nFixed;
    
    static void init() {
        // Read number of cows, number of hierarchy constraints, and fixed position constraints
        nCows = in.nextInt();
        M = in.nextInt();
        nFixed = in.nextInt();

        // Read social hierarchy list (convert to 0-based)
        for (int i = 0; i < M; i++) ord[i] = in.nextInt() - 1;
        
        // Read fixed position constraints (convert to 0-based)
        for (int i = 0; i < nFixed; i++) {
            cFixed[i] = in.nextInt() - 1;
            pFixed[i] = in.nextInt() - 1;
        }

        // Increase size to add cow 1's position trial later
        nFixed++;

        // Try placing cow 1 (index 0) in every possible position from 0 to nCows - 1
        for (int i = 0; i < nCows; i++) {
            cFixed[nFixed - 1] = 0; // cow 1 (0-based)
            pFixed[nFixed - 1] = i; // try position i (0-based)

            // If it works, output the (1-based) position and exit
            if (works()) {
                out.println(i + 1);
                break;
            }
        }
    }
        
    // Checks whether all constraints (fixed order + fixed positions) can be satisfied
    static boolean works() {
          
    	// Reset tracking arrays for each test run
        Arrays.fill(usedCow, 0, nCows, false);
        Arrays.fill(usedPos, 0, nCows, false);

        // 1. Apply all fixed position constraints
        for (int i = 0; i < nFixed; i++) {
        	int cow = cFixed[i]; // cow ID
            int p = pFixed[i];   // required position

            // If already placed at correct position, skip
            if (usedCow[cow] && pos[cow] == p) continue;

            // If the cow is already placed somewhere else, or
            // the position is already taken by another cow → invalid
            if (usedCow[cow]) return false;
            if (usedPos[p]) return false;

            // Place the cow at the fixed position
            usedCow[cow] = true;
            usedPos[p] = true;
            pos[cow] = p;
        }

        // 2. Place cows according to social hierarchy (ord[])
        int j = 0; // pointer to the earliest available position
        for (int i = 0; i < M; i++) {
            int cow = ord[i];
            if (usedCow[cow]) {
                // If already placed, ensure current j doesn't violate order
                if (j > pos[cow]) return false;
                j = pos[cow];
            }

            // Find the next available (unused) position
            while (j < nCows && usedPos[j]) j++;
          
            // No available position left → invalid
            if (j == nCows) return false;

            // Place the cow and mark position as used
            usedPos[j] = true;
            pos[cow] = j;            
        }

        return true;        
    }     
    
    public static void main(String[] args) throws IOException {
    	in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		init();
		in.close();
        out.close();
    }
}
