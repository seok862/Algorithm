package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_S1_3184_양 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output= new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = st.charAt(c);
			}
		}

		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]=='O' && map[r][c] == 'V' && !visited[r][c]) {
					
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
	}
	
	public static boolean isIn(int x, int y) {
		return 0<= x && x < N && 0<= y && y < M;
	}
}
