import java.util.Scanner;

public class Main {
	static int N, target, res;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		
		nums = new int[N];
		for (int i=0; i<N; ++i) 
			nums[i] = sc.nextInt();
		
		res = 0;
		bt(0, 0, 0);
		System.out.println(res);
	}
	
	private static void bt(int i, int cnt, int temp) {
		if (cnt == 3) {
			if (temp <= target) {
				res = Math.max(res, temp);
			}
			return;
		}
		for (int j=i; j<nums.length; ++j) {
			bt(j+1, cnt+1, temp+nums[j]);
		}
	}

}
