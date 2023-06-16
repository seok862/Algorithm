package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.16
 * @see https://www.acmicpc.net/problem/1107
 * @performance 12668 kb	196 ms
 * @category # 브루트포스
 * @note
 */

public class BAEKJOON_G5_1107_리모컨 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer  tokens;
	static StringBuilder output = new StringBuilder();
	static String N;
	static int M, ans;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		N = input.readLine();
		M = Integer.parseInt(input.readLine());
		arr = new boolean[11];
		
		if(M > 0) {
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<M; i++) {
				arr[Integer.parseInt(tokens.nextToken())] = true;
			}
		}
		
		ans = Math.abs(Integer.parseInt(N)-100);
		
		for (int i = 0; i < 1000001; i++) {
			int cnt = check(i);
			if (cnt != 0)
				ans = Math.min(ans, Math.abs(Integer.parseInt(N) - i) + check(i));
		}
		System.out.print(ans);
	}
	
	public static int check(int n) {
		if (n == 0) {
			if (arr[n])
				return 0;
			else
				return 1;
		}
		
		int cnt = 0;
		while (n > 0) {
			if (arr[n % 10])
				return 0;
			cnt++;
			n /= 10;
		}
	
		return cnt;
	}
}
