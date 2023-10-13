import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minN = 0;
		int maxN = n - 1;
		int minM = 0;
		int maxM = m - 1;
		
		while (true) {
			int size = (maxN - minN+1)*2 + (maxM - minM+1)*2 - 4;
			roll(minN, maxN, minM, maxM, r % size);
			minN += 1;
			maxN -= 1;
			minM += 1;
			maxM -= 1;

			if (minN >= maxN || minM >= maxM)
				break;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void roll(int minN, int maxN, int minM, int maxM, int cnt) {
		for (int i = 0; i < cnt; i++) {
			int temp = arr[minN][minM];
			
			for (int j = minM; j < maxM; j++) {
				arr[minN][j] = arr[minN][j + 1];
			}
			
			for (int j = minN; j < maxN; j++) {
				arr[j][maxM] = arr[j + 1][maxM];
			}
			
			for (int j = maxM; j > minM; j--) {
				arr[maxN][j] = arr[maxN][j - 1];
			}
			
			for (int j = maxN; j > minN; j--) {
				arr[j][minM] = arr[j - 1][minM];
			}
			
			arr[minN + 1][minM] = temp;
		}

	}
}
