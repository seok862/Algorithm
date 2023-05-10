package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.05.11
 * @see https://www.acmicpc.net/problem/2357
 * @performance 68124 kb	676 ms
 * @category # 세그먼트 트리
 * @note
 */

public class BAEKJOON_G1_2357_최솟값과최댓값 {

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
		maxTree = new long[treeSize]; 
		arr = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		
		minInit(1,1,N);
		maxInit(1,1,N);
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			long min = min(1,1,N,a,b);
			long max = max(1,1,N,a,b);
			output.append(min).append(" ").append(max).append("\n");
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
	
	public static long max(int node, int left, int right, int start, int end) {
		if(end < left || right < start) {
			return Long.MIN_VALUE;
		}
		
		if(start <= left && right <= end) {
			return maxTree[node];
		}
		
		int mid = (left+right)/2;
		return Math.max(max(node*2, left, mid, start, end), max(node*2+1, mid+1, right, start, end));
	}
	
	public static long minInit(int node, int left, int right) {
		if(left == right) {
			return minTree[node] = arr[left];
		}
		
		int mid = (left+right)/2;
		
		return minTree[node] = Math.min(minInit(node*2, left, mid), minInit(node*2+1 , mid+1, right));
	}
	
	public static long maxInit(int node, int left, int right) {
		if(left == right) {
			return maxTree[node] = arr[left];
		}
		
		int mid = (left+right)/2;
		
		return maxTree[node] = Math.max(maxInit(node*2, left, mid), maxInit(node*2+1 , mid+1, right));
	}
}
