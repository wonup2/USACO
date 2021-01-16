import java.util.*;
import java.io.*;
public class concTickets {
	static int n, m;
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
		public int nextInt() throws IOException 
	    { 
	        int ret = 0; 
	        byte c = read(); 
	        while (c <= ' ') 
	            c = read(); 
	        boolean neg = (c == '-'); 
	        if (neg) 
	            c = read(); 
	        do
	        { 
	            ret = ret * 10 + c - '0'; 
	        }  while ((c = read()) >= '0' && c <= '9'); 
	
	        if (neg) 
	            return -ret; 
	        return ret; 
	    }
		public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        }
    }
	public static void main(String[] args) throws IOException {
		TreeSet<Integer> nums = new TreeSet<Integer>();
		Reader s = new Reader();
		n = s.nextInt();
		m = (s.nextInt());
		int[] many = new int[100000*2 + 1];
		
		for(int i = 0; i < n; i++) {
			int temp = (s.nextInt());
			nums.add(temp);
			many[temp]++;
			
		}
		//System.out.println(Arrays.toString(many));
		//System.out.println(nums.size());
		for(int i = 0; i < m; i++) {
			int temp = (s.nextInt());
			if(nums.floor(temp) == null) {
				System.out.println("-1");
				continue;
			}
			int low = nums.floor(temp);
			nums.add(low);
			many[low]--;
			if (many[low] == 0 ){
				nums.remove(low);
			}
			System.out.println(low);
		}
		s.readLine();
	}
}
/*
5 3
5 3 7 8 5
4 8 3
*/