package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.26
 * @see https://www.acmicpc.net/problem/17070
 * @performance 293552 kb	436 ms
 * @category # 재귀
 * @note
 */

public class BAEKJOON_G5_17070_파이프옮기기1 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt;
	static int[][] map;
	static int[][] row = { { 0, 1 }, { 1, 1 } };
	static int[][] col = { { 1, 0 }, { 1, 1 } };
	static int[][] x = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		map = new int[N + 1][N + 1];
		cnt = 0;
		for (int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		check(new Pipe(1, 1, 2));
		System.out.println(cnt);
	}

	public static void check(Pipe p) {
		if (p.r == N && p.c == N) {
			cnt++;
			return;
		}

		switch (p.state) {
		// 가로
		case 1:
			for (int i = 0; i < 2; i++) {
				int nr = p.r + row[i][0];
				int nc = p.c + row[i][1];
				if (isIn(nr, nc)) {
					if (row[i][0] == 1 && row[i][1] == 1) {
						if (checkX(p.r, p.c)) {
							check(new Pipe(3, nr, nc));
						}
					} else {
						if (map[nr][nc] == 0) {
							check(new Pipe(1, nr, nc));
						}
					}
				}

			}
			break;
		// 세로
		case 2:
			for (int i = 0; i < 2; i++) {
				int nr = p.r + col[i][0];
				int nc = p.c + col[i][1];
				if (isIn(nr, nc)) {
					if (col[i][0] == 1 && col[i][1] == 1) {
						if (checkX(p.r, p.c)) {
							check(new Pipe(3, nr, nc));
						}
					} else {
						if (map[nr][nc] == 0) {
							check(new Pipe(2, nr, nc));
						}
					}
				}

			}
			break;
		// 대각
		case 3:
			for (int i = 0; i < 3; i++) {
				int nr = p.r + x[i][0];
				int nc = p.c + x[i][1];
				if (isIn(nr, nc)) {
					if (x[i][0] == 1 && x[i][1] == 1) {
						if (checkX(p.r, p.c)) {
							check(new Pipe(3, nr, nc));
						}
					} else {
						if (map[nr][nc] == 0) {
							check(new Pipe((i+1), nr, nc));
						}
					}
				}
			}
			break;
		}
	}

	public static class Pipe {
		int state;
		int r;
		int c;

		public Pipe(int state, int r, int c) {
			this.state = state;
			this.r = r;
			this.c = c;
		}
	}

	public static boolean checkX(int x, int y) {
		return (isIn(x + 1, y) && isIn(x, y + 1) && isIn(x + 1, y + 1) && map[x + 1][y] == 0 && map[x][y + 1] == 0
				&& map[x + 1][y + 1] == 0);
	}

	public static boolean isIn(int x, int y) {
		return 1 <= x && x <= N && 1 <= y && y <= N;
	}
}
