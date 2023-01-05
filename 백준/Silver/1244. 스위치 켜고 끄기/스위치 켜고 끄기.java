import java.util.Scanner;

public class Main{
	
	static int N;
	static int[] arr;
	static int nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		int x = N/20 + 1;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		nums = sc.nextInt();
		for (int i = 0; i < nums; i++) {
			int s = sc.nextInt();
			if (s == 1) {
				int idx = sc.nextInt();
				for (int j = 1; j <= N/idx; j++) {
					change(idx*j-1);
				}
			}
			else {
				int idx = sc.nextInt();
				int c = Math.min(N-idx, idx-1);
				int check = 0;
				for (int j = 1; j <= c; j++) {
					if (arr[idx-j-1] == arr[idx+j-1]) {
						check = j;
					}
					else {
						break;
					}
				}
				if(check != 0) {
					for (int j = 1; j <= check; j++) {
						change(idx+j-1);
						change(idx-j-1);
					}
				}
				change(idx-1);
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]+" ");
			if ((i+1)%20 == 0)
				System.out.println();
		}
		sc.close();
		
	}
	
	private static void change(int n) {
		if (arr[n] == 1) arr[n] = 0;
		else arr[n] = 1;
	}
	
	
}
