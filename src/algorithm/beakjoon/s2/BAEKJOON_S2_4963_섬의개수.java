package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.10
 * @see https://www.acmicpc.net/problem/4963
 * @performance 13536 kb	120 ms
 * @category #dfs
 * @note
 */


public class BAEKJOON_S2_4963_섬의개수 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int w, h;
	static int[] deltaX = {0,1,1,1,-1,-1,-1,0};
	static int[] deltaY = {-1,-1,1,0,-1,1,0,1};
	static boolean[][] check;
	static int cnt;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		while(true) {
			cnt = 0;
			tokens = new StringTokenizer(input.readLine());
			
			w = Integer.parseInt(tokens.nextToken());
			h = Integer.parseInt(tokens.nextToken());

			if(w == 0 && h == 0) break;
			
			arr = new int[h][w];
			check = new boolean[h][w];
			for(int i=0; i<h; i++) {
				tokens = new StringTokenizer(input.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					if(arr[i][j] == 1 && !check[i][j]) {
						cnt++;
						search(i,j);
					}
				}
			}
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);
		
	}
	
	static void search(int x, int y) {
		check[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int nx = x+deltaX[i];
			int ny = y+deltaY[i];
			
			if(isIn(nx,ny)&& !check[nx][ny] && arr[nx][ny] == 1) {
				search(nx,ny);
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x && x<h && 0<=y && y<w;
	}
}
