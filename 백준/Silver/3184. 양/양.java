import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, wolf, sheep, wCnt, sCnt;
	static char[][] garden;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		garden = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			garden[i] = str.toCharArray();
		}

		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				wCnt = 0;
				sCnt = 0;

				if (garden[i][j] == '#')
					continue;
				if (visited[i][j])
					continue;

				solution(i, j);

				if (wCnt >= sCnt) {
					wolf += wCnt;
				} else {
					sheep += sCnt;
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	private static void solution(int sx, int sy) {
		visited[sx][sy] = true;
		if (garden[sx][sy] == 'v')
			wCnt++;
		else if (garden[sx][sy] == 'o')
			sCnt++;

		for (int d = 0; d < 4; d++) {
			int nr = sx + dr[d];
			int nc = sy + dc[d];
			if (nr < 0 || nc < 0 || nr >= r || nc >= c)
				continue;
			if (visited[nr][nc])
				continue;
			if (garden[nr][nc] == '#')
				continue;
			solution(nr, nc);
		}

	}

}
