package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G4_11559_PuyoPuyo {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
	static char[][] map;
	static int cnt;
	public static void main(String[] args) throws IOException {
		map = new char[12][6];
		for(int r=0; r<12; r++) {
			String st = input.readLine();
			for(int c=0; c<6; c++) {
				map[r][c] = st.charAt(c);
			}
		}
		
		change();
	}
	
	public static void change() {
		boolean check = false;
		for(int r=11; r>=0; r--) {
			for(int c=5; c>=0; c--) {
				if(map[r][c] != '.');
				cnt = 0;
				check(r,c);
			}
		}
	}
	
	public static void check(int r, int c) {
		
		for(int i=0; i<8; i++) {
			
		}
	}
}
