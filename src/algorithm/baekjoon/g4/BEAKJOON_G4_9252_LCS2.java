package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.18
 * @see https://www.acmicpc.net/problem/9251
 * @performance 65340 kb	192 ms
 * @category # dp
 * @note
 */

public class BEAKJOON_G4_9252_LCS2 {

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
		String ans = "";
		int i = st1.length();
		int j = st2.length();
	
		while(j>0 && i>0) {
			if(dp[i][j] > Math.max(dp[i-1][j], dp[i][j-1])) {
				ans += st1.substring(i-1,i);
				i-=1;
				j-=1;
			}else {
				if(dp[i-1][j] == dp[i][j]) {
					i-=1;
				}else {
					j-=1;
				}
			}
		}
		System.out.println(ans.length());
		
		output.append(ans).reverse();
		
		System.out.println(output);
	}
}
