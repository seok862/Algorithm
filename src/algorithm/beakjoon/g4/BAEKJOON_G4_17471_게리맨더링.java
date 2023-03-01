package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.ls.LSOutput;

/**
 * @author seok
 * @since 2023.03.01
 * @see https://www.acmicpc.net/problem/17471
 * @performance 14076 kb	124 ms
 * @category # 그래프
 * @note
 */
public class BAEKJOON_G4_17471_게리맨더링 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] people;
	static int min,T;
	static List<ArrayList<Integer>> list;
	static boolean[] visited;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		people = new int[T];
		visited = new boolean[T];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<T; i++) {
			people[i] = Integer.parseInt(tokens.nextToken());
		}
		
		list = new ArrayList<>();
		
		for(int i=0; i<T; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<T; i++) {
			tokens = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			for(int j=0; j<n; j++) {
				list.get(i).add(Integer.parseInt(tokens.nextToken())-1);
			}
			
		}
		
		min = Integer.MAX_VALUE;
		
		subSet(0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static void subSet(int lv) {
		if(lv==T) {
			make(visited);
			return;
		}
		
		visited[lv] = true;
		subSet(lv+1);
		visited[lv] = false;
		subSet(lv+1);
	}
	
	public static void make(boolean[] choosed) {
		List<Integer> aList = new ArrayList<>();
		List<Integer> bList = new ArrayList<>();
		for(int i=0; i<choosed.length; i++) {
			if(choosed[i]) {
				aList.add(i);
			}else {
				bList.add(i);
			}
		}
		
		if(aList.size() == 0 || bList.size() == 0) return;
		
		if(bfs(aList) && bfs(bList)) {
			int num1 = 0;
			int num2 = 0;
			for(int i=0; i<T; i++) {
				if(visited[i]) num1+=people[i];
				else num2+=people[i];
			}
			min = Math.min(min, Math.abs(num1-num2));
		}
	}
	
	public static boolean bfs(List<Integer> choosed) {
		Queue<Integer> q = new LinkedList<>();
		check = new boolean[T];
		check[choosed.get(0)] = true;
		q.offer(choosed.get(0));
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<list.get(now).size(); i++) {
				int n = list.get(now).get(i);
				if(choosed.contains(n) && !check[n]) {
					q.offer(n);
					check[n] = true;
					cnt++;
				}
			}
		}
		
		if(cnt==choosed.size()) {
			return true;
		}else {
			return false;
		}
		
	}
}
