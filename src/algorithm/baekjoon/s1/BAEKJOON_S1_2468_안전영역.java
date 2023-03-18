package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.13
 * @see https://www.acmicpc.net/problem/2468
 * @performance 15772 kb	200 ms
 * @category #dfs
 * @note
 */

public class BAEKJOON_S1_2468_안전영역 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] arr;
	static boolean[][] check;
	static int max, N, ans;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		arr = new int[N][N];
		max = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		ans = 0;
		for(int i=0; i<=max; i++) {
			check = new boolean[N][N];
			int cnt = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!check[j][k] && arr[j][k] > i) {
						dfs(j,k,i);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int height) {
		check[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x+deltas[i][0];
			int ny = y+deltas[i][1];
			
			if(isIn(nx,ny) && !check[nx][ny] && arr[nx][ny] > height) {
				dfs(nx,ny,height);
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
}
