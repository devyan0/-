import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, total_pop, min_diff;
	static int[] population;
	static int[] info;
	static boolean[][] graph;
	static ArrayDeque<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		total_pop = 0;
		min_diff = Integer.MAX_VALUE;
		population = new int[N+1];
		graph = new boolean[N+1][N+1];
		for (int i=1; i<=N; ++i) {
			population[i] = sc.nextInt();
			total_pop += population[i];
		}
		
		for (int i=1; i<=N; ++i) {
			int cnt = sc.nextInt();
			for (int j=0; j<cnt; ++j) {
				int next = sc.nextInt();
				graph[i][next] = true;
				graph[next][i] = true;
			}
		}
		
//		printGraph();
		
		q = new ArrayDeque<int[]>();
		info = new int[N+1];		// info[0] = cur, info[i] := include?
		bt(1);
		
		
		System.out.println(min_diff < Integer.MAX_VALUE ? min_diff : -1 );

	}
	
	private static int[] unionOne(int root) {
		int[] parent = new int[N+1];
		for (int i=1; i<=N; ++i) parent[i] = i;
		
		ArrayDeque<Integer> cq = new ArrayDeque<Integer>();
		cq.add(root);
		while (!cq.isEmpty()) {
			int n = cq.pollFirst();
			parent[n] = root;
			for (int to=1; to<=N; ++to) {
				if (!graph[n][to]) continue;
				if (info[to] == 0) continue;
				if (parent[to] == root) continue;
				cq.add(to);
			}
		}
		
		return parent;
	}
	
	private static int[] unionZero(int root) {
		int[] parent = new int[N+1];
		for (int i=1; i<=N; ++i) parent[i] = i;
		
		ArrayDeque<Integer> cq = new ArrayDeque<Integer>();
		cq.add(root);
		while (!cq.isEmpty()) {
			int n = cq.pollFirst();
			parent[n] = root;
			for (int to=1; to<=N; ++to) {
				if (!graph[n][to]) continue;
				if (info[to] == 1) continue;
				if (parent[to] == root) continue;
				cq.add(to);
			}
		}
		
		return parent;
	}
	
	private static void bt(int i) {
		if (i == N+1) {
			int in = findIn();
			int out = findOut();
			if (in == -1 || out==-1) return;
			int[] ui = unionOne(in);
			int[] uo = unionZero(out);
//			System.out.printf("info: %s | ui: %s | uo: %s\n", Arrays.toString(info), Arrays.toString(ui), Arrays.toString(uo));
			for (int j=1; j<=N; ++j) {
				if(ui[j] != in && uo[j] != out) return;
			}
			
//			System.out.printf("found %s (diff: %d)\n", Arrays.toString(info), get_diff(info));
			min_diff = Math.min(min_diff, get_diff(info));
			
//			if (isDisjoint(info)) {
//				System.out.printf("found %s (diff: %d)\n", Arrays.toString(info), get_diff(info));
//				min_diff = Math.min(min_diff, get_diff(info));
//			}
			return;
		}
		
		
		info[i] = 1;
		bt(i+1);
		info[i] = 0;
		bt(i+1);
		
	}
	
	private static int findIn() {
		for (int i=1; i<=N; ++i) 
			if (info[i] == 1) return i;
		return -1;
	}
	
	private static int findOut() {
		for (int i=1; i<=N; ++i)
			if(info[i] != 1) return i;
		return -1;
	}
	
	private static String getPath(int[] info) {
		String res = "";
		for (int i=1; i<=N; ++i) {
			if (info[i] == 1) res += (i+ " ");
		}
		return res;
	}
	private static void printGraph() {
		for (int i=1; i<=N; ++i) {
			for (int j=1; j<=N; ++j) {
				System.out.printf("%d ", graph[i][j] ? 1: 0);
			}
			System.out.println();
		}
	}
	
	private static boolean unionAll(int[] info1, int[] info2) {
		for (int i=1; i<=N; ++i) 
			if(info1[i] == 0 && info2[i] == 0) return false;
		return true;
	}
	
	private static boolean valid(int[] info) {
		int chk = -1;
		for (int i=1; i<=N; ++i) {
			if (info[i] == 1) {
				chk = i;
				break;
			}
		}
		if (chk == -1) return false;
		
		ArrayDeque<Integer> cq = new ArrayDeque<Integer>();
		cq.add(chk);
		
		int[] check_info = new int[N+1];
		while(!cq.isEmpty()) {
			int n = cq.pollFirst();
			check_info[n] = 1;
			for (int to=1; to<=N; ++to) {
				if (!graph[n][to]) continue;
				if (check_info[n] == 1) continue;
				cq.add(to);
			}
		}
		for (int i=1; i<=N; i++) {
			if (info[i]==1 && check_info[i]==0) return false;
		}
		
		return true;
	}
	
	private static boolean isDisjoint(int[] info) {
		if (!valid(info)) {
			System.out.printf("Not valid : %s\n", Arrays.toString(info));
			return false;
		}
		int out = -1;
		for (int i=1; i<=N; ++i) {
			if (info[i] == 0) {
				out = i;
				break;
			}
		}
		if (out == -1) return false;
		
		int[] others = new int[N+1];
		others[out] = 1;
		ArrayDeque<Integer> oq = new ArrayDeque<Integer>();
		oq.add(out);
		
		while (!oq.isEmpty()) {
			int cur = oq.pollFirst();
			if (unionAll(info, others)) return true;
			for (int to=1; to<=N; ++to) {
				if (!graph[cur][to]) continue;
				if (info[to] == 1) continue;
				if (others[to] == 1) continue;
				
				others[to] = 1;
				oq.add(to);
			}
		}
		
		return false;
		
	}
	
	private static int[] addPath(int[] info, int add) {
		int[] next = new int[11];
		for (int i=0; i<=N; ++i)
			next[i] = info[i];
		next[add] = 1;
		next[0] = add;
		return next;
	}
	
	private static int get_diff(int[] info) {
		int pop = 0; 
		for (int i=1; i<=N; ++i) {
			if (info[i] == 1) pop += population[i];
		}
		// return -1 if pop == total_pop to remove the case of select all
		if (pop == total_pop) return -1;
		return Math.abs(total_pop - 2*pop);
	}
	
	
}