import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(recur(r, c, N));
		
	}
	
	private static int recur(int i, int j, int N) {
		if (N == 1) 
			return i*2 + j;
		
		int half = (int) Math.pow(2, N-1);
		int block = (int) Math.pow(4, N-1);

		return block * (2*(i/half) + j/half) + recur(i%half, j%half, N-1);	
	}

}