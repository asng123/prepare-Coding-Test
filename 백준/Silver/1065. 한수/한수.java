import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (check(i)) {
				cnt++;
			}			
		}
		System.out.println(cnt);
	}
	
	private static boolean check(int n) {
		if (n < 100)
			return true;
		else {
			int a = n/100;
			int b = n%100/10;
			int c = n%10;
			if ((a-b) == (b-c))
				return true;
		}
		
		return false;
	}
}