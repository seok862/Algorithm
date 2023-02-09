package algorithm.beakjoon.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_S2_2961_도영이가만든맛있는음식 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static int[] arr;
	static int[] materials;
	static int[] arr2;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());

		materials = new int[T];
		arr2 = new int[T];
		check = new boolean[T];

		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			materials[t] = Integer.parseInt(tokens.nextToken());
			arr2[t] = Integer.parseInt(tokens.nextToken());
		}

		arr = new int[T];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}


	}
	
	static void subSet(int toCheck, boolean[] status) {
		if(toCheck == T) {
			int sour = 1;
			int bitter = 0;
			for(int i=0; i<status.length; i++) {
				if(status[i]) {
				}
			}
		}
		
		status[toCheck] = true;
		subSet(toCheck+1,status);
		status[toCheck] = false;
		subSet(toCheck+1,status);
	}
	
	static class Material{
		int sour;
		int bitter;
		
		public Material(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
}