import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		int reachCnt=0;
		for (int r=0; r<R; ++r) 
			reachCnt += (connect(r, 0) ? 1 : 0);
		
		System.out.println(reachCnt);
	}
	
	private static boolean connect(int i, int j) {
		map[i][j] = 'x';
		
		if (j == C-1) 
			return true;

		boolean reach = false;		
		
		for (int di=-1; di<=1 && !reach; di++) 
			if (0 <= i+di && i+di <R && map[i+di][j+1] == '.') 
				reach = reach || connect(i+di, j+1);

		return reach;
	}
	

}