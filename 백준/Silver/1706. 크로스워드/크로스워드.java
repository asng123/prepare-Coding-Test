import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int r, c;
	static char[][] puzzle;
	static ArrayList<String> solved = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		puzzle = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			puzzle[i] = s.toCharArray();
		}

		for (int i = 0; i < r; i++) {
			readCol(i);
		}

		for (int i = 0; i < c; i++) {
			readRow(i);
		}
		
		Collections.sort(solved);
		System.out.println(solved.get(0));
	}

	private static void readCol(int row) {
		int col = 0;
		String str = "";
		while (col < c) {
			if (puzzle[row][col] == '#') {
				if(str.length() > 1)
					solved.add(str);
				str = "";
				col++;
				continue;
			}

			str += puzzle[row][col];
			col++;
		}
		if(str.length() > 1)
			solved.add(str);
	}

	private static void readRow(int col) {
		int row = 0;
		String str = "";
		while (row < r) {
			if (puzzle[row][col] == '#') {
				if(str.length() > 1)
					solved.add(str);
				str = "";
				row++;
				continue;
			}
			
			str+=puzzle[row][col];
			row++;
		}
		if(str.length() > 1)
			solved.add(str);
	}

}
