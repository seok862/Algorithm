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
	
	public static void main(String[] args) throws IOException {
		map = new char[12][6];
		for(int r=0; r<12; r++) {
			String st = input.readLine();
			for(int c=0; c<6; c++) {
				map[r][c] = st.charAt(c);
			}
		}
		
		
	}
}
