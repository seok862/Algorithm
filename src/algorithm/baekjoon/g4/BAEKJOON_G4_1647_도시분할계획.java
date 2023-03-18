package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.06
 * @see https://www.acmicpc.net/problem/1647
 * @performance 331716 kb	2236 ms
 * @category # 크루스칼
 * @note
 */

public class BAEKJOON_G4_1647_도시분할계획 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static long sum;
	static int[] repres;
	static Edge[] EdgeArr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		sum = 0;
		
		repres = new int[N+1];
		EdgeArr = new Edge[M];
		
		makeSet();
		
		for(int test_case=0; test_case<M; test_case++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
		
			EdgeArr[test_case] = new Edge(a,b,c);
		}
		
		Arrays.sort(EdgeArr);
		int max = 0;
		int maxidx = 0;
		for(int i=0; i<EdgeArr.length; i++) {
			Edge e = EdgeArr[i];
			
			if(union(e.a, e.b)) {
				sum += e.c;
				max = e.c;
			}
		}
		
		System.out.println(sum-max);
	}
	
	public static void makeSet() {
		for(int i=1; i<=N; i++) {
			repres[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(repres[a] == a) {
			return a;
		}else {
			return repres[a] = findSet(repres[a]);
		}
	}
	
	public static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a==b) {
			return false;
		}else {
			repres[a] = b;
			return true;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		
		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
	}
}
