package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.09
 * @see https://www.acmicpc.net/problem/1987
 * @performance 12,572 kb	908 ms
 * @category #백트래킹
 * @note
 */

public class BAEKJOON_g4_1987_알파벳 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[] check = new boolean[26];
	static int R, C;
	static int ans;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
	
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			String st = input.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = st.charAt(j);
			}
		}
		
		count(0,0,1);

		System.out.println(ans);
	}
	
	public static void count(int x,int y, int lv) {
		check[arr[x][y]-'A'] = true;
		ans = Math.max(ans, lv);
		
		for(int i=0; i<4; i++) {
			int nx = x+deltas[i][0];
			int ny = y+deltas[i][1];
			
			if(isIn(nx,ny)) {
				if(!check[arr[nx][ny]-'A']) {
					count(nx,ny,lv+1);
					check[arr[nx][ny]-'A'] = false;
				}
			}
		}
	}
	
	public static boolean isIn(int x,int y) {
		return 0<=x && x<R && 0<=y && y<C;
	}
}
