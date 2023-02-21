import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] mat;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		mat = new int[N][N];
		
		for (int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			char[] line = st.nextToken().toCharArray();
			for (int j=0; j<N; ++j) 
				mat[i][j] = (line[j]-'0');
		}

		System.out.println(encode(0, 0, N));
	}
	
	private static String encode(int i, int j, int n) {
		StringBuilder st = new StringBuilder();
		boolean split = false;

		int prev = mat[i][j];
		for (int x=i; x<i+n && !split; x++)
			for (int y=j; y<j+n && !split; ++y)
				if (prev != mat[x][y]) split = true;
		
		if (split) {
			st.append(encode(i, j, n/2))
			.append(encode(i, j+n/2, n/2))
			.append(encode(i+n/2, j, n/2))
			.append(encode(i+n/2, j+n/2, n/2));
		} else
			return String.valueOf(prev);
		
		return "("+st.toString()+")";
	}

}