public class Permutation_for {

	public static void main(String[] args) {
	
		for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			if(j == i) continue;			
			for(int k = 0; k < 4; k++) {
				if(k == i || k == j) continue;							
				for(int l = 0; l < 4; l++) {
					if(l == i || l == j || l == k) continue;
					System.out.println("" + i + j + k + l);
				}
			}
		}
		}
						
	}
}

