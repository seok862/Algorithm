package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.03.07
 * @see https://www.acmicpc.net/problem/6497
 * @performance 240024 kb	772 ms
 * @category # 크루스칼
 * @note
 */

public class BAEKJOON_G4_6497_전력난 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static long sum,tot;
	static int[] repres;
	static Edge[] edges;
	public static void main(String[] args) throws IOException {
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			if(N==0 && M ==0) break;
			
			edges = new Edge[M];
			makeSet();
			tot = 0;
			sum = 0;
			for(int i=0; i<M; i++) {
				tokens = new StringTokenizer(input.readLine());
				
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				int z = Integer.parseInt(tokens.nextToken());
				
				edges[i] = new Edge(x,y,z);
			}
			Arrays.sort(edges);
			
			for(int i=0; i<edges.length; i++) {
				Edge e = edges[i];
				tot += e.c;
				if(union(e.a, e.b)) {
					sum += e.c;
				}
			}
			System.out.println(tot-sum);
		}
	}
	
	static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a==b) {
			return false;
		}else {
			repres[a] = b;
			return true;
		}
	}
	
	static int findSet(int a) {
		if(repres[a] == a) {
			return a;
		}else {
			return repres[a] = findSet(repres[a]);
		}
	}
	
	static void makeSet() {
		repres = new int[N];
		for(int i=0; i<N; i++) {
			repres[i] = i;
		}
	}
	
	static class Edge implements Comparable<Edge>{
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
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
	}
}
