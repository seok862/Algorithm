package algorithm.baekjoon.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
* @author seok
* @since 2023.05.13
* @see https://www.acmicpc.net/problem/16946
* @performance 	166492 kb	952 ms
* @category # bfs
* @note
*/

public class BOOKJOON_G2_16946_벽부수고이동하기4 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map;
	static int[][] groupMap;
	static Map<Integer, Integer> group;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		groupMap = new int[N][M];
		group = new HashMap<>();
		
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = st.charAt(c)-'0';
			}
		}
		
		int groupCnt = 1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0 && groupMap[r][c] == 0) {
					group.put(groupCnt, bfs(r,c,groupCnt));
					groupCnt++;
				}
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(groupMap[r][c] == 0) {
					output.append(count(r, c));
					continue;
				}
				output.append(0);
			}
			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	static int count(int r,int c) {
		int cnt=1;
		if(map[r][c]==0) return 0;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<4;i++) {
			
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			
			if(!isIn(nr, nc) || groupMap[nr][nc]==0) continue;
			set.add(groupMap[nr][nc]);
			
		}
		for(int size : set) {
			cnt+=group.get(size);
		}
		
		return cnt%10;
	}
	
	public static int bfs(int r, int c, int groupCnt) {
		int cnt = 1;
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		
		q.add(new Point(r,c));
		
		groupMap[r][c] = groupCnt;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nr = p.r+deltas[i][0];
				int nc = p.c+deltas[i][1];
				
				if(!isIn(nr,nc)) continue;
				
				if(groupMap[nr][nc] != 0 || map[nr][nc] != 0) continue;
				
				groupMap[nr][nc] = groupCnt;
				cnt+=1;
				q.add(new Point(nr,nc));
			}
		}
		return cnt;
	}
	
	public static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<= r && r < N && 0 <= c && c < M;
	}
}