package algorithm.beakjoon.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 2중for문으로 각 나라끼리의 매치를 만듦
// 2. i번 나라가 승이 있을 경우 i번째 나라의 승과 j번째 나라의 패를 -1씩 함
// 3. i번 나라가 패가 있을 경우 i번째 나라의 패와 j번째 나라의 승을 -1씩 함
// 4. 끝까지 돌았을 때 i번째 나라의 승과 패가 0이 아닌 경우 false
// 5. d를 가지고 있는 팀의 수가 홀수이면 false
public class BAEKJOON_G5_6987_월드컵 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,M,cnt;
	static int W,D,L,drawCount;
	static country[] arr;
	static int[][] map;
	static boolean check;
	public static void main(String[] args) throws IOException {
		for(int t=0; t<4; t++) {
			tokens = new StringTokenizer(input.readLine());
			arr = new country[6];
			
			drawCount = 0;
			for(int i=0; i<6; i++) {
				int w = Integer.parseInt(tokens.nextToken());
				int d = Integer.parseInt(tokens.nextToken());
				int l = Integer.parseInt(tokens.nextToken());
				
				arr[i] = new country(w,d,l);
			}
			
			map = new int[15][2];
			
			int idx = 0;
			for(int i=0; i<6; i++) {
				for(int j=i+1; j<6; j++) {
					map[idx][0] = i;
					map[idx][1] = j;
					idx++;
				}
			}
			
			check = true;
			
			make(0);
			
			if(check) {
				output.append("1").append(" ");
			}else {
				output.append("0").append(" ");
			}
			
		}
		System.out.println(output);
	}
	public static void make(int lv) {
		if(arr[map[lv][0]].win + arr[map[lv][0]].draw + arr[map[lv][0]].lose != 5) {
			check = false;
			return;
		}
		
		if(lv==15) {
			check = true;
			return;
		}
		
		int t1 = map[lv][0];
		int t2 = map[lv][1];
		
		if(arr[t1].win > 0 && arr[t2].lose > 0) {
			arr[t1].win--;
			arr[t2].lose--;
			make(lv+1);
			arr[t1].win++;
			arr[t2].lose++;
		}
		if(arr[t1].lose > 0 && arr[t2].win > 0) {
			arr[t1].lose--;
			arr[t2].win--;
			make(lv+1);
			arr[t1].lose++;
			arr[t2].win++;
		}
		if(arr[t1].draw > 0 && arr[t2].draw > 0) {
			arr[t1].draw--;
			arr[t2].draw--;
			make(lv+1);
			arr[t1].draw++;
			arr[t2].draw++;
		}
		
	}
	public static class country{
		int win;
		int draw;
		int lose;
		
		public country(int win, int draw, int lose) {
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}
	}
}
