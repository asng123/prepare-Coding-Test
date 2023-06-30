import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] memo = new long[n + 1];
		Arrays.fill(memo, -1);
		
		System.out.println(fibo(n, memo));
	}

	public static long fibo(int n, long[] memo) {

		// 종료조건
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		
		// memoization을 한 피보나치
		if(memo[n] == -1) 
			return memo[n] = fibo(n-1, memo)+fibo(n-2, memo);
		else {
			return memo[n];
		}
	}

}
