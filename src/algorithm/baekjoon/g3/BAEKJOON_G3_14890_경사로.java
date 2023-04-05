package algorithm.baekjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G3_14890_경사로 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int N, X;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());

			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		// 1. 열 체크
		int row = checkRow(X);
		int col = checkCol(X);
		System.out.println((row + col));
	}

	public static int checkCol(int len) {
		int tot = 0;
		for (int r = 0; r < N; r++) {
			boolean check = true;
			boolean[][] tmp = new boolean[N][N];
			outer: for (int c = 0; c < N - 1; c++) {

				if (map[r][c] != map[r][c + 1]) {
					// 1. 높아질 경우
					if (map[r][c] < map[r][c + 1]) {
						if (map[r][c + 1] - map[r][c] != 1) {
							check = false;
							break;
						}
						
						if ((c - len + 1) < 0) {
							check = false;
							break;
						}

						for (int i = c - len + 1; i < c; i++) {
							if (map[r][i] != map[r][i + 1] || tmp[r][i]) {
								check = false;
								break outer;
							}
							tmp[r][i] = true;
						}
						if (check)
							tmp[r][c] = true;
					}

					// 2. 낮아질 경우
					else {
						if (map[r][c] - map[r][c + 1] != 1) {
							check = false;
							break;
						}

						if (c + len >= N) {
							check = false;
							break;
						}

						if(len == 1) {
							tmp[r][c + len] = true;
						}else {
							for (int i = c + 1; i < c + len; i++) {
								if (map[r][i] != map[r][i + 1] || tmp[r][i]) {
									check = false;
									break outer;
								}
								tmp[r][i] = true;
							}
						}
						
					}
				}
			}
			if (check)
				tot++;
		}

		return tot;
	}

	public static int checkRow(int len) {
		int tot = 0;
		for (int c = 0; c < N; c++) {
			boolean check = true;
			boolean[][] tmp = new boolean[N][N];
			outer: for (int r = 0; r < N - 1; r++) {
				if (map[r][c] != map[r + 1][c]) {
					// 1. 높아질 경우
					if (map[r][c] < map[r + 1][c]) {

						// 차이가 1이 아닌 겨우
						if (map[r + 1][c] - map[r][c] != 1) {
							check = false;
							break;
						}

						// len보다 앞의 거리가 짧을 경우
						if ((r - len + 1) < 0) {
							check = false;
							break;
						}

						// len만큼 이전의 거리에서 다른 숫자가 있을 경우
						for (int i = r - len + 1; i < r; i++) {
							if (map[i][c] != map[i + 1][c] || tmp[i][c]) {
								check = false;
								break outer;
							}
							tmp[i][c] = true;
						}

						if (check)
							tmp[r][c] = true;
					}

					// 2. 낮아질 경우
					else {

						// 둘의 차이가 1이 아닌 경우
						if (map[r][c] - map[r + 1][c] != 1) {
							check = false;
							break;
						}

						if (r + len >= N) {
							check = false;
							break;
						}
						
						int standard = map[r+1][c];

						if(len == 1) {
							tmp[r+1][c] = true;
						}else {
							for (int i = r; i < r + len; i++) {
								if (standard != map[i][c] || tmp[i][c]) {
									check = false;
									break outer;
								}
								tmp[i][c] = true;
							}
						}
					}

				}

			}
			if (check)
				tot++;
		}

		return tot;
	}
}
