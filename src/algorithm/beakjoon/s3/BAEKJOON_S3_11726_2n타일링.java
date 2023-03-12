package algorithm.beakjoon.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author seok
 * @since 2023.03.12
 * @see https://www.acmicpc.net/problem/11726
 * @performance 11516 kb	84 ms
 * @category DP
 * @note
 */

public class BAEKJOON_S3_11726_2n타일링 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		dp = new int[1001];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}
}
