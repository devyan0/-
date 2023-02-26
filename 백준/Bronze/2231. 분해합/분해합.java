import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int MAX = 1_000_000;
		for (int n=1; n<=MAX; ++n) {
			if (construct(n) == N) {
				System.out.println(n);
				return;
			}
		}
		System.out.println(0);
	}
	
	private static int construct(int con) {
		int res = con;
		while (0 < con) {
			res += con % 10;
			con /= 10;
		}
		return res;
	}
}
