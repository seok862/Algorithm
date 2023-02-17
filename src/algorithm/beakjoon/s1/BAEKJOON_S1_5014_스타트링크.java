package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.17
 * @see https://www.acmicpc.net/problem/5014
 * @performance 55080 kb	160 ms
 * @category # 그래프 탐색 bfs
 * @note
 */

public class BAEKJOON_S1_5014_스타트링크 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int F,S,G,U,D;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		F = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		G = Integer.parseInt(tokens.nextToken());
		U = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		
		arr = new int[F+1];
		
		System.out.println(bfs(F,S,G,U,D));
	}
	
	public static String bfs(int f, int s, int e, int u, int d) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		// 시작 = 1
		arr[s] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 정확히 목표층에 도착했을때
			if(now == e) {
				return String.valueOf(arr[now]-1);
			}
			
			// 위로 올라갈 때 최고층을 넘지 않는 경우
			if(now + u <= f) {
				// 무한루프를 피하기 위해 해당 층에 들리지 않았어야 한다.
				if(arr[now + u] == 0) {
					arr[now + u] = arr[now]+1;
					q.add(now+u);
				}
			}
			
			// 아래로 내려갈 때 1층 이상이어야 한다.
			if(now-d > 0) {
				// 무한루프를 피하기 위해 해당 층에 들리지 않았어야 한다.
				if(arr[now - d] == 0) {
					arr[now - d] = arr[now]+1;
					q.add(now-d);
				}
			}
		}
		return "use the stairs";
	}
}
