package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_S2_18870_좌표압축 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static Point[] arr;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = new Point(i,Integer.parseInt(tokens.nextToken()));
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			output.append(arr[i]);
		}
	}
	
	public static class Point implements Comparable<Point>{
		int idx;
		int num;
		
		public Point(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, o.num);
		}
		
	}
}
