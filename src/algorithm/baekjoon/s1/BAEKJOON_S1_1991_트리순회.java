package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S1_1991_트리순회 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		map = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = tokens.nextToken().charAt(0)-'A'+1; 
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
//		f(1);
		
	}
	
//	public static void f(int r) {
//		if(r==6) {
//			return;
//		}
//		
//		if(map[r][1] > 0) {
//			f(map[r][1]);
//			System.out.print((char)(r+64));
//		}
//		
//		
//		if(map[r][2] > 0) {
//			f(map[r][2]);
//			System.out.print((char)(r+64));
//		}
//		
//		
//	}
	
}
