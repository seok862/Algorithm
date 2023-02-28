package algorithm.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_3124_최소스패닝트리 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	static void makeSet() {
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());

			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				tokens = new StringTokenizer(input.readLine());
				edgeList[i] = new Edge(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			}
			
			Arrays.sort(edgeList);
			
			makeSet();
			
			long result = 0, count = 0;
			
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++count == V-1) break;
				}
			}
			
			output.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(output.toString());
	}
}
