import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<int[]> virus;
	static ArrayList<int[]> pos;
	static int[] idx;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		virus = new ArrayList<>();
		pos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 2)
					virus.add(new int[] { i, j });
				if (x == 0)
					pos.add(new int[] { i, j });
				arr[i][j] = x;
			}
		}

		idx = new int[3];
		solution(0, 0);

		System.out.println(ans);

	}

	public static void solution(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) { // 벽만들기
				int[] cur = pos.get(idx[i]);
				arr[cur[0]][cur[1]] = 1;
			}
			
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) 
				temp[i] = arr[i].clone();
			
			Queue<int[]> v = new ArrayDeque<>();
			for (int i = 0; i < virus.size(); i++) 
				v.add(virus.get(i));
			
			spread(v, temp);
			ans = Math.max(safeZone(temp), ans);

			for (int i = 0; i < 3; i++) { // 벽부시기
				int[] cur = pos.get(idx[i]);
				arr[cur[0]][cur[1]] = 0;
			}
			
			return;
		}

		for (int i = start; i < pos.size(); i++) {
			idx[cnt] = i;
			solution(i + 1, cnt + 1);
		}
	}

	public static int safeZone(int[][] temp) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}

	public static void spread(Queue<int[]> v, int[][] temp) {
		while (!v.isEmpty()) {
			int[] cur = v.poll();
			int r = cur[0];
			int c = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= N || nc >= M || nr < 0 || nc < 0)
					continue;
				if (temp[nr][nc] == 1 || temp[nr][nc] == 2)
					continue;
				temp[nr][nc] = 2;
				v.add(new int[] { nr, nc });
			}
		}
	}

}
