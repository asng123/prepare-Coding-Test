import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int sum = 0, idx = 0, num = 0;
		for (int i = 1; i < 5000; i++) {
			sum += i;
			if (sum >= N) {
				idx = i;
				num = sum-N;
				break;
			}
		}
		if(idx%2==1)
			System.out.println((num+1) +"/"+(idx-num));
		else
			System.out.println((idx-num) +"/"+(num+1));
	}
}
