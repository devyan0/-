import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int N, M;
	static HashMap<Integer, ArrayList<Integer>> map;
	static HashSet<Integer> visited;
	static boolean done;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i=0; i<M; ++i) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			if (!map.containsKey(n1))
				map.put(n1, new ArrayList<Integer>());
			if (!map.containsKey(n2))
				map.put(n2, new ArrayList<Integer>());
			
			map.get(n1).add(n2);
			map.get(n2).add(n1);
		}
		
		int max = 0;

//		visited = new HashSet<Integer>();
		done = false;
		for (int i=0; i<N && !done; ++i) {
			visited = new HashSet<Integer>();
			bt(i, 1);
//			visited.add(i);
//			if (5 <= dfs(i)) done = true;
//			done = 5 <= dfs(i);
//			visited = new HashSet<Integer>();
//			System.out.println(i+" -> "+dfs(i));
		}
		
		System.out.println(done ? 1 : 0);
	}
	
	private static void bt(int i, int cnt) {
		if (6 <= cnt) {
			done = true;
			return;
		}
		
		ArrayList<Integer> dist = new ArrayList<Integer>();
		if (!map.containsKey(i)) return;
		for (int next: map.get(i)) {
			if (visited.contains(next)) continue;
			visited.add(next);
			bt(next, cnt+1);
			visited.remove(next);
			if (done) return;
		}
		
	}
	
	private static int dfs(int node) {
//		System.out.printf("now in %d\n", node);
		int dist1=0, dist2=0;
		int cnt = 0;
//		if (visited.contains(node)) {
//			return 0;
//		}
		if (!map.containsKey(node)) return 1;
		for (int next: map.get(node)) {
			if (visited.contains(next)) continue;
			visited.add(next);
			int temp = dfs(next);
			visited.remove(next);
//			if (dist1 < temp) {
//				dist2 = dist1;
//				dist1 = temp;
//			}
//			else if (dist2 < temp) dist2 = temp;
			cnt = Math.max(cnt, temp);
		}
//		System.out.println(dist1+", "+dist2+": node "+node+" returns "+ (dist1+dist2+1));
//		return dist1 + dist2 + 1;
//		System.out.printf("node %d returns %d\n", node, cnt+1);
		return cnt+1;
	}
}