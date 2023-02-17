package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.17
 * @see https://www.acmicpc.net/problem/15686
 * @performance 13864 kb	160 ms
 * @category # 조합
 * @note
 */


public class BAEKJOON_G5_15686_치킨배달 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map;
	static List<point> p;
	static int min;
	static int minSum;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		minSum = Integer.MAX_VALUE;
		map = new int[N+1][N+1];
		p = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j] == 2) p.add(new point(i,j));
			}
		}
		
		makeCombination(0,new point[M], 0);
		
		System.out.println(minSum);
	}
	
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static void makeCombination(int lv, point[] choosed, int startIdx) {
		if(lv == choosed.length) {
			int sum = 0;
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(map[i][j] == 1) {
						int min = Integer.MAX_VALUE;
						for(int k=0; k<choosed.length; k++) {
							int length = Math.abs(choosed[k].x - i) + Math.abs(choosed[k].y - j);
							min = Math.min(length, min);
						}
						sum += min;
					}
				}
			}
			minSum = Math.min(sum, minSum);
			return;
		}
		
		for(int i=startIdx; i<p.size(); i++) {
			choosed[lv] = p.get(i);
			makeCombination(lv+1, choosed, i+1);
		}
	}
}
