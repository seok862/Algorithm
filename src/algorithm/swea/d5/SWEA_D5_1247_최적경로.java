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
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(input.readLine());
			
			point = new Point[N];
			
			tokens = new StringTokenizer(input.readLine());
			
			start = new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
			end = new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
			for(int i=0; i<N; i++) {
				
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				
				point[i] = new Point(x,y);
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
