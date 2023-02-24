package algorithm.beakjoon.g5;
/**
 * [키워드]
 * 친구 관계를 가진 사람이 존재하는지 구해보려고 한다 => 연결되어 있는 노드가 있는지 확인
 *  
 * [풀이과정]
 * 1. 연결된 노드가 5개여야 하기 때문에 깊이탐색을 통해 접근
 * 2. 여러 노드 중 하나의 노드에서 출발
 * 3. 해당 노드의 깊이가 5가 되면 친구 관계가 있다고 판단
 * 4. 1출력하고 시스템 종료
 * 5. 모두 돌았을때 깊이가 5가 되지 않으면 0 출력
 * 
 * [입력]
 * 
 * [출력] 
 * 
 * @author seok
 * @since 2023.02.24
 * @see https://www.acmicpc.net/problem/13023
 * @performance 22756 kb	232 ms
 * @category # dfs 
 * @note
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEKJOON_G5_13023_ABCDE {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static ArrayList<ArrayList<Integer>> list;
	static int N, M, ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, 0);
		}

		System.out.println(0);
	}

	public static void dfs(int x, int lv) {
		if (lv == 4) {
			System.out.println(1);
			System.exit(0);
		}

		for(int next:list.get(x)) {
			if(!visited[next]) {
				visited[next]=true;
				dfs(next,lv+1);
				visited[next]=false;
			}
		}
	}

}
