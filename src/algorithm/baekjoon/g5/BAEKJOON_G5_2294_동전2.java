package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* @author seok
* @since 2023.03.29
* @see https://www.acmicpc.net/problem/2294
* @performance 12892 kb	144 ms	
* @category # DP
* @note
*/

public class BAEKJOON_G5_2294_동전2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] dp, coins;
	static int N,K;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		dp = new int[K+1];
		Arrays.fill(dp, -1);
		
		coins = new int[N];
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(input.readLine());
		}
		
		int ans = cal(K);
		if(ans==10001) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	
	public static int cal(int k) {
		if(k<0) {
			return 10001;
		}else if(k == 0) {
			return 0;
		}else {
			if(dp[k] == -1) {
				int maxCnt = 10001;
				for(int i=0; i<N; i++) {
					maxCnt = Math.min(maxCnt, cal(k-coins[i])+1);
				}
				return dp[k] = maxCnt;
			}else {
				return dp[k];
			}
		}
	}
}
