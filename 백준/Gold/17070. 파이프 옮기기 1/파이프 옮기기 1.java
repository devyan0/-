import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] grid = new int[N][N];
		for (int i=0; i<N; ++i)
			for (int j=0; j<N; ++j)
				grid[i][j] = sc.nextInt();
		
		int[][][] dp = new int[N][N][3];	// right, diagonal, down
		for (int i=1; i<N; ++i) {
			if (grid[0][i]==1) break;
			dp[0][i][0] = 1;
		}
		
		for (int i=1; i<N; ++i) {
			for (int j=1; j<N; ++j) {
				if (grid[i][j] == 1) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];	
				dp[i][j][2] = dp[i-1][j][2] + dp[i-1][j][1];
				if (grid[i-1][j] == 0 && grid[i][j-1] == 0)
					dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}

}
