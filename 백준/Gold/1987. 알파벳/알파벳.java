import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static final int[] delR = new int[] {-1, 1, 0, 0};
	static final int[] delC = new int[] {0, 0, -1, 1};
	static int R, C;
	static int[][] map;
	static int maxDist;
	static HashSet<String> visited;
	static boolean[] vis = new boolean[26];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		
		for (int r=0; r<R; r++) {
			char[] line = sc.next().toCharArray();
			for (int c=0; c<C; c++) {
				map[r][c] = line[c]-'A';
			}
		}
				
		maxDist = 0;
		visited = new HashSet<String>();
		// dfs(0, 0, new Stack<Character>());
		bt(0, 0, 0);
		System.out.println(maxDist);
	}
	
//	private static void dfs(int i, int j, Stack<Character> been) {
//		if (!inRange(i, j)) return;
//		if (been.contains(map[i][j])) return;
//		if (visited.contains(i+""+j)) return;
//		visited.add(i+""+j);
//		maxDist = Math.max(maxDist, been.size());
//		
//		for (int d=0; d<4; ++d) {
//			been.add(map[i][j]);
//			dfs(i+delR[d], j+delC[d], been);
//			been.pop();
//		}
//		
//	}
	
	private static void bt(int i, int j, int step) {
		maxDist = Math.max(maxDist, step);
		if (vis[map[i][j]]) return;
		
		for (int d=0; d<4; ++d) {
			int ni = i + delR[d];
			int nj = j + delC[d];
			if (! inRange(ni, nj)) continue;
			vis[map[i][j]] = true;
			bt(ni, nj, step+1);
			vis[map[i][j]] = false;
		}
	}
	
	private static boolean inArr(char c, char[] arr) {
		for (char chk : arr) {
			if (c == chk) return true;
		}
		return false;
	}
	
	private static boolean inRange(int i, int j) {
		return (0<=i && i<R && 0<=j && j<C);
	}

}