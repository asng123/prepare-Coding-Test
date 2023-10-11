import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> arrA = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			arrA.put(a, arrA.getOrDefault(a, 0) + 1);
		}

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int chkNum = Integer.parseInt(st.nextToken());
			int chk = arrA.getOrDefault(chkNum, -1);
			if(chk == -1)
				sb.append(0).append("\n");
			else
				sb.append(1).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
