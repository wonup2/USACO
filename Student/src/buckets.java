//package USOpen_2019;

import java.util.*;
import java.io.*;
public class buckets {

static Scanner in;
static PrintWriter out;

	//Input Variables
    static String[][] grid;

    public static void main(String[] args) {

        try {

            //Initialize in & out
            in = new Scanner(new File("buckets.in"));
            out = new PrintWriter(new File("buckets.out"));

            init();

            //Write out file
            out.println(solve());

            out.close();
            in.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    private static void init() {
        //Get data 
        //Initialize Input Variables
    	grid = new String[10][10];
    	for (int i = 0; i < 10; i++) {
    		String temp = in.nextLine();
    		for (int j = 0; j < 10; j++) {
    			grid[i][j] = temp.substring(j, j+1);
    		}
    	}
    	
//    	for (int i = 0; i < 10; i++) {
//    		for (int j = 0; j < 10; j++) {
//    			System.out.print(grid[i][j]);
//    		}
//    		System.out.println();
//    	}
    }

    private static String solve() {
    	int bx = 0;
    	int by = 0;
    	int lx = 0;
    	int ly = 0;
    	int rx = 0;
    	int ry = 0;
    	for (int i = 0; i < 10; i++) {
    		for (int j = 0; j < 10; j++) {
    			if (grid[i][j].equals("B")) {
    				bx = j+1;
    				by = i+1;
    			}
    			else if (grid[i][j].equals("R")) {
    				rx = j+1;
    				ry = i+1;
    			}
    			else if (grid[i][j].equals("L")) {
    				lx = j+1;
    				ly = i+1;
    			}
    		}
    	}
    	
    	//System.out.println(bx + " " + by + " " + lx + " " + ly);
    	
    	int n = 0;
    	if (bx == lx) {
    		n = Math.abs(by - ly) - 1;
    		//System.out.println(by + " " + ly + " " + n);
    		if (rx == bx && (ry < by && ry > ly) || (ry < ly && ry > by)) {
    			n += 2;
    		}
    	}
    	else if (by == ly) {
    		n = Math.abs(bx - lx) - 1;
    		if (ry == by && (rx < bx && rx > lx) || (rx < lx && rx > bx)) {
    			n += 2;
    		}
    	}
    	else if (bx != lx && by != ly) {
    		n = Math.abs(by - ly) + Math.abs(bx - lx) - 1;
    	}
        return n+"";
    }
}
