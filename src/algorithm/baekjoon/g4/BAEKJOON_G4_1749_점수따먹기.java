package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.23
 * @see https://www.acmicpc.net/problem/1749
 * @performance 19044 kb	856 ms
 * @category # 누적합
 * @note
 */

public class BAEKJOON_G4_1749_점수따먹기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] arr;
	static int N,M;
	static int max;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
		
		max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int x1=1; x1<=N; x1++) {
			for(int y1=1; y1<=N; y1++) {
				for(int x2=x1; x2<=N; x2++) {
					for(int y2=y1; y2<=N; y2++) {
						sum = arr[x2][y2]-arr[x2][y1-1]-arr[x1-1][y2]+arr[x1-1][y1-1];
						max = Math.max(sum, max);
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
