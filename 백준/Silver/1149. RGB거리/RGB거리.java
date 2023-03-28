import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] r = new int[N];
		int[] g = new int[N];
		int[] b = new int[N];
		
		// take input
		for (int i=0; i<N; ++i) {
			r[i] = sc.nextInt();
			g[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		// dp_c[k] := minimum cost to color upto k-th house, with color=c at k
		int[] dp_r = new int[N];
		int[] dp_g = new int[N];
		int[] dp_b = new int[N];
		
		// init dp base case
		dp_r[0] = r[0];
		dp_g[0] = g[0];
		dp_b[0] = b[0];
		
		// run dp status update
		for (int k=1; k<N; ++k) {
			dp_r[k] = r[k] + Math.min(dp_g[k-1], dp_b[k-1]);
			dp_g[k] = g[k] + Math.min(dp_r[k-1], dp_b[k-1]);
			dp_b[k] = b[k] + Math.min(dp_r[k-1], dp_g[k-1]);
		}
		
		System.out.println(Math.min(Math.min(dp_r[N-1], dp_g[N-1]), dp_b[N-1]));
	}

}
