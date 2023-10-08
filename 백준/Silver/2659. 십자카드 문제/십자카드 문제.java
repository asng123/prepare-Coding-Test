import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 십자카드 네 모서리에 1~9 숫자 같은숫자 가능
	// 시계수라는 번호를 가짐
	// 카드숫자를 시계방향으로 읽어서 만들어지는 수중 가장 작은 수
	// 카드들의 시계수 계산 후 몇 번째로 작은 시계수인지
	// 1121 => 1112 이게 어려움
	// 중복순열로 4개를 뽑아서 시계수를 구해 그때마다 cnt +1 하고 clockNum리랑 같은 수를 구하면 그게 답.

	static int answer = 9999, indexChk;
	static int[] makeNum;
	static boolean[] visited = new boolean[10000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] card = new int[8];
		for (int i = 0; i < 4; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			card[i + 4] = card[i];
		}

		int clockNum = findClockNum(card);
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		makeNum = new int[8];

		findIndex(0, clockNum, num);
		System.out.println(answer);

	}

	private static void findIndex(int cnt, int clockNum, int[] num) {
		if(cnt == 4) {
			int temp = findClockNum(makeNum);
			if(visited[temp])
				return;
			indexChk++;
			visited[temp] = true;
			if(temp == clockNum)
				answer = Math.min(answer, indexChk);
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			makeNum[cnt] = num[i];
			makeNum[cnt+4] = num[i];
			findIndex(cnt+1,clockNum,num);
		}
	}

	private static int findClockNum(int[] card) {
		int num = 9999;
		for (int i = 0; i < 4; i++) {
			int temp = card[i] * 1000 + card[i + 1] * 100 + card[i + 2] * 10 + card[i + 3];
			num = Math.min(num, temp);
		}
		return num;
	}

}
