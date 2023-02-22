import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	final static int[] deli = new int[] {-1, 1, 0, 0};
	final static int[] delj = new int[] {0, 0, -1, 1};
	static int H, W, ci, cj, dir;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			
			for (int i=0; i<H; ++i) {
				map[i] = sc.next().toCharArray();
			}
			
			int[] tank = findTank();
			ci = tank[0];
			cj = tank[1];
			dir = tank[2];

			int N = sc.nextInt();
			char[] operations = sc.next().toCharArray();
			for (int i=0; i<N; ++i) {
				char op = operations[i];
				switch (op) {
				case 'U':
				case 'D':
				case 'L':
				case 'R':
					move(op);
					break;
				case 'S':
					shoot();
					break;
				}
				
				
			}
			
			System.out.printf("#%d ", tc);
			for (char[] line: map) {
				for (char e: line) {
					System.out.print(e);
				}
				System.out.println();
			}
			
		}
		
	}
	
	private static void printMap() {
		for (char[] line: map) {
			System.out.println(Arrays.toString(line));
		}
		System.out.println();
	}
	
	private static boolean valid(int i, int j) {
		return (inRange(i, j) && (map[i][j] == '.'));
	}
	
	private static boolean inRange(int i, int j) {
		return (0<=i && i<H && 0<=j && j<W);
	}
	
	private static void move(char op) {
		switch (op) {
		case 'U':
			map[ci][cj] = '^';
			dir = 0;
			break;
		case 'D':
			map[ci][cj] = 'v';
			dir = 1;
			break;
		case 'L':
			map[ci][cj] = '<';
			dir = 2;
			break;
		case 'R':
			map[ci][cj] = '>';
			dir = 3;
			break;
		}
		int ni = ci + deli[dir];
		int nj = cj + delj[dir];

		if (valid(ni, nj)) {
			map[ni][nj] = map[ci][cj];
			map[ci][cj] = '.';
			ci = ni;
			cj = nj;
		}
		
	}
	
	private static void shoot() {
		int ni = ci + deli[dir];
		int nj = cj + delj[dir];
		while (inRange(ni, nj)) {
			switch (map[ni][nj]) {
			case '#':
				return;
			case '*':
				map[ni][nj] = '.';
				return;
			}
			ni += deli[dir];
			nj += delj[dir];
		}
	}
	
	private static int[] findTank() {
		for (int i=0; i<H; ++i) 
			for (int j=0; j<W; ++j) 
				switch (map[i][j]) {
				case '^':
					return new int[] {i, j, 0};
				case 'v':
					return new int[] {i, j, 1};
				case '<':
					return new int[] {i, j, 2};
				case '>':
					return new int[] {i, j, 3};
				}
			
		
		return new int[0];
	}

}