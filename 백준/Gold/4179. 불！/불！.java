import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	static int r, c, sx, sy, answer = Integer.MAX_VALUE;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] miro;
	static Queue<int[]> fire = new ArrayDeque<>();
	static boolean[][] visitedJ;
	static int[][] visitedF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		miro = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			miro[i] = str.toCharArray();
			for (int j = 0; j < c; j++) {
				if (miro[i][j] == 'J') {
					sx = i;
					sy = j;
				}
				if (miro[i][j] == 'F') {
					fire.add(new int[] { i, j, 0 });
				}

			}
		}

		// 중요한건 불이 붙을 곳으로 가지 못해
		// 즉 불이 먼저.
		visitedF = new int[r][c];
		for (int i = 0; i < r; i++)
			Arrays.fill(visitedF[i], 9999);

		visitedJ = new boolean[r][c];
		
		if(!fire.isEmpty()) {
			burn();
		}
		solution();
		
		if(answer == Integer.MAX_VALUE)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(answer);
		
	}

	private static void burn() {
		int[] f = fire.peek();
		visitedF[f[0]][f[1]] = 0;

		while (!fire.isEmpty()) {
			int qsize = fire.size();
			for (int q = 0; q < qsize; q++) {
				int[] cur = fire.poll();
				int sr = cur[0];
				int sc = cur[1];
				int cnt = cur[2];

				for (int d = 0; d < 4; d++) {
					int nr = sr + dr[d];
					int nc = sc + dc[d];
					if (chkRange(nr, nc))
						continue;
					if (visitedF[nr][nc] != 9999)
						continue;
					if (miro[nr][nc] == '#')
						continue;
					visitedF[nr][nc] = cnt + 1;
					fire.add(new int[] { nr, nc, cnt + 1 });
				}
			}
		}
	}

	private static void solution() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { sx, sy, 0 });
		visitedJ[sx][sy] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int sr = cur[0];
			int sc = cur[1];
			int cnt = cur[2];
			for (int d = 0; d < 4; d++) {
				int nr = sr + dr[d];
				int nc = sc + dc[d];
				if (chkRange(nr, nc)) {
					answer = Math.min(answer, cnt + 1);
					continue;
				}
				if (visitedJ[nr][nc])
					continue;
				if (miro[nr][nc] == '#')
					continue;
				if (cnt + 1 >= visitedF[nr][nc])
					continue;
				visitedJ[nr][nc] = true;
				q.add(new int[] { nr, nc, cnt + 1 });
			}
		}

	}

	private static boolean chkRange(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= r || nc >= c ? true : false;
	}
}
