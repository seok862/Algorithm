package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_G4_2157_여행 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,K;
	static Point[] arr;
	static dpPoint[][] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		arr = new Point[K+1];
		
		Arrays.fill(arr, new Point(0,0,0));
		
		dp = new dpPoint[N+1][N+1];
		
		visited = new boolean[N+1];
		visited[1] = true;
		
		for(int i=0; i<N+1; i++) {
			Arrays.fill(dp[i], new dpPoint(0,1));
		}
	
		for(int i=1; i<K+1; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			int score = Integer.parseInt(tokens.nextToken());
			arr[i] = new Point(s,e,score);
		}
		
		Arrays.sort(arr);
		
		
		for(int i=1; i<K+1; i++) {
			int s = arr[i].start;
			int e = arr[i].end;
			int score = arr[i].score;
			
			if(s>e) continue;
			if(dp[s][e].num > score) continue;	
			
			arr[i] = new Point(s,e,score);
			
			if(dp[s][e].num < score) {
				int n = dp[s-1][s].num;
				if(visited[s]) {
					dp[s][e] = new dpPoint(score+n, dp[s-1][s].cnt+1);
					visited[e] = true;
				}
			}
		}
		
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[i].length; j++) {
				System.out.print(dp[i][j].num+","+dp[i][j].cnt+" ");
			}
			System.out.println();
		}

		int max = 0;
		for(int i=1; i<N+1; i++) {
			if(dp[i][N].cnt <= M) {
				max = Math.max(dp[i][N].num, max);
			}
		}
		
		System.out.println(max);
	}
	
	public static class dpPoint{
		int num;
		int cnt;
		public dpPoint(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	public static class Point implements Comparable<Point>{
		int start;
		int end;
		int score;
		public Point(int start, int end, int score) {
			super();
			this.start = start;
			this.end = end;
			this.score = score;
		}
		@Override
		public int compareTo(Point o) {
			return this.start - o.start;
		}
	}
}
