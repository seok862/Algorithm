package algorithm.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_SWTEST_5644_무선충전 {

	/*
	 * 1. BC의 갯수인 A만큼 for문을 통해 인덱스 각 BC위치를 power 크기로 설정, BC의 번호도 같이 저장 
	 * 2. 이미 숫자가 있을 경우 power의 크기를 비교해서 배열에 저장 
	 * 3. deltas배열을 통해 1,2,3,4에 해당하는 위치 이동 설정 
	 * 4. 위치를 이동했을 때 해당 위치의 배열값을 더함 
	 * 5. 두 사용자의 더해야 하는 배열값이 같을 경우 구역값을 비교하여 같으면 반절씩만 더함 
	 * 6. 두 사용자의 충전량을 각각 구해서 최종 지점에 도달할 경우 더함
	 */

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int M, A;
	static int[] userA;
	static int[] userB;
	static int[] nowA = {1,1}; 
	static int[] nowB = {10,10};
	static boolean[][] map;
	static Pointer[] point;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");

			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			A = Integer.parseInt(tokens.nextToken());

			userA = new int[M];
			userB = new int[M];
			
			
			map = new boolean[11][11];
			point = new Pointer[A];
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<M; i++) {
				userA[i] = Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<M; i++) {
				userB[i] = Integer.parseInt(tokens.nextToken());
			}
			
			for (int i = 1; i <= A; i++) {
				tokens = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				int len = Integer.parseInt(tokens.nextToken());
				int p = Integer.parseInt(tokens.nextToken());
				
				point[i-1] = new Pointer(x,y,len,p);
				int idx = 0;
				
				for (int r = x - len; r <= x; r++) {
					for (int c = y - idx; c <= y + idx; c++) {
						if (isIn(c, r)) {
							map[c][r] = true;
						}
					}
					idx++;
				}

				idx = len - 1;
				for (int r = x + 1; r <= x + len; r++) {
					for (int c = y - idx; c <= y + idx; c++) {
						if (isIn(c, r)) {
							map[c][r] = true;
						}
					}
					idx--;
				}
				
//				map 확인
//				for (int r = 1; r <= 10; r++) {
//					for (int c = 1; c <= 10; c++) {
//						System.out.print(map[r][c] + "\t");
//					}
//					System.out.println();
//				}
			}
			
			for(int i=0; i<M; i++) {
				int usera = userA[i];
				int userb = userB[i];
				
				nowA[0] = nowA[0]+deltas[usera][0];
				nowA[1] = nowA[1]+deltas[usera][1];
				nowB[0] = nowB[0]+deltas[usera][0];
				nowB[1] = nowB[1]+deltas[usera][1];
				
				
				if(map[nowA[0]][nowA[1]]) {
					search(nowA[0],nowA[1]);
				}
			}
			
		}
	}

	public static void search(int x, int y) {
		for(int i=0; i<A; i++) {
			if(point[i].len == (int)(Math.abs(point[i].x-x)+Math.abs(point[i].y-y))) {
				
			}
		}
	}
	public static boolean isIn(int x, int y) {
		return 0 < x && x <= 10 && 0 < y && y <= 10;
	}

	public static class Pointer {
		int x;
		int y;
		int len;
		int power;

		public Pointer(int x, int y, int len, int power) {
			super();
			this.x = x;
			this.y = y;
			this.power = power;
		}
	}
}
