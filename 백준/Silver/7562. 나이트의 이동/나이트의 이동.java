import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[][] map;
	static int answer, n;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < c; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int resultX = Integer.parseInt(st.nextToken());
			int resultY = Integer.parseInt(st.nextToken());

			answer = 999;
			bfs(startX, startY, resultX, resultY);

			System.out.println(answer);
		}

	}

	private static void bfs(int sx, int sy, int rx, int ry) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { sx, sy, 0 });
		visited[sx][sy] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			if (r == rx && c == ry) {
				answer = Math.min(answer, cnt);
				continue;
			}
			for (int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= n || nc >= n)
					continue;
				if (visited[nr][nc])
					continue;
				q.offer(new int[] { nr, nc, cnt + 1 });
				visited[nr][nc] = true;
			}

		}

	}

}
