package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 
 * [풀이과정]
 * 
 * [입력]
 * 
 * [출력]
 * 
 * @author seok
 * @since 2023.03.02
 * @see https://www.acmicpc.net/problem/1753
 * @performance 127400 kb 1160 ms
 * @category # 다익스트라
 * @note
 */
public class BAEKJOON_G4_1753_최단경로 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V, E, start;
	static ArrayList<ArrayList<Point>> graph;
	static int[] accumCost;
	static PriorityQueue<Point> pq;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());

		start = Integer.parseInt(input.readLine());

		accumCost = new int[V + 1];

		graph = new ArrayList<>();

		pq = new PriorityQueue<>();

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(input.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());

			graph.get(u).add(new Point(v, w));
		}

		Arrays.fill(accumCost, INF);
		pq.add(new Point(start, 0));
		accumCost[start] = 0;

		int min, current;
		while (!pq.isEmpty()) {

			Point p = pq.poll();

			current = p.idx;
			min = p.num;

			for (int j = 0; j < graph.get(current).size(); j++) {
				int index = graph.get(current).get(j).idx;
				int number = graph.get(current).get(j).num;
				if (accumCost[index] > min + number) {
					pq.add(new Point(index, accumCost[index] = min + number));
				}
			}
		}
		for (int i = 1; i < accumCost.length; i++) {
			System.out.println(accumCost[i] != INF ? accumCost[i] : "INF");
		}
	}

	public static class Point implements Comparable<Point> {
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
