package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.02.26
 * @see https://www.acmicpc.net/problem/15658
 * @performance 14112 kb	100 ms
 * @category # dfs
 * @note
 */

public class BAEKJOON_S2_15658_연산자끼워넣기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr, arr2;
	static int max,min,N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		
		arr2 = new int[4];

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
		make(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void make(int index, int sum) {
		if(index == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
				
		for(int i=0; i<4; i++) {
			if(arr2[i] == 0) continue;
			arr2[i]--;
			
			switch(i) {
			case 0:
				make(index+1, sum+arr[index]);
				break;
			case 1:
				make(index+1, sum-arr[index]);
				break;
			case 2:
				make(index+1, sum*arr[index]);
				break;
			case 3:
				make(index+1, sum/arr[index]);
				break;
			}
			
			arr2[i]++;
		}
	}
}
