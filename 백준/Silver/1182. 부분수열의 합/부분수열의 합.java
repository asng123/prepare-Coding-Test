import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] nums;
	static int N, S, count;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		subset(0);
		System.out.println(count);
	}

	private static void subset(int index) { // cnt: 직전까지 고려한 원소수
		if (index == N) {	//	더이상 고려할 원소가 없다면 부분집합 완성!
			return;
		}
		//	선택 하냐 마냐 두 가지 경우의 수를 다 탐색
		
		// 원소 선택
		visited[index] = true;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				sum += arr[i];
			}
		}
		if (sum == S) {
			count++;
		}
		subset(index + 1);
		// 원소 미선택
		visited[index] = false;
		
		subset(index + 1);
	}

}
