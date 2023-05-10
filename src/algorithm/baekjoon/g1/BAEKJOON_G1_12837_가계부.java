package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.10
 * @see https://www.acmicpc.net/problem/12837
 * @performance 64048 kb	460 ms
 * @category # 세그먼트 트리
 * @note
 */

public class BAEKJOON_G1_12837_가계부 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, Q;
	static long[] tree;
	static int treeSize;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken()); // 살아온 날
		Q = Integer.parseInt(tokens.nextToken()); // 쿼리 수

		// log2(N)
		int height = (int) Math.ceil(Math.log(N) / Math.log(2));
		
		treeSize = (int) Math.pow(2, height + 1);
		
		tree = new long[treeSize];
		
		for (int i = 0; i < Q; i++) {
			tokens = new StringTokenizer(input.readLine());

			int op = Integer.parseInt(tokens.nextToken());
			int p = Integer.parseInt(tokens.nextToken());
			int x = Integer.parseInt(tokens.nextToken());

			if (op == 1) {
				update(1, 1, N, p, x);
			} else {
				long number = sum(1, 1, N, p, x);
				output.append(number).append("\n");
			}
		}
		System.out.println(output);
	}

	public static void update(int node, int left, int right, int target, int value) {

		// 변경할 값이 범위 밖이면 스킵
		if (target < left || right < target) {
			return;
		}

		// 변경된 값만큼 해당 노드에 추가
		tree[node] += value;

		// leaf 노드에 다다르기 까지 모든 노드의 값을 바꿔야 하므로 지속 진행

		if (left != right) {
			int middle = (left + right) / 2;
			update(node * 2, left, middle, target, value); // 좌측노드
			update(node * 2 + 1, middle + 1, right, target, value); // 우측노드
		}
	}
	
	public static long sum(int node, int left, int right, int start, int end) {
		// 범위 밖이면 스킵
		if (end < left || right < start) {
			return 0;
		}
		
		// 범위 안에 완전히 들어올 경우 아래는 확인하지 않아도 됨 (이미 다 더해져있기 때문에)
		if (start <= left && right <= end) {
			return tree[node];
		}

		
		int middle = (left + right) / 2;
		return sum(node * 2, left, middle, start, end) + sum(node * 2 + 1, middle + 1, right, start, end);
	}
}
