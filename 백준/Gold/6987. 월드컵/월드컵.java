import java.util.Scanner;

public class Main {
	static int[] wins, draws, loses;
	static int[][] match;
	static boolean invalid;
	static boolean found;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc=0; tc<4; ++tc) {
			wins = new int[6];
			draws = new int[6];
			loses = new int[6];
			match = new int[6][6];
			
			invalid = false;
			for (int i=0; i<6; ++i) {
				wins[i] =  sc.nextInt();
				draws[i] = sc.nextInt();
				loses[i] = sc.nextInt();
				
				if ((wins[i] + draws[i] + loses[i]) != 5)
					invalid = true;
			}
			
			if (invalid) {
				System.out.print(0+" ");
			} else {
				found = false;
				bt(0);
				System.out.print(found ? 1+" ": 0+" ");	
			}
		}
	}
	
	private static void bt(int n) {
		if (found) return;
		
		int i = n/6, j = n%6;
		
		if (n == 35) {
			if (check())
				found = true;
			return;
		}
		
		if (i<=j) {
			bt(n+1);
			return;
		}
		
		for (int r=-1; r<=1; ++r) {
			match[i][j] = r;
			match[j][i] = -r;
			bt(n+1);
		}
	}
	
	private static boolean check() {
		for (int i=0; i<6; ++i) {
			int w=0, d=-1, l=0;
			for (int j=0; j<6; ++j) {
				if (match[i][j] == 1) w++;
				if (match[i][j] == 0) d++;
				if (match[i][j] == -1) l++;
			}
			if (!(w==wins[i] && d==draws[i] && l==loses[i]))
				return false;
		}
		return true;
	}
	
}