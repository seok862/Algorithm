package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_G4_17069_파이프옮기기2 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map;
	static Point[][] dp;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		dp = new Point[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], new Point(0,0,0));
		}
		
		dp[1][1] = new Point(0,0,0);
		dp[1][2] = new Point(1,0,0);
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				long num1 = dp[r][c-1].a+dp[r][c-1].c;
				long num2 = dp[r-1][c].b+dp[r-1][c].c;
				long num3 = dp[r-1][c-1].a+dp[r-1][c-1].b+dp[r-1][c-1].c;
				
				if((r==1 && c==1) || (r==1 && c==2)) continue;
				
				if(map[r][c] == 1) continue;
				
				if(map[r-1][c] == 1) {
					num2 = 0;
					num3 = 0;
				}
				
				if(map[r][c-1] == 1) {
					num1 = 0;
					num3 = 0;
				}
				
				dp[r][c] = new Point(num1, num2, num3);
				
			}
		}
		
		System.out.println(dp[N][N].a+dp[N][N].b+dp[N][N].c);
	}
	
	public static class Point{
		long a;	// 가로
		long b;	// 세로
		long c;	// 대각
		public Point(long a, long b, long c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Point [a=" + a + ", b=" + b + ", c=" + c + "]";
		}
		
	}
}
