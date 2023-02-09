package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BAEKJOON_G5_2023_신기한소수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static List<String> list = new ArrayList<>();
	static int lang;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		lang = 1;
		for(int i=0; i<N; i++) {
			lang *= 10;
		}
		
	}
	
	
	public static void isPrime(int n) {
		for(int i=0; i<Math.sqrt(lang); i++) {
			
		}
	}
}
