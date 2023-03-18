package algorithm.baekjoon.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1. CCTV 클래스 생성
2. map을 만들면서 cctv를 탐색해 cctv리스트에 종류와 좌표 저장
3. cctv리스트의 갯수로 cctv의 방향을 정하는 중복 순열을 만듦
4. 순열이 만들어질 경우 각 cctv의 방향대로 탐색
5. 탐색하면서 확인 가능한 곳은 -1로 교체
6. 0인 갯수를 체크해서 최소값과 비교
*/

/**
 * @author seok
 * @since 2023.03.02
 * @see https://www.acmicpc.net/problem/15683
 * @performance 57612 kb	500 ms
 * @category # 구현
 * @note
 */

public class BAEKJOON_G4_15683_감시 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[][] map;
	static ArrayList<CCTV> CCTVList;
	static int[] choosed;
	static int min;
	static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];
		CCTVList = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());

				if (map[r][c] != 0 && map[r][c] != 6) {
					CCTVList.add(new CCTV(map[r][c], r, c));
				}
			}
		}
		min = Integer.MAX_VALUE;
		choosed = new int[CCTVList.size()];

		makePermutation(0);

		System.out.println(min);
	}

	public static void makePermutation(int lv) {
		if (lv == CCTVList.size()) {
			makeCopyMap();
			return;
		}

		for (int i = 0; i < 4; i++) {
			choosed[lv] = i;
			makePermutation(lv + 1);
		}
	}

	// CCTV리스트에서 하나씩 choosed의 방향으로 탐색
	public static void makeCopyMap() {
		int[][] copyMap = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copyMap[r][c] = map[r][c];
			}
		}

		find(copyMap);

		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copyMap[r][c] == 0)
					cnt++;
			}
		}

		min = Math.min(min, cnt);
	}

	public static void find(int[][] copyMap) {
		for (int i = 0; i < choosed.length; i++) {
			int direction = choosed[i];
			int num = CCTVList.get(i).num;
			int r = CCTVList.get(i).row;
			int c = CCTVList.get(i).col;
			switch (num) {
			case 1:
				switchMap(copyMap, deltas[direction][0], deltas[direction][1], r, c);
				break;
			case 2:
				if (direction == 0 || direction == 2) {
					switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
					switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
				} else {
					switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
					switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
				}
				break;
			case 3:
				if (direction == 0) {
					switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
					switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
				} else if (direction == 1) {
					switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
					switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
				} else if (direction == 2) {
					switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
					switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
				} else {
					switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
					switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
				}
				break;
			case 4:
				if (direction == 0) {
					switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
					switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
					switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
				} else if (direction == 1) {
					switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
					switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
					switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
				} else if (direction == 2) {
					switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
					switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
					switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
				} else {
					switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
					switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
					switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
				}
				break;
			case 5:
				switchMap(copyMap, deltas[0][0], deltas[0][1], r, c);
				switchMap(copyMap, deltas[1][0], deltas[1][1], r, c);
				switchMap(copyMap, deltas[2][0], deltas[2][1], r, c);
				switchMap(copyMap, deltas[3][0], deltas[3][1], r, c);
				break;
			}
		}

	}

	public static void switchMap(int[][] copyMap, int deltaX, int deltaY, int x, int y) {
		int idx = 1;
		while (true) {
			int nx = x + deltaX * idx;
			int ny = y + deltaY * idx++;

			if (!isIn(nx, ny) || copyMap[nx][ny] == 6)
				break;
			if (isIn(nx, ny)) {
				if (copyMap[nx][ny] == 0)
					copyMap[nx][ny] = -1;
			}
		}
	}

	public static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

	public static class CCTV {
		int num;
		int row;
		int col;

		public CCTV(int num, int row, int col) {
			this.num = num;
			this.row = row;
			this.col = col;
		}
	}
}
