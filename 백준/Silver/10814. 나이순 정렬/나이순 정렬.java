import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	// 가입한 사람들의 나이와 이름이 가입순으로
	// 나이가 증가하는 순 나이가 같으면 먼저 가입한 사람이 앞에오는 순으로 정렬
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[][] member = new String[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			member[i][0] = st.nextToken();
			member[i][1] = st.nextToken();
		}
		
		Arrays.sort(member, (o1,o2) -> {
			int n1 = Integer.parseInt(o1[0]);
			int n2 = Integer.parseInt(o2[0]);
						
			return n1-n2;
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(member[i][0] + " " + member[i][1]);
		}
	}

}
