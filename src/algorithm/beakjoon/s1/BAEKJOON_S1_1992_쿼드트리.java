package algorithm.beakjoon.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_S1_1992_쿼드트리 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static int size;

	public static void main(String[] args) throws IOException {
		size = Integer.parseInt(input.readLine());
		map = new int[size+1][size+1];

		for (int i = 0; i < size; i++) {
			String st = input.readLine();
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.substring(j, j + 1));
			}
		}

		make(size, size, size);
		
		System.out.println(output.toString());
	}

	public static void make(int r, int c, int size) {
		int n = map[r][c];
		boolean check = true;
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++){
				if(n!=map[r][c]) check = false;;
			}
		}

		if (check) {
			output.append(n);
		} else {
			output.append("(");
			int half = size / 2;

			if (r < half && c < half) {
				make(r, c, half);
			} else if (r < half && c >= half) {
				make(r, c - half, half);
			} else if (r >= half && c < half) {
				make(r - half, c, half);
			} else {
				make(r - half, c - half, half);
			}
		}

	}
}
