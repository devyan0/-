import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int N, start, last;
	static boolean[][] callable;
	static ArrayDeque<Integer> q;
	static HashSet<Integer> visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1; tc<=10; ++tc) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			callable = new boolean[101][101];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N/2; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				callable[from][to] = true;
			}
			
			q = new ArrayDeque<Integer>();
			q.add(start);
			visited = new HashSet<Integer>();
			
			last = start;
			while (!q.isEmpty()) {
				int qSize = q.size();
				last = 0;
				
				for (int i=0; i<qSize; ++i) {
					int cur = q.pollFirst();
					if (visited.contains(cur)) continue;
					visited.add(cur);
					last = Math.max(last, cur);
					
					for (int next=1; next<=100; ++next) 
						if (callable[cur][next]) {
							if (visited.contains(next)) continue;
							q.addLast(next);
						}
				}
			}
			
			System.out.printf("#%d %d\n", tc, last);
		}
	}
}
