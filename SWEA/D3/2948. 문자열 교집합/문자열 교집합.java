import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static HashSet<String> set;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; ++tc) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			set = new HashSet<String>();
			
			for (int n=0; n<N; ++n) 
				set.add(sc.next());
			
				
			for (int m=0;m<M; ++m) 
				set.add(sc.next());
			
			System.out.printf("#%d %d\n", tc, N+M-set.size());
		}
	}
}