package algorithm.baekjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.17
 * @see https://www.acmicpc.net/problem/1931
 * @performance 42124 kb	496 ms	
 * @category # 그리디
 * @note
 */

public class BAEKJOON_S1_1931_회의실배정 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt, now;
	static Point[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		arr = new Point[N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			
			arr[i] = new Point(s,e);
		}
		
		Arrays.sort(arr);
		
		cnt = 0;
		now = 0;
		
		for(int i=0; i<N; i++) {
			if(now <= arr[i].start) {
				now = arr[i].end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static class Point implements Comparable<Point>{
		int start;
		int end;
		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Point o) {
			if(this.end == o.end) {
				return this.start-o.start;
			}
			
			return this.end-o.end;
		}
		
	}
}
