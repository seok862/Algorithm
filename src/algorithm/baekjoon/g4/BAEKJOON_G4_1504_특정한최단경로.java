package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.05
 * @see https://www.acmicpc.net/problem/1504
 * @performance 57436 kb	472 ms
 * @category # 다익스트라
 * @note
 */

public class BAEKJOON_G4_1504_특정한최단경로 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, E;
	static int[][] map;
	static int v1, v2;
	static int INF = 200000000;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 0; i < E; i++) {
			tokens = new StringTokenizer(input.readLine());

			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());

			map[a][b] = c;
			map[b][a] = c;
		}
		tokens = new StringTokenizer(input.readLine());
		v1 = Integer.parseInt(tokens.nextToken());
		v2 = Integer.parseInt(tokens.nextToken());

		long ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		long ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

		if (ans1 >= INF && ans2 >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(ans1, ans2));
		}
	}

	public static int dijkstra(int start, int end) {
		// 거리를 저장하기 위한 배열
		int[] distance = new int[N + 1];

		// 최소값으로 비교하여 갱신하기 위해 최대값으로 초기화
		Arrays.fill(distance, INF);

		// 방문처리를 하기 위한 배열 생성
		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 출발지점 초기화
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		// 모든 정점을 대상으로 해야하기 때문에 정점의 갯수만큼 for문을 돌아야함
		while(!pq.isEmpty()) {
			// 출발점에서 갈 수 있는 정점 중 가장 작은 값을 탐색

			Node head = pq.poll();
			
			if (visited[head.idx]) {
				continue;
			}

			// 찾으려는 노드에 최소값으로 방문할 경우 탈출
			if (head.idx == end) {
				break;
			}

			// 아니면 정점을 사용
			visited[head.idx] = true;

			// 위에서 현재 선택한 정점을 경유지로 해서 갈 수 있는 다른 방문하지 않은 정점과의 비용 중 최소값 비교
			for (int i = 1; i <= N; i++) {
				// 어차피 비용이 갱신되었기 때문에 visited[i] 조건 생략 가능
				if (map[head.idx][i] > 0 && distance[i] > distance[head.idx] + map[head.idx][i]) {
                    distance[i] = distance[head.idx] + map[head.idx][i];
                    pq.offer(new Node(i, distance[i]));
                }

			}
		}
		return distance[end];
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int acost;
		
		public Node(int idx, int acost) {
			this.idx = idx;
			this.acost = acost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.acost, o.acost);
		}
	}
}
