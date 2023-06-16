package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.04
 * @see https://www.acmicpc.net/problem/14888
 * @performance 13412 kb	88 ms
 * @category # dfs
 * @note
 */

public class BAEKJOON_S1_14888_연산자끼워넣기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, max, min;
	static int[] arr;
	static int[] number;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[4];
		number = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		tokens = new StringTokenizer(input.readLine());
		
		
		for(int i=0; i<N; i++) { 
			number[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		dfs(number[0],1);
		
		output.append(max).append("\n").append(min);
		
		System.out.println(output);
	}
	
	public static void dfs(int num, int idx) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(arr[i] > 0) {
				arr[i]--;
				
				if(i==0) {
					dfs(num+number[idx], idx+1);
				}else if(i==1) {
					dfs(num-number[idx], idx+1);
				}else if(i==2) {
					dfs(num*number[idx], idx+1);
				}else{
					dfs(num/number[idx], idx+1);
				}
				
				arr[i]++;
			}
		}
	}
}
