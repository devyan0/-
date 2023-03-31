import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2636
public class Main {
	static int H, W;
	static int[][] board;
	static ArrayDeque<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		board = new int[H][W]; 
		
		for (int i=0; i<H; ++i)
			for (int j=0; j<W; ++j)
				board[i][j] = sc.nextInt();
		
		int prev=0, cur=-1, iterCnt=0;
		while (cur != 0) {
			prev = cur;
			cur = bfs();
			iterCnt++;
		}
		
		System.out.println(iterCnt-1);
		System.out.println(prev);
		

	}
	
	private static int bfs() {
		q = initQ();
		HashSet<String> visited = new HashSet<String>();
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			if (i<0 || j<0 || i>H-1 || j>W-1) continue;
			
			String key = i + " " + j;
			if (visited.contains(key)) continue;
			visited.add(key);
			
			if (board[i][j] == 1) {
				board[i][j] = 0;
				cnt += 1;
			} else {
				q.add(new int[] {i+1, j});
				q.add(new int[] {i-1, j});
				q.add(new int[] {i, j-1});
				q.add(new int[] {i, j+1});
			}
			
		}
		return cnt;
	}
	
	private static ArrayDeque<int[]> initQ() {
		q = new ArrayDeque<int[]>();
		for (int i=0; i<H; ++i) {
			q.add(new int[] {i, 0});
			q.add(new int[] {i, W-1});
		}
		for (int j=0; j<W; ++j) {
			q.add(new int[] {0, j});
			q.add(new int[] {H-1, j});
		}
		return q;
	}

}
