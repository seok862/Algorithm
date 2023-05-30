package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.20
 * @see https://www.acmicpc.net/problem/11559
 * @performance 12028 kb	76 ms
 * @category # 시뮬레이션
 * @note
 */

public class BAEKJOON_G4_11559_PuyoPuyo {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
	static char[][] map;
	static boolean[][] visited;
	static ArrayList<Point> list;
	static int cnt;
	static int N = 12, M = 6;
	
	
	public static void main(String[] args) throws IOException {
		map = new char[N][M];
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = st.charAt(c);
			}
		}
		
		cnt = 0;
		
		while(true) {
			boolean check = true;
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] != '.') {
						list = new ArrayList<>();
						
						bfs(map[i][j],i, j);
						
						if(list.size() >= 4){
							check = false;
							
							for(int k=0; k<list.size(); k++) {
								map[list.get(k).x][list.get(k).y] = '.';
							}
						}
					}
				}
			}
			if(check) break;
			change();
			cnt++;
		}
		System.out.println(cnt);
	}
	
	public static void bfs(char c, int x, int y) {
		Queue<Point> q = new LinkedList<>();
		list.add(new Point(x,y));
		q.offer(new Point(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.x+deltas[i][0];
				int nc = p.y+deltas[i][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == c) {
					visited[nr][nc] = true;
					list.add(new Point(nr,nc));
					q.offer(new Point(nr,nc));
				}
			}
		}
	}
	
	public static void change() {
		for(int i=0; i<M; i++) {
			for(int j=N-1; j>0; j--) {
				if(map[j][i] == '.') {
					for(int k=j-1; k >= 0; k--) {
						if(map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
	
	public static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
