package algorithm.beakjoon.g4;

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
public class BAEKJOON_G4_15683_감시 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M;
	static int[][] map;
	static ArrayList<CCTV> CCTVList;
	static int[] choosed; 
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		CCTVList = new ArrayList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c] != 0 && map[r][c] != 6) {
					CCTVList.add(new CCTV(map[r][c],r,c));
				}
			}
		}
		
		choosed = new int[CCTVList.size()];
		
		makePermutation(0);
	}
	public static void makePermutation(int lv) {
		if(lv == CCTVList.size()) {
			return;
		}
		
		for(int i=0; i<4; i++) {
			choosed[lv] = i;
			makePermutation(lv+1);
		}
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
