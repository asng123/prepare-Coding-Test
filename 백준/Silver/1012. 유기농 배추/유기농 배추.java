import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			// M : 가로길이 N : 세로길이 K : 배추가 심어져있는 위치의 개수
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}

			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j]&&arr[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}

			sb.append(cnt);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (check(ni, nj) && !visited[ni][nj] && arr[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}

	}

	private static boolean check(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}

}
