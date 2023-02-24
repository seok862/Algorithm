package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/15658
 * @performance 13404 kb	104 ms
 * @category #dfs
 * @note
 */

public class BAEKJOON_S2_15658_연산자끼워넣기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr, arr2;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		arr2 = new int[4];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = Integer.parseInt(tokens.nextToken());
		}
		
		make(0,new int[N-1], new boolean[arr.length]);
		
	}
	
	public static void make(int lv, int[] choosed, boolean[] visited) {
		if(lv==choosed.length) {
		}
		
		
	}
}
