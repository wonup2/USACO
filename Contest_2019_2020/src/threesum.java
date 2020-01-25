import java.io.*;
import java.util.*;

public class threesum{
	
	static final String probName="threesum";
	
	static BufferedReader br;
	static PrintWriter pw;
	static StringTokenizer st=new StringTokenizer("");
	static int N,Q;
	static HashMap<Integer,HashSet<Integer>>count=new HashMap<Integer,HashSet<Integer>>();
	static HashMap<Integer,HashMap<Integer,Integer>>queries=new HashMap<Integer,HashMap<Integer,Integer>>();
	
	static int readInt() throws IOException {
		while(!st.hasMoreTokens())readNextLine();
		return Integer.parseInt(st.nextToken());
	}
	
	static void readNextLine() throws IOException {
		st=new StringTokenizer(br.readLine());
	}
	
	static void addQ(int Ai,int Bi,int i) {
		if(!queries.containsKey(Ai))queries.put(Ai,new HashMap<Integer,Integer>());
		queries.get(Ai).put(Bi, i);
	}
	
	static void threeSum(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			int left=i+1;
			int right=nums.length-1;
			while(left<right) {
				if(-nums[i]-nums[left]==nums[right]) {
					for(int j:count.get(nums[i]))
						for(int k:count.get(nums[left]))
							for(int l:count.get(nums[right]))
								add(Math.min(j,N-1-Math.min(k,l)),Math.max(j,Math.max(k,l)));
					left++;
				}
				else if(-nums[i]-nums[left]>nums[right])
					left++;
				else
					right--;
			}
		}
	}
	
	static HashMap<Integer,HashMap<Integer,Long>>map=new HashMap<Integer,HashMap<Integer,Long>>();
	static void add(int r,int c) {
		for(int i=r;i<N;i+=(i+1)&-(i+1))
			for(int j=c;j<N;j+=(j+1)&-(j+1))
				addOne(i,j);
	}
	
	static long sum(int r,int c) {
		long ret=0;
		for(int i=r;i>=0;i-=(i+1)&-(i+1))
			for(int j=c;j>=0;j-=(j+1)&-(j+1))
				ret+=getVal(i,j);
		return ret;
	}
	
	static void addOne(int i,int j) {
		if(!map.containsKey(i))map.put(i,new HashMap<Integer,Long>());
		if(!map.get(i).containsKey(j))map.get(i).put(j, 0L);
		map.get(i).put(j, map.get(i).get(j)+1);
	}
	
	static long getVal(int i,int j) {
		return map.containsKey(i)&&map.get(i).containsKey(j)?map.get(i).get(j):0;
	}
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new FileReader("threesum.in"));
		
		N=readInt();
		Q=readInt();
		
		for(int i=0;i<N;i++) {
			int Ai=readInt();
			if(!count.containsKey(Ai))count.put(Ai, new HashSet<Integer>());
			count.get(Ai).add(i);
		}
		
		int[] A=new int[count.size()];
		int index=0;
		for(int i:count.keySet())
			A[index++]=i;
		
		threeSum(A);
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Q;i++)
			sb.append(sum(N-readInt(),readInt()-1)).append('\n');
		
		br.close();
		pw=new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
		pw.print(sb.toString());
		pw.close();
	}

}
