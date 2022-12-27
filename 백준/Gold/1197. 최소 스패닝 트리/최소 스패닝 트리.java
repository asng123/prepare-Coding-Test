import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static long sum;

	static Edge[] vertex;
	static int[] p, r;

	static class Edge implements Comparable<Edge> {
		int from, to, c; // v정점으로 가는 비용이 c

		public Edge(int from, int to, int c) {
			this.from = from;
			this.to = to;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		vertex = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			vertex[i] = new Edge(v1, v2, weight);
		}
		make();
		Arrays.sort(vertex);
		for (int i = 0; i < E; i++) {
			union(vertex[i].from, vertex[i].to, vertex[i].c);
		}
		System.out.println(sum);

	}

	private static void union(int x, int y, int w) {
		x = find(x);
		y = find(y);
		if (x == y) {
			return;
		}

		if (r[x] < r[y]) {
			sum+=w;
			p[x] = y;
			r[y]++;
		} else {
			sum+=w;
			p[y] = x;
			r[x]++;
		}

	}

	private static int find(int x) {
		if (x == p[x]) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	private static void make() {
		p = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			p[i] = i;
		}
		r = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			r[i] = 1;
		}
	}

}
