import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	final static int[] DELX = new int[] {-1, 1, 0, 0};
	final static int[] DELY = new int[] {0, 0, -1, 1};
	static int N;
	static int[][] map1, map2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map1 = new int[N][N];
		map2 = new int[N][N];
		for (int i=0; i<N; ++i) {
			char[] line = sc.next().toCharArray();
			for (int j=0; j<N; ++j) {
				map2[i][j] = map1[i][j] = line[j];
				if (map2[i][j] == 'R') map2[i][j] = 'G';
			}
		}
		
		
		System.out.println(clear(map1)+" "+clear(map2));

	}
	
	private static int clear(int[][] board) {
		int res = 0;
		for (int i=0; i<N; ++i) {
			for (int j=0; j<N; ++j) {
				if (board[i][j] == 0) continue;
				bfs(board, i, j, board[i][j]);
				res++;
			}
		}
		return res;
	}
	
	private static void bfs(int[][] board, int i, int j, int sym) {
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		HashSet<String> vis = new HashSet<String>();
		q.add(new int[] {i, j});
		while (!q.isEmpty()) {
			int[] n = q.pollFirst();
			int x = n[0];
			int y = n[1];
			if (board[x][y] == 0) continue;
			if (vis.contains(x+" "+y)) continue;
			vis.add(x+" "+y);
			
			board[x][y] = 0;
			
			for(int d=0; d<4; ++d) {
				int nx = x + DELX[d];
				int ny = y + DELY[d];
				if (!inRange(nx, ny)) continue;
				if (board[nx][ny] != sym) continue;
				q.add(new int[] {nx, ny});
			}
			
		}
	}
	
	private static boolean inRange(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
	
}