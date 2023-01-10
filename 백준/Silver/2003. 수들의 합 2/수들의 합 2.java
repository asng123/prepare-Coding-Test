package asngstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2_S4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int N = Integer.parseInt(st.nextToken());			// 배열의 크기 
		int M = Integer.parseInt(st.nextToken());			// 목표 숫자

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];						// 수열 배열
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());		// 배열 입력

		int end = 0;							// end idx
		int count = 0;							// 정답 개수
		int sum = arr[0];						// M과 같은지 확인하는 변수
		for (int start = 0; start < N; start++) {			// idx 0부터 N-1 까지 start로 훑으며
			while (sum < M && end < N - 1) {			// sum이 M보다 작고 end가 배열범위를 초과하지 않는한 
				end++;						// 전진
				sum += arr[end];				// sum에 더해주기
			}
			if(sum == M) {						// sum이 M과 같으면
				count++;					// 개수 세주기
			}
			sum -= arr[start];					// start idx 전진하므로 전에꺼 빼주기
		}
		
		System.out.println(count);					// 정답 출력
	}

}
