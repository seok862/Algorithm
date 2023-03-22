package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.03.16
 * @see https://www.acmicpc.net/problem/11722
 * @performance 12092 kb	100 ms
 * @category # dp
 * @note
 */

public class BAEKJOON_S2_11722_가장긴감소하는부분수열 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int[] arr;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N];
		answer = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		answer[0] = 1;
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<N; i++) {
			answer[i] = 1;
			
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[i] && answer[i] < answer[j]+1) {
					answer[i] = answer[j]+1;
				}
			}
			
		}
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, answer[i]);
		}
		
		System.out.println(max);
	}
}