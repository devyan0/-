import java.util.Scanner;

public class Solution {
	static int i1, j1, i2, j2, N;
	static int[] ci;
	static int[] cj;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; ++tc) {
			N = sc.nextInt();
			i1 = sc.nextInt();
			j1 = sc.nextInt();
			i2 = sc.nextInt();
			j2 = sc.nextInt();
			ci = new int[N];
			cj = new int[N];
			
			for (int i=0; i<N; ++i) {
				ci[i] = sc.nextInt();
				cj[i] = sc.nextInt();
			}
			
			visited = new boolean[N];
			result = Integer.MAX_VALUE;
			bt(0, 0, i1, j1);
			System.out.printf("#%d %d\n", tc, result);
		}
		
		sc.close();
	}
	
	private static void bt(int i, int temp, int previ, int prevj) {
		if (i == N) {
			int dist = Math.abs(previ-i2) + Math.abs(prevj-j2);
			result = Math.min(result, temp+dist);
			return;
		}
		
		for (int j=0; j<N; ++j) {
			if (visited[j]) continue;
			visited[j] = true;
			int dist = Math.abs(previ-ci[j]) + Math.abs(prevj-cj[j]);
			bt(i+1, temp+dist, ci[j], cj[j]);
			visited[j] = false;
		}
		
	}

}