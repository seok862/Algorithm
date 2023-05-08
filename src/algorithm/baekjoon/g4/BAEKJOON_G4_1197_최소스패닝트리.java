package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_G4_1197_최소스패닝트리 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V, E;
	static int sum;
	static List<ArrayList<Edge>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		visited = new boolean[V+1];
		sum = 0;
		list = new ArrayList<>();
		for(int i=0; i<V+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int t=0; t<E; t++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			list.get(a).add(new Edge(b,c));
			list.get(b).add(new Edge(a,c));
		}
		
		prim();
		System.out.println(sum);
	}
	
	public static void prim() {
		Queue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(1, 0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int edge = e.b;
			int weight = e.c;
			
			if(visited[edge]) continue;
			
			visited[edge] = true;
			sum += weight;
			
			for(Edge next: list.get(edge)) {
				if(!visited[next.b]) {
					pq.add(next);
				}
			}
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int b;
		int c;
		public Edge(int b, int c) {
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
		
	}
}
