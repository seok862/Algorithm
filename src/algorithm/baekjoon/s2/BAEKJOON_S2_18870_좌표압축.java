package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * @author seok
 * @since 2023.03.21
 * @see https://www.acmicpc.net/problem/18870
 * @performance 383568 kb	1820 ms
 * @category # 정렬
 * @note
 */

public class BAEKJOON_S2_18870_좌표압축 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] arr1;
	static int[] arr2;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		tokens = new StringTokenizer(input.readLine());
		
		arr1 = new int[N];
		arr2 = new int[N];
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			arr1[i] = num;
			arr2[i] = num;
		}
		
		Arrays.sort(arr1);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int idx = 0;
		
		for(int i=0; i<arr1.length; i++) {
			if(!map.containsKey(arr1[i])) {
				map.put(arr1[i], idx++);
			}
		}
		
		for(int i=0; i<arr1.length; i++) {
			output.append(map.get(arr2[i])).append(" ");
		}
		
		System.out.println(output);
		
	}
	
}
