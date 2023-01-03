import java.util.*;
import java.io.*;

public class FEB_BR_yearOftheCow {

	static Scanner in;
	static String data[] = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", 
							"Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"}; 
	static int n;
	static String s;
	static HashMap<String, Integer> m;
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt(); in.nextLine();	
		m = new HashMap<String, Integer>();		
		for(int i=0; i<12; i++) m.put(data[i], i);	

	}
	
	static void solve() {
		
		HashMap<String, pair> cow = new HashMap<String, pair>();		
		cow.put("Bessie", new pair("Ox", 0));
		
		for(int i=0; i<n; i++) {
						
			String name1 = in.next(); in.next(); in.next();		//Mildred
			String act = in.next(); 							//previous
			String animal = in.next(); in.next(); in.next(); 	//Dragon
			String name2 = in.next();							//Bessie
			
			int a = m.get(cow.get(name2).animal); 				//Ox
			int b = m.get(animal);								//Dragon
			int c = 0;

			if(act.equals("previous")) {
				if(b>=a) c = (b-a) - 12;
				else c = b-a;
			}
			else {
				if(b<=a) c= (b-a) + 12;
				else c=b-a;
			}
		
			int d = cow.get(name2).ind + c;
			cow.put(name1, new pair(animal, d));
		}
		
		System.out.println(Math.abs(cow.get("Elsie").ind));
	}	
	
	static class pair {
		String animal;
		int ind;
		
		pair(String y, int i){
			animal = y;
			ind = i;
		}
		
		public String toString() {
			return animal+" "+ ind;
		}
	}
}


/*
4
Mildred born in previous Dragon year from Bessie
Gretta born in previous Monkey year from Mildred
Elsie born in next Ox year from Gretta
Paulina born in next Dog year from Bessie

*/