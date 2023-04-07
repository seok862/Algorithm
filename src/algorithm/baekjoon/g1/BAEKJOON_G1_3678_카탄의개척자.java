package algorithm.baekjoon.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEKJOON_G1_3678_카탄의개척자 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N;
	static int[] arr;
	static int[][] map;
	static int num, nowx, nowy;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static Delta[] deltas = {new Delta(0,1,1),new Delta(1,1,0),new Delta(1,0,1),new Delta(0,-1,1),new Delta(-1,-1,1),new Delta(-1,0,1)};
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new int[N];
		
		for(int t=0; t<N; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			arr[t] = Integer.parseInt(tokens.nextToken());
		}
		
		map = new int[200][200];

		map[100][100] = 1;
		
		num = 1;
		nowx = 100;
		nowy = 100;
		
		makeMap();
		
	}
	
	public static void makeMap() {
		
	}
	
	public static class Delta{
		int r;
		int c;
		int lv;
		public Delta(int r, int c, int lv) {
			this.r = r;
			this.c = c;
			this.lv = lv;
		}
	}
}
