import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	final static int[] DELI = {-1, 0, 1, 0};	// u r d l
	final static int[] DELJ = {0, 1, 0, -1};
	static int N, M;
	static int[][] map;
	static ArrayList<int[]> cctv;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctv = new ArrayList<int[]>();
		for (int i=0; i<N; ++i)
			for (int j=0; j<M; ++j) {
				map[i][j] = sc.nextInt();
				if (1<= map[i][j] && map[i][j] <= 5)
					cctv.add(new int[] {i, j, map[i][j]});
			}
		
		
		result = Integer.MAX_VALUE;
		bt(0);
		System.out.println(result);
		

	}
	
	private static void bt(int cnt) {
		if (cnt == cctv.size()) {
			result = Math.min(result, getHidden());
			return;
		}
		
		ArrayList<int[]> rec;
		int[] d = cctv.get(cnt);
		int rotCnt = 4;
		if (d[2] == 2) rotCnt = 2;
		if (d[2] == 5) rotCnt = 1;
		for (int rot=0; rot<rotCnt; rot++) {
			rec = sim(d, rot);
			bt(cnt+1);
			unsim(rec);
		}
		
	}
	
	private static int getHidden() {
		int cnt = 0;
		for (int i=0; i<N; ++i)
			for (int j=0; j<M; ++j)
				if (map[i][j]==0) cnt++;
		return cnt;
	}
	
	private static ArrayList<int[]> sim(int[] device, int dir) {
		int x = device[0];
		int y = device[1];
		
		ArrayList<int[]> record = new ArrayList<int[]>();

		switch (device[2]) { // dir: up(0), right(1) down(2) left(3)
		case 1:
			record.addAll(check_dir(x, y, dir));
			break;
		case 2:
			record.addAll(check_dir(x, y, dir));
			record.addAll(check_dir(x, y, dir+2));
			break;
		case 3:
			record.addAll(check_dir(x, y, dir));
			record.addAll(check_dir(x, y, dir+1));
			break;
		case 4:
			record.addAll(check_dir(x, y, dir));
			record.addAll(check_dir(x, y, dir+1));
			record.addAll(check_dir(x, y, dir+2));
			break;
		case 5:
			record.addAll(check_dir(x, y, dir));
			record.addAll(check_dir(x, y, dir+1));
			record.addAll(check_dir(x, y, dir+2));
			record.addAll(check_dir(x, y, dir+3));
			break;
		}
		return record;
	}
	
	private static ArrayList<int[]> check_dir(int i, int j, int dir) {
		ArrayList<int[]> rec = new ArrayList<int[]>();
		dir = dir % 4;
		
		int ni = i + DELI[dir];
		int nj = j + DELJ[dir];
		while (inRange(ni, nj) && map[ni][nj] != 6) {
			int cur = map[ni][nj];
			if (cur == 0) {
				map[ni][nj] = -1;
				rec.add(new int[] {ni, nj});
			}
				
			ni = ni + DELI[dir];
			nj = nj + DELJ[dir];	
		}
		return rec;
	}
	
	private static void unsim(ArrayList<int[]> record) {
		for (int[] r: record) {
			int x = r[0];
			int y = r[1];
			map[x][y] = 0;
		}
	}
	
	private static boolean inRange(int i, int j) {
		return 0<=i && i<N && 0<=j && j<M;
	}
	
}