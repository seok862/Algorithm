package algorithm.baekjoon.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_S5_11728_배열합치기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[] arr;
	
	/**
	 * @author seok
	 * @since 2023.03.09
	 * @see https://www.acmicpc.net/problem/11728
	 * @performance 339440 kb	1236 ms
	 * @category # 정렬
	 * @note
	 */
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N+M];
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=N; i<N+M; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr);

		for(int i=0; i<arr.length; i++) {
			output.append(arr[i]).append(" ");
		}
		
		System.out.println(output);
	}
}
