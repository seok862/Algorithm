package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.31
 * @see https://www.acmicpc.net/problem/15644
 * @performance	11704 kb	76 ms	
 * @category # bfs
 * @note
 */

public class BAEKJOON_G1_15644_구슬탈출3 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static char[][] map;
	static boolean[][][][] visited;
	static int result = -1;
	static String result2 = "";
	static Point red, blue;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static String[] dir = {"U","D","L","R"};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		visited = new boolean[N][M][N][M];
		map = new char[N][M];
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			
			for(int c=0; c<M; c++) {
				map[r][c] = st.charAt(c);
				
				if(map[r][c] == 'R') {
					red = new Point(r,c,0,"");
				}else if(map[r][c] == 'B') {
					blue = new Point(r,c,0,"");
				}
			}
		}
		
		bfs();
		
		System.out.println(result);
		if(result != -1) {
			System.out.println(result2);
		}
	}
	
	public static void bfs() {
		Queue<Point> redQ = new LinkedList<>();
		Queue<Point> blueQ = new LinkedList<>();
		
		redQ.offer(red);
		blueQ.offer(blue);
		
		visited[red.r][red.c][blue.r][blue.c] = true;
		
		while(!redQ.isEmpty() && !blueQ.isEmpty()) {
			Point redBall = redQ.poll();
			Point blueBall = blueQ.poll();
			
			if(redBall.cnt > 10) {
				result = -1;
				return;
			}
			
			if(map[blueBall.r][blueBall.c] == 'O') {
				continue;
			}
			
			if(map[redBall.r][redBall.c] == 'O') {
				result = redBall.cnt;
				result2 = redBall.dir;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int br = blueBall.r;
				int bc = blueBall.c;
				
				while(true) {
					br += deltas[i][0];
					bc += deltas[i][1];
					
					if(map[br][bc] == 'O') break;
					
					else if(map[br][bc] == '#') {
						br -= deltas[i][0];
						bc -= deltas[i][1];
						break;
					}
				}
				
				int rr = redBall.r;
				int rc = redBall.c;
				
				while(true) {
					rr += deltas[i][0];
					rc += deltas[i][1];
					
					if(map[rr][rc] == 'O') break;
					
					else if(map[rr][rc] == '#') {
						rr -= deltas[i][0];
						rc -= deltas[i][1];
						break;
					}
				}
				
				if(br == rr && bc == rc && map[br][bc] != 'O') {
					int rlen = Math.abs(redBall.r-rr)+Math.abs(redBall.c-rc);
					int blen = Math.abs(blueBall.r-rr)+Math.abs(blueBall.c-rc);
					
					if(rlen > blen) {
						rr -= deltas[i][0];
						rc -= deltas[i][1];
					}
					
					else {
						br -= deltas[i][0];
						bc -= deltas[i][1];
					}
				}
				
				if(!visited[rr][rc][br][bc]) {
					visited[rr][rc][br][bc] = true;
					
					redQ.offer(new Point(rr,rc,redBall.cnt+1, redBall.dir+dir[i]));
					blueQ.offer(new Point(br,bc,blueBall.cnt+1, blueBall.dir+dir[i]));
				}
			}
			
		}
	}
	
	public static class Point{
		int r;
		int c;
		int cnt;
		String dir;
		public Point(int r, int c, int cnt, String dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
