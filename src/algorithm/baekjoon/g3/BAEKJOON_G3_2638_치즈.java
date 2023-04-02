package algorithm.baekjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @author seok
* @since 2023.04.02
* @see https://www.acmicpc.net/problem/2638
* @performance 	39824 kb	228 ms
* @category # bfs + 구현
* @note
*/
public class BAEKJOON_G3_2638_치즈 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static boolean[][] tmp;
	static boolean[][] visited;
	static int N, M, emptyCnt,ans;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		int ans = 0;
		
		while (true) {
			ans++;
			emptyCnt = 0;
			tmp = new boolean[N][M];
			
			// 임시 맵 생성
			bfs();
			

			// 다 돌면서 tmp배열의 true가 두개인 위치의 map[1] 을 0으로 바꿈
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1 && possible(i,j)) {
						map[i][j] = 0;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 0) {
						emptyCnt++;
					}
				}
			}
			if (emptyCnt == N * M)
				break;
		}
		
		System.out.println(ans);
	}
	
	public static boolean possible(int x, int y) {
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nr = x+deltas[i][0];
			int nc = y+deltas[i][1];
			
			if(isIn(nr,nc) && tmp[nr][nc]) {
				cnt++;
			}
		}
		if(cnt >= 2) {
			return true;
		}
		return false;
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		visited = new boolean[N][M];
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.x+deltas[i][0];
				int nc = p.y+deltas[i][1];
				
				if(isIn(nr,nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					tmp[nr][nc] = true;
					q.add(new Point(nr,nc));
				}
			}
		}
	}
	
	
	public static boolean isIn(int x, int y) {
		return 0<=x && x<N && 0<=y && y<M;
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
