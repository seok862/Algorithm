package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.31
 * @see https://www.acmicpc.net/problem/2239
 * @performance 134420 kb	432 ms
 * @category # 재귀
 * @note
 */

public class BAEKJOON_G4_2239_스도쿠 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static ArrayList<Point> list;
	public static void main(String[] args) throws IOException {
		map = new int[9][9];
		
		list = new ArrayList<Point>();
		
		for(int i=0; i<9; i++) {
			String tmp = input.readLine();
			
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(tmp.substring(j,j+1));
			
				if(map[i][j] == 0) list.add(new Point(i,j));
			}
		}
		
		make(0);
	}
	
	public static void make(int lv) {
		
		if(list.size() == lv) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int x = list.get(lv).x; 
		int y = list.get(lv).y;
		
		boolean[] check = new boolean[10];
		
		for(int i=0; i<9; i++) {
			if(map[x][i] != 0) {
				check[map[x][i]] = true;
			}
		}
		for(int i=0; i<9; i++) {
			if(map[i][y] != 0) {
				check[map[i][y]] = true;
			}
		}
		
		int x2 = (x/3)*3;
		int y2 = (y/3)*3;
		for(int i=x2; i<x2+3; i++) {
			for(int j=y2; j<y2+3; j++) {
				if(map[i][j] != 0) {
					check[map[i][j]] = true;
				}
			}
		}
		
		for(int i=1; i<10; i++) {
			if(!check[i]) {
				map[x][y] = i;
				make(lv+1);
				map[x][y] = 0;
			}
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
