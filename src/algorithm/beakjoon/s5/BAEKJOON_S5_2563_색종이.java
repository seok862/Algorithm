package algorithm.beakjoon.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.15
 * @see https://www.acmicpc.net/problem/2563
 * @performance 11612 kb	80 ms
 * @category # 배열
 * @note
 */


public class BAEKJOON_S5_2563_색종이 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] arr;
	static int count;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		arr = new int[100][100];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			for(int x=a; x<a+10; x++) {
				for(int y=b; y<b+10; y++) {
					arr[x][y] = 1;
				}
			}
		}
		count = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j] == 1) count++;
			}
		}
		
		System.out.println(count);
	}
}
