package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.29
 * @see https://www.acmicpc.net/problem/2293
 * @performance 11736 kb	88 ms
 * @category # DP
 * @note
 */

public class BAEKJOON_G5_2293_동전1 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,K;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		dp = new int[K+1];
		
		dp[0] = 1;
		for(int t=0; t<N; t++) {
			int num = Integer.parseInt(input.readLine());
			
			for(int i=num; i<K+1; i++) {
				dp[i] += dp[i-num];
			}
		}
		System.out.println(dp[K]);
	}
}
