package algorithm.beakjoon.g5;
/**
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/18428
 * @performance 22756 kb	232 ms
 * @category # dfs 
 * @note
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_G5_18428_감시피하기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] map;
	static String ans;
	static int N;
	static Point[] pArr;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = tokens.nextToken().charAt(0);
			}
		}
		ans = "YES";
		
	}
	
	public static void dfs(int lv) {
		if(lv == 3) {
			pArr = new Point[3];
			int n = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 'T') {
						pArr[n++] = new Point(i,j);
					}
				}
			}
			
			for(int i=0; i<pArr.length; i++) {
				dfs2(pArr[i], 0);
			}
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(lv+1);
					map[i][j] = 'X';
				}
			}
		}
	}
	
	public static void dfs2(Point p, int lv) {
		if(lv == 3) {
			ans = "YES";
		}
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
