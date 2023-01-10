import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int end = 0;
		int count = 0;
		int sum = arr[0];
		for (int start = 0; start < N; start++) {
			while (sum < M && end < N - 1) {
				end++;
				sum += arr[end];
			}
			if(sum == M) {
				count++;
			}
			sum -= arr[start];
		}
		
		System.out.println(count);
	}

}
