import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	// 임시반장 -> 선거반장
	// 1학년부터 5학년까지 한번이라도 같은반이었던 사람이 가장많은 학생을
	// 임시반장 정하는 프로그램
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] students = new int[n][5];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] count = new int[n];
		boolean[][] chkBefore = new boolean[n][n];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < n; j++) {
				int num = students[j][i];
				for (int k = j+1; k < n; k++) {
					if(num == students[k][i]) {
						if(chkBefore[j][k])
							continue;
						count[j]++;
						count[k]++;
						chkBefore[j][k] = true;
						chkBefore[k][j] = true;
					}
				}
			}
		}
		
		int answer = 0;
		int maxCnt = count[0];
		for (int i = 1; i < n; i++) {
			if(maxCnt<count[i]) {
				answer = i;
				maxCnt = count[i];
			}
		}
		System.out.println(answer+1);
	}

}
