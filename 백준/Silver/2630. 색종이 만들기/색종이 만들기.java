import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new char[N][N];
		for (int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; ++j)
				board[i][j] = st.nextToken().charAt(0);
		}
			
		int[] res = bt(0, 0, N);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	
	private static int[] bt(int x, int y, int n) {
		if (n == 1) 
			return board[x][y] == '1' ? new int[] {0, 1} : new int[] {1, 0};
		
		int cnt=0;
		for (int i=x; i<x+n; ++i)
			for (int j=y; j<y+n; ++j)
				if (board[i][j] == '1') cnt++;
				else if (board[i][j] == '0') continue;
		if (cnt==0) 
			return new int[] {1, 0};
		
		if (cnt==n*n) 
			return new int[] {0, 1};
				
		int[] upperLeft = bt(x, y, n/2);
		int[] upperRight = bt(x, y+n/2, n/2);
		int[] lowerLeft = bt(x+n/2, y, n/2);
		int[] lowerRight = bt(x+n/2, y+n/2, n/2);
		
		return new int[] {
				upperLeft[0]+upperRight[0]+lowerLeft[0]+lowerRight[0],
				upperLeft[1]+upperRight[1]+lowerLeft[1]+lowerRight[1]
		};
	}
}
