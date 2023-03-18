package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.18
 * @see https://www.acmicpc.net/problem/9251
 * @performance 54996 kb	172 ms
 * @category # dp
 * @note
 */

public class BAEKJOON_G5_9251_LCS {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String st1, st2;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		st1 = input.readLine();
		st2 = input.readLine();
		
		dp = new int[st1.length()+1][st2.length()+1];
		
		for(int i=1; i<=st1.length(); i++) {
			String tmp1 = st1.substring(i-1,i);
			for(int j=1; j<=st2.length(); j++) {
				String tmp2 = st2.substring(j-1,j);
				
				if(tmp1.equals(tmp2)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		System.out.println(dp[st1.length()][st2.length()]);
	}
}
