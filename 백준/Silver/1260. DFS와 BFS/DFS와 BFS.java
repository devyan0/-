import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int N, M, start;
	static int[][] map;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for (int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = map[n2][n1] = 1;
		}
		
		vis = new boolean[N+1];
		dfs(start);
		
		System.out.println();
		
		vis = new boolean[N+1];
		bfs(start);
		
		
	}
	
	private static void bfs(int node) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(node);
		
		while (!q.isEmpty()) {
			int n = q.pollFirst();
			if (visited.contains(n)) continue;
			
			visited.add(n);
			System.out.print(n+" ");
			for (int next=1; next<=N; ++next) 
				if (map[n][next] == 1) 
					q.addLast(next);
		}
	}
	
	private static void dfs(int node) {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(node);
		
		while (!q.isEmpty()) {
			int n = q.pollLast();
			if (visited.contains(n)) continue;
			
			visited.add(n);
			System.out.print(n+" ");
			for (int next=N; 1<=next; --next) 
				if (map[n][next] == 1) 
					q.addLast(next);
		}
	}

}