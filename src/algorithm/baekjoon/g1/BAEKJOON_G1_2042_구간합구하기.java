package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.04.04
 * @see https://www.acmicpc.net/problem/2042
 * @performance 109544 kb	508 ms
 * @category # 세그먼트 트리
 * @note
 */

public class BAEKJOON_G1_2042_구간합구하기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static long N,M,K;
	static long[] arr;
	static long[] tree;
	static long start ;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		// 입력이 들어오는 숫자의 갯수
		N = Long.parseLong(tokens.nextToken());
		// 변경이 일어나는 횟수
		M = Long.parseLong(tokens.nextToken());
		// 구간의 합을 구하는 횟수
		K = Long.parseLong(tokens.nextToken());
		
		// 트리 높이
		long h = (long)Math.ceil(Math.log(N)/Math.log(2));
		
		start = (long)Math.pow(2, h);
		// 트리의 길이 설정
		tree = new long[(int) (start*2)];
		
		long end = start+N;
		
		for(long i=start; i<end; i++) {
			tree[(int) i] = Long.parseLong(input.readLine());
		}
		
		// 자식을 이용해서 트리 채우기
		for(int i=tree.length-1; i>=1; i--) {
			tree[i/2] += tree[i];
		}
		
		for(long i=0; i<M+K; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			long b = Long.parseLong(tokens.nextToken());
			long c = Long.parseLong(tokens.nextToken());
		
			if(a == 1) {
				changeValue(start+b-1,c);
			}else {
				output.append(getSum(start+b-1,start+c-1)).append("\n");
			}
		}
		
		System.out.println(output);
		
	}
	
	// 값 변경하기
	static void changeValue(long l, long val) {
		long diff = val-tree[(int) l];
		for(long i=l; i>=1; i/=2) {
			tree[(int) i] += diff;
		}
	}
	
	// 구간합 구하기
	static long getSum(long l, long o) {
		long sum = 0;
		while (l <= o) {
			if(l % 2 == 0) {
				l /= 2;
			}else {
				sum += tree[(int) l];
				l = (l+1)/2;
			}
			
			if(o%2==0) {
				sum += tree[(int) o];
				o = (o-1)/2;
			}else {
				o/=2;
			}
		}
		return sum;
	}
	
}
