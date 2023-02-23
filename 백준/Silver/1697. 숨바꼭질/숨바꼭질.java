import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if (K <= N)
			System.out.println(N-K);
		else
			System.out.println(bfs(N, K));
		
	}
	
	private static int bfs(int node, int target) {
		int dist = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(node);
		
		while (!q.isEmpty()) {
			int qs = q.size();
			for (int i=0; i<qs; ++i) {
				int n = q.pollFirst();
				if (visited.contains(n)) continue;
				visited.add(n);
				if (2*target < n) continue;
				if (n == target) return dist;
				
				q.addLast(n*2);
				q.addLast(n+1);
				if (0<n) q.addLast(n-1);
			}
			dist++;
		}
		
		return -1;
	}

}