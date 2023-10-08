import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 1~ 99 카드 n장 바닥에 나란히
	// 2~4장 선택 후 나란히 정수 만들기 가지수
	// 같은 숫자 체크는 어떻게 할까.
	// 99를 4장선택 99999999
	static boolean[] checkNum = new boolean[100000000];
	static int n, k, answer;
	static int[] num;
	static int[] makedNum;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[n];
		makedNum = new int[k];
		pickAndMakeNum(0);
		
		System.out.println(answer);
	}

	private static void pickAndMakeNum(int cnt) {
		if(cnt == k) {
			String newNum = "";
			for (int i = 0; i < k; i++) {
				newNum += Integer.toString(makedNum[i]);
			}
			if(!checkNum[Integer.parseInt(newNum)]) {
				answer++;
				checkNum[Integer.parseInt(newNum)] = true;
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visited[i])
				continue;
			makedNum[cnt] = num[i];
			visited[i] = true;
			pickAndMakeNum(cnt+1);
			visited[i] = false;
		}
		
	}

}
