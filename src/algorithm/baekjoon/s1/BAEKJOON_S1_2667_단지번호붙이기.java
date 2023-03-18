package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author seok
 * @since 2023.02.10
 * @see https://www.acmicpc.net/problem/2667
 * @performance 11928 kb	100 ms
 * @category #dfs
 * @note
 */ 

public class BAEKJOON_S1_2667_단지번호붙이기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] deltaX = {0,1,0,-1};
	static int[] deltaY = {-1,0,1,0};
	static int ans;
	static List<Integer> list = new ArrayList<>();
	static int tmp;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		ans = 0;
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String st = input.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.substring(j,j+1));
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					tmp = 1;
					ans++;
					search(i,j);
					list.add(tmp);
				}
			}
		}
		System.out.println(ans);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	static void search(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+deltaX[i];
			int ny = y+deltaY[i];
			
			if(isIn(nx,ny) && !visited[nx][ny] && arr[nx][ny] == 1) {
				tmp++;
				search(nx,ny);
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x && x<N && 0<=y && y<N;
	}
}
