package algorithm.baekjoon.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.19
 * @see https://www.acmicpc.net/problem/14929
 * @performance 22680 kb	224 ms
 * @category # 누적합
 * @note
 */


public class BAEKJOON_S5_14929_귀찮아SIB {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr;
	static int[] sum;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		arr = new int[N+1];
		sum = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			sum[i] = sum[i-1]+arr[i];
		}
		
		int ans = 0;
		for(int i=1; i<N; i++) {
			int n = sum[N] - sum[i];
			ans += n*arr[i];
		}
		System.out.println(ans);
	}

}
