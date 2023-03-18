package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_G5_16927_배열돌리기2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] arr;
	static int N, M;
	static int[][] tmp;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		int R = Integer.parseInt(tokens.nextToken());

		arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int min = Math.min(N / 2, M / 2);

		for (int a = 0; a < R; a++) {
			tmp = new int[N + 1][M + 1];
			for (int r = 1; r <= min; r++) {
				rotation(arr, r);
			}
			arr = tmp;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] rotation(int[][] arr, int r) {

		for (int i = r; i <= N + 1 - r; i++) { 
			for (int j = r; j <= M + 1 - r; j++) {
				// 위
				if (i == r && j != M + 1 - r) {
					tmp[i][j] = arr[i][j + 1];
				}
				// 아래
				if (i == N + 1 - r && j != r) {
					tmp[i][j] = arr[i][j - 1];
				}
				// 왼쪽
				if (i != r && j == r) {
					tmp[i][j] = arr[i - 1][j];
				}
				// 오른쪽
				if (i != N + 1 - r && j == M + 1 - r) {
					tmp[i][j] = arr[i + 1][j];
				}
			}
		}
		return tmp;
	}
}
