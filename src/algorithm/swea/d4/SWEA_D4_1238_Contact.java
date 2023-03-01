package algorithm.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.28
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @performance 20,268 kb	133 ms
 * @category # bfs
 * @note
 */

public class SWEA_D4_1238_Contact {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int length, start;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] check;
	static int max;
	static ArrayList<point> points;
	public static void main(String[] args) throws IOException {
		for(int test_case=1; test_case<=10; test_case++) {
			output.append("#").append(test_case).append(" ");
			
			tokens = new StringTokenizer(input.readLine());
			length = Integer.parseInt(tokens.nextToken());
			start = Integer.parseInt(tokens.nextToken());
			
			tokens = new StringTokenizer(input.readLine());
			graph = new ArrayList<>();
			for(int i=0; i<101; i++) {
				graph.add(new ArrayList<>());
			}
			while(tokens.hasMoreTokens()) {
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				
				graph.get(from).add(to);
			}
			points = new ArrayList<>();
			check = new boolean[101];
			max = Integer.MIN_VALUE;
			bfs();
			
			int maxLv = points.get(points.size()-1).lv;
			
			for(int i=0; i<points.size(); i++) {
				if(points.get(i).lv == maxLv) {
					max = Math.max(max, points.get(i).num);
				}
			}
			output.append(max).append("\n");
		}
		System.out.println(output.toString());
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			cnt++;
			for(int i=graph.get(now).size()-1; i>=0; i--) {
				if(!check[graph.get(now).get(i)]) {
					q.add(graph.get(now).get(i));
					check[graph.get(now).get(i)] = true;
					points.add(new point(cnt,graph.get(now).get(i)));
				}
			}
		}
	}
	
	public static class point implements Comparable<point>{
		int lv;
		int num;
		
		public point(int lv, int num) {
			this.lv = lv;
			this.num = num;
		}

		@Override
		public int compareTo(point o) {
			return this.lv-o.lv;
		}
	}
}
