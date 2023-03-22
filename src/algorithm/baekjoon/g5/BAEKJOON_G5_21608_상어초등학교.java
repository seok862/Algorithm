package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G5_21608_상어초등학교 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder out = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	static int[][] ans;
	static int cnt;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Point p;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N * N][5];
		ans = new int[N][N];
		cnt = 0;
		for (int r = 0; r < N * N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < 5; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		for (int r = 0; r < N * N; r++) {
			p = new Point(0, 0, 0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ans[i][j] == 0) {
						checkPoint(i, j, r);
					}
				}
			}
			ans[p.r][p.c] = map[r][0];
		}

		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(ans[r][c]+ " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count(i, j);
			}
		}

		System.out.println(cnt);
	}

	static void count(int r, int c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];

			if (isIn(nr, nc)) {
				for (int j = 1; j <= N * N; j++) {
					if (map[j-1][0] == ans[r][c]) {
						for (int col = 1; col < 5; col++) {
							if (ans[nr][nc] == map[j-1][col]) {
								count++;
							}
						}
					}
				}
			}
		}

		switch (count) {
		case 0:
			cnt += 0;
			break;
		case 1:
			cnt += 1;
			break;
		case 2:
			cnt += 10;
			break;
		case 3:
			cnt += 100;
			break;
		case 4:
			cnt += 1000;
			break;
		}
	}

	static void checkPoint(int r, int c, int idx) {
		int cnt = 0;
		int empty = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];

			if (isIn(nr, nc)) {
				if (ans[nr][nc] == 0) {
					empty++;
				}

				for (int col = 1; col < 5; col++) {
					if (ans[nr][nc] == map[idx][col]) {
						cnt++;
					}
				}
			}
		}

		if (cnt > p.cnt) {
			p.cnt = cnt;
			p.r = r;
			p.c = c;
		} else if (cnt == p.cnt && empty > p.empty) {
			p.empty = empty;
			p.r = r;
			p.c = c;
		}

	}

	static class Point {
		int r;
		int c;
		int cnt;
		int empty;

		public Point(int r, int c, int cnt, int empty) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.empty = empty;
		}
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
