import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = stairs[1];

		if (n >= 2)
			dp[2] = stairs[1] + stairs[2];

		System.out.println(sol(n, stairs, dp));
	}

	private static int sol(int n, int[] stairs, int[] dp) {

		if (dp[n] == -1) {
			dp[n] = Math.max(sol(n - 2, stairs, dp), sol(n - 3, stairs, dp) + stairs[n - 1]) + stairs[n];
		}

		return dp[n];
	}

}
