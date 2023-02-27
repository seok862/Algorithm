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
	static List<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		people = new int[T];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<T; i++) {
			people[i] = Integer.parseInt(tokens.nextToken());
			sum += people[i];
		}
		
		list = new ArrayList<>();
		
		for(int i=0; i<T; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<T; i++) {
			tokens = new StringTokenizer(input.readLine());
			list.get(i).add(Integer.parseInt(tokens.nextToken()));
		}
		
		
	}
}
