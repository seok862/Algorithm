package algorithm.baekjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G5_21922_학부연구생민상 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int direction;
	static int[][] map;
	static int R, C;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(input.readLine());
			
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
	}
	
	public static void number1() {
		
	}
}
