package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* @author seok
* @since 2023.03.28
* @see https://www.acmicpc.net/problem/1965
* @performance 11892 kb	96 ms
* @category # LIS
* @note
*/

public class BAEKJOON_S2_1965_상자넣기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, max;
	static int[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N];
		dp = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		dp[0] = 1;
		max = 1;
		for(int i=1; i<N; i++) {
			int num = 0;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					if(num < dp[j]) num = dp[j];
				}
			}
			dp[i] = num+1;
			max = Math.max(dp[i], max);
		}
		
		output.append(max);
		
		System.out.println(output);
	}
}
