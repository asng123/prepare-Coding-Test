import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		
		int ans = 0;
		for(int s = 1;s<=n;s++) {
			dp[s] = 1;
			for (int i = 1; i < s; i++) {
				if(arr[i]>arr[s]) {
					dp[s] = Math.max(dp[i]+1, dp[s]);
				}
			}
			ans = Math.max(ans, dp[s]);
		}
			
		System.out.println(ans);
	}

}
