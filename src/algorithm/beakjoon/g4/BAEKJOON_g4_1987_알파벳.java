package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_g4_1987_알파벳 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = { { 0, 1 }, { -1, 0 }, { 1, 0 }, { 0, -1 } };
	static boolean[] check = new boolean[26];
	static int R, C;
	static int ans;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		ans = Integer.MIN_VALUE;
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String st = input.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = st.charAt(j);
			}
		}
		check[arr[0][0]-'A'] = true;
		count(0, 0, 1);

		System.out.println(ans);
	}

	public static void count(int x, int y, int lv) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + deltas[i][0];
			int ny = y + deltas[i][1];

			if (isIn(nx, ny)) {
				if (check[arr[nx][ny] - 'A']) {
					ans = Math.max(ans, lv);
					return;
				}
				else {
					check[arr[nx][ny] - 'A'] = true;
					count(nx, ny, lv + 1);
					check[arr[nx][ny] - 'A'] = false;
				}
			}
		}
	}

	public static boolean isIn(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}
