package algorithm.swea.d5;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class SWEA_D5_1247_최적경로 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Point[] point; 
	static Point start,end;
	static int minSum, sum,N;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			output.append("#").append(t).append(" ");
			N = Integer.parseInt(input.readLine());
			
			point = new Point[N];
			
			tokens = new StringTokenizer(input.readLine());
			minSum = Integer.MAX_VALUE;
			sum = 0;
			start = new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
			end = new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
			for(int i=0; i<N; i++) {
				
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				
				point[i] = new Point(x,y);
			}
			
			make(0, start.x, start.y , 0, new boolean[N]);
			
			output.append(minSum).append("\n");
		}
		System.out.println(output.toString());
	}
	
	public static void make(int lv, int nowx, int nowy, int sum, boolean[] visited) {
		if(lv==N) {
			sum +=  Math.abs(nowx-end.x)+Math.abs(nowy-end.y);
			minSum = Math.min(minSum, sum);
			return;
		}
		
		for(int i=0; i<point.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int dist = sum+Math.abs(nowx-point[i].x)+Math.abs(nowy-point[i].y);
				
				make(lv+1,point[i].x,point[i].y, dist, visited);
				
				visited[i] = false;
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
