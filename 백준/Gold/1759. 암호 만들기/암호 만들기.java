import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static boolean[] isVowel;
	static char[] cand;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		isVowel = new boolean[C];
		cand = new char[C];
		
		for (int i=0; i<C; ++i) 
			cand[i] = sc.next().charAt(0);
		
		Arrays.sort(cand);
		for (int i=0; i<C; ++i) {
			char c = cand[i];
			isVowel[i] = (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
		}
			
		visited = new boolean[C];
		bt(0, 0);
	}
	
	private static void bt(int i, int cnt) {
		if (cnt == L) {
			boolean hasVowel = false;
			int countTwo = 0;
			
			for (int j=0; j<C; ++j) {
				if (visited[j]) {
					if (isVowel[j]) hasVowel = true;
					else countTwo++;	
				}
			}
				
			
			if (hasVowel && 2<=countTwo) {
				for (int j=0; j<C; ++j) 
					if (visited[j])
						System.out.print(cand[j]);
				System.out.println();
			}
			return;
		}
		
		for (int j=i; j<C; ++j) {
			visited[j] = true;
			bt(j+1, cnt+1);
			visited[j] = false;
		}
	}
}