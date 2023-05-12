package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.12
 * @see https://www.acmicpc.net/problem/10868
 * @performance 57348 kb	504 ms	
 * @category # 세그먼트 트리
 * @note
 */

public class BAEKJOON_G1_10868_최솟값 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, treeSize;
	static long[] arr,minTree, maxTree;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		int height = (int) Math.ceil(Math.log(N) / Math.log(2));

		treeSize = (int) Math.pow(2, height + 1);

		minTree = new long[treeSize]; 
		arr = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		minInit(1,1,N);
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			long min = min(1,1,N,a,b);
			output.append(min).append("\n");
		}
		System.out.println(output);
	}
	public static long min(int node, int left, int right, int start, int end) {
		if(end < left || right < start) {
			return Long.MAX_VALUE;
		}
		if(start <= left && right <= end) {
			return minTree[node];
		}
		
		int mid = (left+right)/2;
		return Math.min(min(node*2, left, mid, start, end), min(node*2+1, mid+1, right, start, end));
	}
	
	public static long minInit(int node, int left, int right) {
		if(left == right) {
			return minTree[node] = arr[left];
		}
		
		int mid = (left+right)/2;
		
		return minTree[node] = Math.min(minInit(node*2, left, mid), minInit(node*2+1 , mid+1, right));
	}
	
}