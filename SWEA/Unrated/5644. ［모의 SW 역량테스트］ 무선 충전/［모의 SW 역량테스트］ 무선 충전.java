import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	final static int[] deli = new int[] {0, -1, 0, 1, 0};
	final static int[] delj = new int[] {0, 0, 1, 0, -1};
	static int[] move1, move2;
	static ArrayList<int[]> chargers;
	static int M, A, C, P;
	static int i1, j1, i2, j2, result;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; ++tc) {
			M = sc.nextInt();
			A = sc.nextInt();
			
			move1 = new int[M];
			move2 = new int[M];
			for (int i=0; i<M; ++i) move1[i] = sc.nextInt();
			for (int i=0; i<M; ++i) move2[i] = sc.nextInt();
			
			chargers = new ArrayList<int[]>();
			for (int i=0; i<A; ++i) { 
				int cj = sc.nextInt();
				int ci = sc.nextInt();
				int far = sc.nextInt();
				int pow = sc.nextInt();
				chargers.add(new int[] {ci, cj, far, pow});
			}
			chargers.sort((int[] a, int[] b) -> b[3]-a[3]);
			
			result = 0;
			i1=1; j1=1; i2=10; j2=10;
			
			doCharge();
			for(int m=0; m<M; ++m) {
				move(m);
				doCharge();
			}			
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}
	
	private static void move(int m) {
		int dir1 = move1[m];
		i1 += deli[dir1];
		j1 += delj[dir1];
		
		int dir2 = move2[m];
		i2 += deli[dir2];
		j2 += delj[dir2];
	}
	
	private static void doCharge() {
		boolean yet1A=true, yet2A=true, yet1B=true, yet2B=true;
		int score1 = 0, score2 = 0;
		for (int i=0; i<A; ++i) {
			int[] bc = chargers.get(i);
			boolean in1 = include(i1, j1, bc);
			boolean in2 = include(i2, j2, bc);
			
			if (in1 && yet1A) {
				score1 += bc[3];
				yet1A = false;
			} else if (in2 && yet2A) {
				score1 += bc[3];
				yet2A = false;
			}
			
			if (in2 && yet2B) {
				score2 += bc[3];
				yet2B = false;
			}
			else if (in1 && yet1B) {
				score2 += bc[3];
				yet1B = false;
			} 
		}
		result += Math.max(score1, score2);
	}
	
	private static boolean inRange(int i, int j) {
		return (0<=i && i<10 && 0<=j && j<10);
	}
	
	private static boolean include(int i, int j, int[] bc) {
		int dist = Math.abs(i-bc[0]) + Math.abs(j-bc[1]);
		return dist <= bc[2];
	}

}