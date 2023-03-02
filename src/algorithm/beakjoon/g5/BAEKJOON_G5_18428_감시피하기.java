package algorithm.beakjoon.g5;
/**
 * @author seok
 * @since 2023.02.26
 * @see https://www.acmicpc.net/problem/18428
 * @performance 14816 kb	120 ms
 * @category # dfs 
 * @note
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G5_18428_감시피하기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] map;
	static int N;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = tokens.nextToken().charAt(0);
			}
		}

		makeWall(0);

		System.out.println("NO");
	}

	public static void makeWall(int lv) {
		if (lv == 3) {
			boolean check = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'T') {
						if (!checkStudent(i, j)) check = false;
					}
				}
			}
			if(check) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					makeWall(lv + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	public static boolean checkStudent(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			while (true) {
				nx += deltas[i][0];
				ny += deltas[i][1];

				if (!isIn(nx, ny) || map[nx][ny] == 'O')
					break;

				if (map[nx][ny] == 'S')
					return false;

			}
		}

		return true;
	}

	public static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
