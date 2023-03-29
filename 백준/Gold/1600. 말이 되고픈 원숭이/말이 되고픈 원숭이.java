import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int W, H, K, MAX;
	static int[][] board;
	static PriorityQueue<int[]> q;	// [cost, i, j, k_left]
	static boolean[][][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		board = new int[H][W];
		for (int i=0; i<H; ++i)
			for (int j=0; j<W; ++j) 
				board[i][j] = sc.nextInt();
		
		System.out.println(findMinCost());

	}
	
	private static int findMinCost() {
		Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		};
		
		visited = new boolean[H][W][K+1];
		q = new PriorityQueue<>(comp);
		q.add(new int[] {0, 0, 0, K});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();	
			int cost = cur[0];
			int i = cur[1];
			int j = cur[2];
			int k_left = cur[3];
			
			if (i<0 || j<0 || i>=H || j>=W || k_left<0) continue;
			if (board[i][j] == 1) continue;
			if (i==H-1 && j==W-1) return cost; 
			if (visited[i][j][k_left]) continue;
			visited[i][j][k_left] = true;
			
			q.add(new int[] {cost+1, i-1, j, k_left});
			q.add(new int[] {cost+1, i+1, j, k_left});
			q.add(new int[] {cost+1, i, j-1, k_left});
			q.add(new int[] {cost+1, i, j+1, k_left});
			
			q.add(new int[] {cost+1, i+1, j+2, k_left-1});
			q.add(new int[] {cost+1, i+1, j-2, k_left-1});
			q.add(new int[] {cost+1, i-1, j+2, k_left-1});
			q.add(new int[] {cost+1, i-1, j-2, k_left-1});
			
			q.add(new int[] {cost+1, i+2, j+1, k_left-1});
			q.add(new int[] {cost+1, i+2, j-1, k_left-1});
			q.add(new int[] {cost+1, i-2, j+1, k_left-1});
			q.add(new int[] {cost+1, i-2, j-1, k_left-1});
			
			
		}
		return -1;
	}
	
}
