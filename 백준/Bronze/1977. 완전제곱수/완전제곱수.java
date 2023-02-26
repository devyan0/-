import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int i = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0; 
		while (i*i <= N) {
			if (i*i < M) {
				i++;
				continue;
			}
			if (min == Integer.MAX_VALUE) min = i*i;
			sum += i*i;
			i++;
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);	
		}
    }
}
