import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[12];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(sol(n, dp));
		}
	}

	private static int sol(int n, int[] dp) {
		if (n <= 3)
			return dp[n];

		if (dp[n] == -1)
			return dp[n] = sol(n - 1, dp) + sol(n - 2, dp) + sol(n - 3, dp);
		else
			return dp[n];

	}

}
