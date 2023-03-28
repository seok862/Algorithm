package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author seok
 * @since 2023.03.28
 * @see https://www.acmicpc.net/problem/1149
 * @performance 12228 kb	92 ms
 * @category # DP
 * @note
 */


public class BAEKJOON_S1_1149_RGB거리 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, min;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());

		arr = new int[N][3];

		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<3; i++) {
			arr[0][i] = Integer.parseInt(tokens.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());

			arr[i][0] = Integer.parseInt(tokens.nextToken())+Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] = Integer.parseInt(tokens.nextToken())+Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2] = Integer.parseInt(tokens.nextToken())+Math.min(arr[i-1][0], arr[i-1][1]);
		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, arr[N-1][i]);
		}

		System.out.println(min);
	}

}
