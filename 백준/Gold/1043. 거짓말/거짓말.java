import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] p, r;
	static int[] ppnum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		make();
		
		
		int king = 0;
		
		st = new StringTokenizer(br.readLine());
		int tp = Integer.parseInt(st.nextToken());
		if (tp >= 1) {
			int a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < tp - 1; i++) {
				int c = Integer.parseInt(st.nextToken());
				union(a,c);
			}
			king = a;
		} else if(tp == 0) {
			System.out.println(M);
			return;
		}

		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			arr.get(i).add(b);
			for (int j = 0; j < a-1; j++) {
				int c= Integer.parseInt(st.nextToken());
				arr.get(i).add(c);
				union(b,c);
			}
		}
		
		int k = find(king);
		int ans = M;
		for (int i = 0; i < M; i++) {
			for(int v : arr.get(i)) {
				if (k == find(v)) {
					ans--;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return;
		}

		if (r[x] < r[y]) {
			p[x] = y;
			r[y]++;
		} else {
			p[y] = x;
			r[x]++;
		}
		return;
	}

	private static int find(int x) {
		if (x == p[x]) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	private static void make() {
		p = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			p[i] = i;
		}
		r = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			r[i] = 1;
		}
	}
}
