import java.io.*;
import java.util.*;

public class JAN_SIL_perimeter {
	
	static int n;
	static int result = 0;
	static int biggest = 0;
	static char[][] map;
	static int resultp = 0;
	static int biggestp = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter out = new PrintWriter(new FileWriter("perimeter.out"));
		
		n = Integer.parseInt(in.readLine());
		
		map = new char[n][];
		
		for(int r = 0; r < n; r++) {
			String plot = in.readLine();
			map[r]=plot.toCharArray();
		}
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(map[r][c]=='#') {
					biggest = 0;
					biggestp = 0;
					countCells(r, c);
					//printBoard(map);
					if(result==biggest){
						resultp = Math.min(resultp, biggestp);
					}
					else{
						resultp = Math.max(resultp, biggestp);
					}
					result = Math.max(result, biggest);

				}
			}
		}
		
		out.println(result + " " + resultp);
		out.close();
	}
	

	
	public static void countCells (int x, int y) {
        if( ! ( y >= 0 && n > y && x >=0 && n > x)) {
            biggestp++; //System.out.println(1);
            return;
        }
        if(map[x][y]=='.') {
            biggestp++;//System.out.println(2);
            return;
        }
        if(map[x][y]=='$') {//System.out.println(3);
            return;
        }
        
        map[x][y]='$';

        biggest++;   
        countCells(x, y+1);
        countCells(x, y-1);
        countCells(x+1, y);
        countCells(x-1, y);
        return ;
    }
	
	
	public static void printBoard(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        System.out.print(grid[i][j] + " ");
		    }
		     System.out.println();
		}
	}	
}
