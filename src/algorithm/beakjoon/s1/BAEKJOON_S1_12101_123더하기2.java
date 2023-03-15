package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_S1_12101_123더하기2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K;
	static int sum;
	static boolean[] visited;
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		sum = 0;
		
		dfs(new ArrayList<Integer>());
	}
	
	public static void dfs(ArrayList list) {
		if(sum == N) {
			
		}
		
		for(int i=3; i>=1; i--) {
			
		}
	}
}
