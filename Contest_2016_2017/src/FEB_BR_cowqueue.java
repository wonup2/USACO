import java.io.*;
import java.util.*;

public class FEB_BR_cowqueue {

	public static void main(String[] args)  throws IOException {
		Scanner in = new Scanner(new FileReader("cowqueue.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		int n=in.nextInt();
		ArrayList<Pair1> cow = new ArrayList<Pair1>();
		for(int i=0; i<n; i++)
			cow.add(new Pair1(in.nextInt(), in.nextInt()));
		
		Collections.sort(cow);
		
		int arrive = 0;
		int done = 0;
		int answer = 0;
		
		for(int i=0; i<cow.size(); i++){
			arrive = cow.get(i).arrive;
			answer = cow.get(i).answer;
			
			if(done > arrive)
				done += answer;
			else 
				done = arrive + answer;
		}
		
		out.println(done);
		out.close();
		in.close();
	}	
}
class Pair1 implements Comparable<Pair1>{

	int arrive;
	int answer;
	Pair1(int c, int t){
		arrive = c;
		answer = t;
	}
	@Override
	public int compareTo(Pair1 that) {
		return this.arrive - that.arrive;  //if(this.arrive<that.arrive) return -1;
	}	
	public String toString(){
		return arrive+" "+answer;
	}
}