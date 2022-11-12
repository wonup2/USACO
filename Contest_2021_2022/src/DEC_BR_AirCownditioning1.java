import java.util.*;
import java.io.*;

public class DEC_BR_AirCownditioning1 {
    static Scanner in;
    static int n, a[], ans;
    static ArrayList<Integer> d, t;
    public static void main(String[] args)throws IOException {
        in = new Scanner(System.in);        
        init();
    }
    
    static void init() throws IOException {
    	 
        n = in.nextInt();
        a = new int[n];        
        for(int i=0; i<n; i++) a[i] = in.nextInt();
        
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++) {
        	int t = a[i]-in.nextInt();
        	if(t>0) {
        		pos.add(t);
        		neg.add(0);
        	}
        	else if(t<0) {
        		pos.add(0);
        		neg.add(t*-1);
        	}
        	else {
        		pos.add(0);
        		neg.add(0);
        	}
        }

        ans = 0;
        
        System.out.println(pos);
        System.out.println(neg);

        solve(pos);        
        solve(neg);
        System.out.println(ans);
    }
    
    
    static void solve(ArrayList<Integer> pos) {
    	
    	System.out.println(pos);
    	//step 0
    	if(pos.size()==0) return;
    	
    	//step 1 
    	int min = pos.get(0);    	
    	for(int i=0; i<pos.size(); i++) min = Math.min(min, pos.get(i));
    	
    	//step 2 
    	ans+=min;
    	
    	//step 3 
    	for(int i=0; i<pos.size(); i++) pos.set(i, pos.get(i)-min);
    	
    	//step 4
    	 ArrayList<Integer> temp = new ArrayList<Integer>();
         boolean flag = false;  //<---  시간 절약
         
         for(int i=0; i<pos.size(); i++) {
         	
         	if(pos.get(i)==0 && flag) {
         		solve(temp);
         		flag = false;
         		temp = new ArrayList<Integer>();
         	}
         	if(pos.get(i)!=0) {
         		temp.add(pos.get(i));    
         		flag = true;
         	}
         }
         solve(temp);
    }     
}