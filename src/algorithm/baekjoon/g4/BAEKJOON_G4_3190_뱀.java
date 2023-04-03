package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_G4_3190_뱀 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,K,L;
	static boolean[][] visited;
	static int[][] apple;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static int current;
	static int nowx, nowy, len;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		visited = new boolean[N][N];
		visited[0][0] = true;
		K = Integer.parseInt(input.readLine());
		
		apple = new int[K][2];
		for(int i=0; i<K; i++) {
			tokens = new StringTokenizer(input.readLine());
			// 사과가 있는 자리 = 2
			apple[i][0] = Integer.parseInt(tokens.nextToken());
			apple[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		L = Integer.parseInt(input.readLine());
		current = 0;
		nowx = 0;
		nowy = 0;
		len = 1;
		for(int i=0; i<L; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int X = Integer.parseInt(tokens.nextToken());
			
			for(int j=0; j<X; j++) {
				nowx = nowx + deltas[current][0];
				nowy = nowy + deltas[current][1];
				
				visited[nowx][nowy] = true;

				boolean check = false;
				for(int k=0; k<apple.length; k++) {
					if(apple[k][0] == nowx && apple[k][1] ==nowy) {
						check = true;
					}
				}
				
				if(!check) {
				}
			}
			
		}
	}
}
