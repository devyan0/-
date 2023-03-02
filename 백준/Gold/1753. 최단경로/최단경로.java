import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V, E, start;
	static ArrayList<int[]>[] adj;
	static PriorityQueue<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		adj = new ArrayList[V+1];
		for (int i=0; i<=V; ++i)
			adj[i] = new ArrayList<int[]>();
		
		q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
			
		});
		
		for (int i=0; i<E; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			if (adj[u].add(new int[] {v, w})); // to, weight
		}
		
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V+1];
		
		q.add(new int[] {start, 0});
		
		while (!q.isEmpty()) {
			int[] info = q.poll();
			int cur = info[0];
			int uphere = info[1];
			
			if (visited[cur]) continue;
			if (distance[cur] < uphere) continue;
			visited[cur] = true;
			distance[cur] = uphere;
			
			for (int[] next: adj[cur]) {
				int nn = next[0];
				int cost = next[1];
				q.add(new int[] {nn, uphere+cost});
			}
			
		}
		
		for(int i=1; i<=V; ++i) {
			if (distance[i] < Integer.MAX_VALUE) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
			
		}
		
		
		
		
		
	}

}