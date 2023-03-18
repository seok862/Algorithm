package algorithm.baekjoon.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.23
 * @see https://www.acmicpc.net/problem/15686
 * @performance 63612 kb	504 ms
 * @category # 자료구조 맵
 * @note
 */

public class BAEKJOON_S4_17219_비밀번호찾기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, M;
	static Map<String, String> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			map.put(tokens.nextToken(), tokens.nextToken());
		}

		for (int i = 0; i < M; i++) {
			String st = input.readLine();
			output.append(map.get(st)).append("\n");
		}
		System.out.println(output.toString());

	}
}