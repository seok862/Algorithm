package algorithm.baekjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BAEKJOON_S2_15663_N과M_9 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static Integer[] arr;
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
	
		arr = new Integer[N];
		
		tokens = new StringTokenizer(input.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
		
		arr = set.toArray(new Integer[0]);
		
		make(0, new int[M], new boolean[arr.length]);
		
		System.out.println(output);
	}
	
	public static void make(int lv, int[] choosed, boolean[] visited) {
		if (lv == choosed.length) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choosed[lv] = arr[i];
                make(lv + 1, choosed, visited);
                visited[i] = false;
            }
        }

	}
}
