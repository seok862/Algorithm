package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_S1_1697_숨바꼭질 {

	/**
	 * @author seok
	 * @since 2023.02.23
	 * @see https://www.acmicpc.net/problem/1697
	 * @performance 16444 kb	112 ms
	 * @category # bfs
	 * @note
	 */
	
	/*
	 * [핵심 키워드]
	 * 동생을 찾을 수 있는 가장 빠른 시간 (여러가지 경우를 한번에 탐색 - bfs)
	 * 1. start와 end위치를 int로 저장
	 * 2. 방문할 수 있는 모든 경우의 배열을 만듦(0<=x<=100000)
	 * 3. bfs를 시작 위치와 lv을 0으로 호출
	 * 4. Queue를 생성해 시작위치와 lv을 0으로 Point 삽입
	 * 5. 위치가 0이상 100000이하이면서 방문하지 않았을 경우 이동한 위치와 lv+1로 호출
	 * 6. 맨 앞의 Point를 뽑아서 그 위치가 end와 같을 경우 정답에 lv값을 넣고 반복문 탈출
	 */
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int start, end;
	static int cnt, ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		start = Integer.parseInt(tokens.nextToken());
		end = Integer.parseInt(tokens.nextToken());
		ans = 0;
		visited = new boolean[100001];
		bfs(start,0);
		
		System.out.println(ans);
	}
	
	public static void bfs(int x, int lv) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,lv));

		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == end) {
				ans = now.lv;
				break;
			}
			
			if(now.x-1 >= 0 && now.x-1 <= 100000 && !visited[now.x-1]) {
				visited[now.x-1] = true;
				q.add(new Point(now.x-1,now.lv+1));
			}
			if(now.x+1 >= 0 && now.x+1 <= 100000 && !visited[now.x+1]) {
				visited[now.x+1] = true;
				q.add(new Point(now.x+1,now.lv+1));
			}
			if(now.x*2 >= 0 && now.x*2 <= 100000 && !visited[now.x*2]) {
				visited[now.x*2] = true;
				q.add(new Point(now.x*2,now.lv+1));
			}
		}
	}
	
	public static class Point{
		int x;
		int lv;
		public Point(int x, int lv) {
			this.x = x;
			this.lv = lv;
		}
	}
}
