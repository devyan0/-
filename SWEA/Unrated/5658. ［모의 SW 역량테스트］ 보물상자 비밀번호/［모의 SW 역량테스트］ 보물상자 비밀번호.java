import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int N, K;
	static String s;
	static HashSet<String> set;
	static ArrayList<Integer> nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1; tc<=T; ++tc) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			
			set = new HashSet<String>();
			nums = new ArrayList<Integer>();
			for (int i=0; i<N; ++i) {
				s = s.substring(1) + s.charAt(0);
				if (!set.contains(s.substring(0, N/4)))
					nums.add(Integer.parseInt(s.substring(0, N/4), 16));
				set.add(s.substring(0, N/4));
			}
			
			nums.sort(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			System.out.printf("#%d %d\n", tc,  nums.get(K-1));
			
			
		}
		
	}

}