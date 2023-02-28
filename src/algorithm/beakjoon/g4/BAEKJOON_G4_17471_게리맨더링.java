package algorithm.beakjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.02.27
 * @see https://www.acmicpc.net/problem/17471
 * @performance 
 * @category # 
 * @note
 */
public class BAEKJOON_G4_17471_게리맨더링 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] people;
	static int sum;
	static int min;
	static List<ArrayList<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		people = new int[T];
		
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
			list.get(i).add(Integer.parseInt(tokens.nextToken()));
		}
		
		min = 0;
		
		subSet(0,new boolean[list.size()]);
	}
	
	public static void subSet(int lv, boolean[] visited) {
		if(lv==visited.length) {
			make(visited);
			return;
		}
		
		visited[lv] = true;
		subSet(lv+1,visited);
		visited[lv] = false;
		subSet(lv+1,visited);
	}
	
	public static void make(boolean[] choosed) {
		
		for(int i=0; i<choosed.length; i++) {
			if(choosed[i]) visited[i] = true;
		}
		if(linkCheck()) {
			int num1 = 0;
			int num2 = 0;
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) num1+=people[i];
				else num2+=people[i];
			}
			min = Math.min(min, Math.abs(num1-num2));
		}
	}
	
	public static boolean linkCheck() {
		return dfs(0,0);
	}
	
	public static boolean dfs(int lv, int cnt) {
		if(lv == visited.length) {
			int count = 0;
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) count++;
			}
			if(count == cnt) return true;
		}
		
		for(int i=0; i<visited.length; i++) {
			if(visited[list.get(lv).get(i)]) {
				dfs(lv+1,cnt+1);
			}
		}
		
		return false;
	}
}
