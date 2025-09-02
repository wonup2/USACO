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
        		neg.add(t);
        	}
        	else {
        		pos.add(0);
        		neg.add(0);
        	}
        }

        ans = 0;
        posSolve(pos);        
        negSolve(neg);
        System.out.println(ans);
    }
    
    
    static void posSolve(ArrayList<Integer> pos) {
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
         boolean flag = false;
         
         for(int i=0; i<pos.size(); i++) {
         	
         	if(pos.get(i)==0 && flag) {
         		posSolve(temp);
         		flag = false;
         		temp = new ArrayList<Integer>();
         	}
         	if(pos.get(i)!=0) {
         		temp.add(pos.get(i));    
         		flag = true;
         	}
         }
         posSolve(temp);
    } 
    
    static void negSolve(ArrayList<Integer> neg) {
    	if(neg.size()==0) return;
    	
    	int max = neg.get(0);    	
    	for(int i=0; i<neg.size(); i++) max = Math.max(max, neg.get(i));
    	
    	ans+=Math.abs(max);
    	
    	for(int i=0; i<neg.size(); i++) neg.set(i, neg.get(i)-max);
    	
    	 ArrayList<Integer> temp = new ArrayList<Integer>();
         boolean flag = false;
         for(int i=0; i<neg.size(); i++) {         	
         	if(neg.get(i)==0 && flag) {
         		negSolve(temp);
         		flag = false;
         		temp = new ArrayList<Integer>();
         	}
         	if(neg.get(i)!=0) {
         		temp.add(neg.get(i));    
         		flag = true;
         	}
         }
         negSolve(temp);
    } 
}