package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S1_2468_안전영역 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] arr;
	static boolean[][] check;
	static int max;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		max = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int a=1; a<=100; a++) {
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[j].length; j++) {
					if(arr[i][j] == a) {
						check[i][j] = true;
					}
				}
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					dfs(i,j);
				}
			}
		}
		
	}
	
	static void dfs(int x, int y) {
		if(!check[x][y]) {
			
		}
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
}
