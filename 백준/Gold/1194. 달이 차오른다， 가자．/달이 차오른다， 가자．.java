import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        char[][] maze = new char[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == '0') {
                    res = Math.min(res, bfs(i, j, 0, N, M, maze));
                }
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static int bfs(int si, int sj, int sKeys, int N, int M, char[][] maze) {
        int res = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(new int[]{si, sj, sKeys, 0});

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int i = state[0], j = state[1], keys = state[2], cost = state[3];
            String hash = i + "," + j + "," + keys;

            if (vis.contains(hash)) continue;
            vis.add(hash);

            if (cost >= res) continue;

            if (i < 0 || i >= N || j < 0 || j >= M || maze[i][j] == '#') continue;

            char cur = maze[i][j];
            if (cur == '1') {
                res = Math.min(res, cost);
                continue;
            }

            if (cur >= 'A' && cur <= 'F') {
                int s = cur - 'A';
                if ((keys & (1 << s)) == 0) continue;
            }

            if (cur >= 'a' && cur <= 'f') {
                int s = cur - 'a';
                keys |= (1 << s);
            }

            for (int[] direction : directions) {
                int ni = i + direction[0], nj = j + direction[1];
                String nextHash = ni + "," + nj + "," + keys;
                if (!vis.contains(nextHash)) {
                    q.add(new int[]{ni, nj, keys, cost + 1});
                }
            }
        }

        return res;
    }
}
