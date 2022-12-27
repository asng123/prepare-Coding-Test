import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	static int x;
	static PriorityQueue<Integer> pq;
	static ArrayList<Integer> stick;
	static boolean anschk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

        anschk = false;
        x = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        pq.add(64);

        stick = new ArrayList<>();
        stick.add(64);

        check();
        while(!anschk) {
            divide();
        }

	

		System.out.println(stick.size());
	}

	private static void divide() {
		int cur = pq.poll();
		int dcur = cur / 2;
		pq.add(dcur);
		
		stick.remove(stick.indexOf(cur));
		stick.add(dcur);
		if (check()) {
			return;
		}else {
			stick.add(dcur);
			return;
		}
	}

	private static boolean check() {
		int sum = 0;
		for (int a : stick)
			sum += a;

		if (sum > x)
			return true;
		else if (sum < x)
			return false;
		else {
			anschk = true;
			return true;
		}
	}

}
