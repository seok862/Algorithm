package algorithm.beakjoon.g5;

/**
 * @author seok
 * @since 2023.03.05
 * @see https://www.acmicpc.net/problem/1717
 * @performance 51220 kb	360 ms
 * @category # 유니온 파인드
 * @note
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G5_1717_집합의표현 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[] repres;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		makeSet();

		for (int test_case = 0; test_case < M; test_case++) {
			tokens = new StringTokenizer(input.readLine());
			int kind = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());

			if (kind == 0) {
				union(a, b);
			} else {
				if (isSameParent(a, b)) {
					output.append("YES").append("\n");
				} else {
					output.append("NO").append("\n");
				}
			}
		}
		System.out.println(output.toString());
	}

	public static void makeSet() {
		repres = new int[N + 1];
		for (int i = 1; i < repres.length; i++) {
			repres[i] = i;
		}
	}

	public static int findSet(int a) {
		if (repres[a] == a) {
			return a;
		}
		return repres[a] = findSet(repres[a]);
	}

	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);

		if (a != b) {
			if(a<b) {
				repres[b] = a;
			}else {
				repres[a] = b;
			}
		}
	}
	
	public static boolean isSameParent(int a, int b) {
        a = findSet(a);
        b = findSet(b);
 
        if (a == b) {
            return true;
        }
        return false;
    }
}
