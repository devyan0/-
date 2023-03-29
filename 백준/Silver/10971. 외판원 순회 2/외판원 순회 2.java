import java.util.Scanner;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	static int N, res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[N][N];
		
		for (int i=0; i<N; ++i)
			for (int j=0; j<N; ++j) {
				graph[i][j] = sc.nextInt();
			}
		
		visited = new boolean[N];
		res = Integer.MAX_VALUE;
		
		bt(0, 0, 0);
		
		System.out.println(res);
		
	}
	
	private static void bt(int depth, int cur, int pathSum) {

		if (depth == N-1) {
			if (graph[cur][0] != 0)
				res = Math.min(res, pathSum+graph[cur][0]);
			return;
		}

		for (int next=0; next<N; ++next) {
			if (visited[next]) continue;
			if (graph[cur][next] == 0) continue;
			visited[cur] = true;
			bt(depth+1, next, pathSum+graph[cur][next]);
			visited[cur] = false;
		}
		
	}
}