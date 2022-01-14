import java.io.*;
import java.util.*;
public class US_BR_ttt {
	static Scanner in;
	static PrintWriter out;
	static char a[][];
	static int one, two;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new FileReader("tttt.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        init();
        solve();        
        out.close();
        in.close();       
	}
	static void init() throws NumberFormatException, IOException {
		a = new char[3][];
				
		for(int i=0; i<3; i++)	
			a[i] = in.next().toCharArray();	
		
	}
	
	static void solve() {
		TreeSet<Character>[] team = new TreeSet[8];
		for(int i=0; i<8; i++)
			team[i] = new TreeSet<Character>();
	
		team[0].add(a[0][0]);team[0].add(a[1][0]);team[0].add(a[2][0]);
		team[1].add(a[0][1]);team[1].add(a[1][1]);team[1].add(a[2][1]);
		team[2].add(a[0][2]);team[2].add(a[1][2]);team[2].add(a[2][2]);
		
		team[3].add(a[0][0]);team[3].add(a[0][1]);team[3].add(a[0][2]);
		team[4].add(a[1][0]);team[4].add(a[1][1]);team[4].add(a[1][2]);
		team[5].add(a[2][0]);team[5].add(a[2][1]);team[5].add(a[2][2]);
		
		team[6].add(a[0][0]);team[6].add(a[1][1]);team[6].add(a[2][2]);
		team[7].add(a[0][2]);team[7].add(a[1][1]);team[7].add(a[2][0]);
		
		HashSet<Character> one = new HashSet<Character>();
		HashSet<String> two = new HashSet<String>();

		for(int i=0; i<8; i++) {
			if(team[i].size()==1) one.add(team[i].first());
			else if(team[i].size()==2) two.add(team[i].first()+""+team[i].last());
		}
		
		out.println(one.size()+"\n"+two.size());
	}
	
}