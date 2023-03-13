package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.13
 * @see https://www.acmicpc.net/problem/2210
 * @performance 25324 kb	160 ms
 * @category #dfs
 * @note
 */

public class BAEKJOON_S2_2210_숫자판점프 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] map;
	static int[][] deltas = {{1,0},{0,-1},{-1,0},{0,1}};
	static HashSet<Integer> set = new HashSet<>(); 
	public static void main(String[] args) throws IOException {
		map = new int[5][5];
		
		for(int r=0; r<5; r++) {
			tokens = new StringTokenizer(input.readLine());
			
			for(int c=0; c<5; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				dfs(0,r,c,"");
			}
		}
		
		System.out.println(set.size());
	}

	static void dfs(int lv, int r, int c, String st) {
		if(lv==6) {
			set.add(Integer.parseInt(st));
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			
			if(isIn(nr,nc)) {
				st += map[nr][nc];
				dfs(lv+1, nr, nc, st);
				st = st.substring(0,st.length()-1);
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return 0<=r && r<5 && 0<=c && c<5;
	}
}
