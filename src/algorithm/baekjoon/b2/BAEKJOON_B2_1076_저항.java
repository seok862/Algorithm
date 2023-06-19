package algorithm.baekjoon.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author seok
 * @since 2023.06.19
 * @see https://www.acmicpc.net/problem/1076
 * @performance 11564 kb	144 ms
 * @category # 구현
 * @note
 */

public class BAEKJOON_B2_1076_저항 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static String[] arr = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
	
	public static void main(String[] args) throws IOException {
		String st1 = input.readLine();
		String st2 = input.readLine();
		String st3 = input.readLine();
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
		
		int a = list.indexOf(st1)*10;
		int b = list.indexOf(st2);
		long c = list.indexOf(st3);
		
		System.out.println((a+b)*(long)Math.pow(10, c));
	}
}
