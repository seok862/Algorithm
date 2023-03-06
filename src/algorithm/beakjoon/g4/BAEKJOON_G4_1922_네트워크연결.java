package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.06
 * @see https://www.acmicpc.net/problem/1922
 * @performance 46828 kb	536 ms
 * @category # 크루스칼
 * @note
 */

public class BAEKJOON_G4_1922_네트워크연결 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static long sum;
	static int[] repres;
	static Edge[] EdgeArr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		repres = new int[N+1];
		makeSet();
		EdgeArr = new Edge[M];
		sum = 0;
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			EdgeArr[i] = new Edge(a,b,c);
		}
		
		Arrays.sort(EdgeArr);
		
		for(int i=0; i<M; i++) {
			Edge e = EdgeArr[i];
			
			if(union(e.a, e.b)) {
				sum += e.c;
			}
		}
		
		System.out.println(sum);
	}
	public static void makeSet() {
		for(int i=1; i<N+1; i++) {
			repres[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(repres[a] ==a ) {
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
