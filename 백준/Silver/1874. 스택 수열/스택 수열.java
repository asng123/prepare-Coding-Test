import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		
		StringBuilder sb = new StringBuilder();
		int maxNum = 0;
		
		for (int i = 1; i <= n; i++) {
			arr[i-1] = i;
		}
		
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());
			if(maxNum<next) {
				visited[next-1] = true;
				for (int j = maxNum; j < next; j++) {
					sb.append("+");
				}
				sb.append("-");
				maxNum = next;
			}else {
				if(visited[next]) {
					visited[next-1] = true;
					sb.append("-");
				}else {
					System.out.println("NO");
					return;
				}
			}
		}
		
		String ans = sb.toString();
		for (int i = 0; i < ans.length(); i++) {
			System.out.println(ans.charAt(i));
		}
		// 1. 작은거 다음 큰거 출력이 안돼
		// 2. 그러나 여태 나온수보다 제일 큰수라면 가능해
		// 3. 큰거다음 작은거는 무조건 가능하진 않아.
		// 4. 수가 붙어있어야해
		//  res. 여태 나왔던 수보다 더 큰 수라면 뽑을 수 있음!
		//       그다음 나오는 수는 붙어있어야해.
		//       즉, 제일 큰수 기준으로 안뽑힌 그다음 큰수가 나올 수 있어.
	}

}

