package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.10
 * @see https://www.acmicpc.net/problem/15685
 * @performance 12044 kb	88 ms
 * @category # 시뮬
 * @note
 */

public class BAEKJOON_G4_15685_드래곤커브 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,cnt;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	static int[][] deltas = {{0,1},{-1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		map= new int[102][102];
		visited = new boolean[102][102];
		cnt = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int g = Integer.parseInt(tokens.nextToken());
		
			list = new ArrayList<>();
			list.add(d);
			int cnt1 = 0;
			
			for(int j=0; j<g; j++) {
				int a = (int)Math.pow(2, cnt1++);

				int size = list.size();
				
				for(int s = size-1; s>=0; s--) {
					int n = (list.get(s)+1)%4;
					
					list.add(n);
				}
			}
			map[y][x] = 1;
			for(int j=0; j<list.size(); j++) {
				int dir = list.get(j);
				y = y+deltas[dir][0];
				x = x+deltas[dir][1];
				map[y][x] = 1;
			}
		}
		
		
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
