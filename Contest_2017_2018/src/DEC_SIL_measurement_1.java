import java.io.*;
import java.util.*;
//2017 December silver

public class DEC_SIL_measurement_1{
	public static void main(String[] args) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
								
		//milk - 우유생산량별 기록 ex) 10:100 --> 10갤런 생산한 소 - 100마리 
		//cow - 소들별로 생산량 기록 ex) 3:13 --> 3번 소는 13갤런 생산 
		TreeMap<Integer,Integer>milk = new TreeMap<Integer,Integer>();     
		HashMap<Integer,Integer>cow = new HashMap<Integer,Integer>();
		
		//초기화 
		int max = g;  				//최대 우유량, 즉 갱신될 보드의 기록 
		int milkBoard= g;  			//지금 보드에 있는 소가 가진 우유량. 지금 소가 보드에 있었나? 볼려고 
		int cowBoard = 1000000000;  //지금 보드에 불어있는 소 마리수 
		int ans = 0;  				//답이 모일 곳 
		
		TreeMap<Integer,memo>day = new TreeMap<Integer,memo>();
		for(int i = 0; i < n ; i++) {   //날짜별 소들 우유 생산량 정렬 
			st = new StringTokenizer(in.readLine());
			day.put(Integer.parseInt(st.nextToken()), new memo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collection<memo> val = day.values();  
		milk.put(g,1000000000); 
		
		for(memo v:val) {		
			//지금 보드에 몇마리 붙어 있나? 최대 우유량을 보유한 소(들) 
			cowBoard = milk.lastEntry().getValue();   
			
			//오늘의 소 등장, cow list 에 넣기 
			if(!cow.containsKey(v.id)) cow.put(v.id, g);
			
			//오늘의 소 움직이는거야. milk list change 
			int m = cow.get(v.id);			
			if(milk.get(m) == 1) milk.remove(m);
			else milk.put(m, milk.get(m)-1);			
			
			//오늘의 소가 현제 보드에 있었나? 오늘의 소와 관련된 기록들 모두 갱신 
			if(m == max) milkBoard = max + v.milk;

			//오늘의 소 우유갱신해서 cow list 에 넣기 
			m += v.milk;  
			cow.put(v.id,m); 
			
			//오늘의 소를 우유갱신해서 milk list에 집어 넣기 
			int t = 0;
			if(milk.containsKey(m))	t = milk.get(m);			
			milk.put(m, t + 1);

			max= milk.lastKey();    //오늘까지의 최대 생산량 
			
			//오늘의 소가 보드의 소와 일치하는가? 최대생산량을 가진 소 마리수가 바뀌었는가? 			 
			if(milk.lastEntry().getValue() != cowBoard || max!= milkBoard) {
				ans++; 	milkBoard = max;
			}
		}
		pw.println(ans);
		in.close();
		pw.close();
	}
}

class memo{
	int id;
	int milk;
	memo(int l,int r){
		id=l;
		milk=r;
	}
	public String toString(){
		return id+" "+milk;
	}
}
