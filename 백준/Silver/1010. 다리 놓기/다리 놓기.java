import java.util.Scanner;

public class Main {
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; ++tc) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			memo = new int[M+1][N+1];
			System.out.println(comb(M, N));
		}
	}
	
	private static int comb(int n, int r) {
		if (n==r || r== 0) return 1;
		if (memo[n][r] != 0) return memo[n][r];
		return memo[n][r] = (comb(n-1, r) + comb(n-1, r-1));
	}
	
}