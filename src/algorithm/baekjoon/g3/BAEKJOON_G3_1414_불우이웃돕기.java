package algorithm.baekjoon.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G3_1414_불우이웃돕기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
   	
	static int N, sum;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N][N];
		
		for(int r=0; r<N; r++) {
			String st = input.readLine();
			for(int c=0; c<N; c++) {
				int n = st.charAt(c)-96;
				sum += n;
				if(r==c) continue;
				arr[r][c] = n;
			}
		}
		
		
	}
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		public Edge(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.b, o.b);
		}
	}
}
