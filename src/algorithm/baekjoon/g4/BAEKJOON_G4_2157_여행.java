package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_G4_2157_여행 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, K;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		arr = new int[K + 1][K + 1];

		dp = new int[N + 1][N + 1];

		for (int i = 1; i < K + 1; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			int score = Integer.parseInt(tokens.nextToken());

			if (s >= e) continue;
			arr[s][e] = Math.max(score, arr[s][e]);
		}

		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp[1][1] = 0;
		for (int i = 1; i < N; i++) {
			int tmp = Math.min(i, M - 1);
			for (int j = 1; j <= tmp; j++) {
				if (dp[i][j] == -1) continue;
				for (int k = i + 1; k <= N; k++) {
					if (arr[i][k] == 0) continue;
					dp[k][j + 1] = Math.max(dp[k][j + 1], dp[i][j] + arr[i][k]);
				}
			}
		}
		
		int max = 0;
		for (int i = 1; i <= M; i++) {
			max = Math.max(max, dp[N][i]);
		}

		System.out.println(max);
	}
}
