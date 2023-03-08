package algorithm.beakjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.03.08
 * @see https://www.acmicpc.net/problem/2003
 * @performance 14364 kb	116 ms
 * @category # 누적합+투포인터
 * @note
 */

public class BAEKJOON_S4_2003_수들의합2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr;
	static int N,cnt;
	static long M;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(tokens.nextToken());
		}
		int cnt = 0;

		int left = 0;
		int right = 1;
		
		while(true) {
			int sum = arr[right]-arr[left];
			
			if(sum == M) cnt++;
			
			if(sum > M) {
				left++;
			}else {
				right++;
			}
			
			if(right > N) break;
		}
		
		System.out.println(cnt);
	}
}
