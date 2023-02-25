import java.util.Scanner;

public class Main {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; ++tc) {
			String s = sc.next();
			System.out.print(isPalindrome(s)+" ");
			System.out.println(cnt);
		}

	}
	
	private static int isPalindrome(String s) {
		cnt = 0;
		return recursion(s, 0, s.length()-1);
	}
	
	private static int recursion(String s, int l, int r) {
		cnt++;
		if (l >= r) return 1;
		else if (s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}

}