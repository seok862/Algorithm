package algorithm.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 선택할 수 있는 사람들을 부분집합으로 두 그룹으로 나눔
// 각각의 그룹이 들어가는 구멍을 하나씩 선택
// 각각의 사람의 위치와 해당 구멍의 거리 차이를 계산
// 
public class SWEA_SWTEST_2383_점심식사시간 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,N,personCnt;
	static int[][] map;
	static ArrayList<Person> person;
	static ArrayList<Stair> stair;
	static ArrayList<Person> team1;
	static ArrayList<Person> team2;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			output.append("#").append(test_case).append(" ");
			
			N = Integer.parseInt(input.readLine());
			
			map = new int[N][N];
			
			person = new ArrayList<>();
			
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					
					if(map[r][c] == 1) person.add(new Person(r,c));
					else if(map[r][c] != 0) stair.add(new Stair(r,c, map[r][c]));
				}
			}
			
			// 부분조합으로 두팀으로 나누기
			makeTeam(0, new boolean[person.size()]);
		}
	}
	
	public static void makeTeam(int lv, boolean[] check) {
		if(lv == check.length) {
			makeList(check);
			return;
		}
		
		check[lv] = true;
		makeTeam(lv+1, check);
		check[lv] = false;
		makeTeam(lv+1, check);
	}
	
	public static void makeList(boolean[] check) {
		team1 = new ArrayList<>();
		team2 = new ArrayList<>();
		for(int i=0; i<check.length; i++) {
			if(check[i]) {
				Person p = person.get(i);
				p.arrivalTiem = Math.abs(p.r-stair.get(0).r)+Math.abs(p.c-stair.get(0).c);
				team1.add(p);
			}else {
				Person p = person.get(i);
				p.arrivalTiem = Math.abs(p.r-stair.get(1).r)+Math.abs(p.c-stair.get(1).c);
				team2.add(p);
			}
		}
		
		// 팀 별로 시간의 최솟값 계산
		checkTime(team1, stair.get(0));
		
		checkTime(team2, stair.get(1));
	}
	
	
	// 현재 사람의 지점에서 
	public static void checkTime(ArrayList<Person> team, Stair stair) {
		// A팀읜 stair리스트의 1번 계단으로 들어감
		// B팀은 stair리스트의 2번 계단으로 들어감
		
		// 시간 계싼은 도착시간 + 계단 앞에서 대기 시간 + 계싼 내려오는 시간
		// person객체에 도착시간과 계단에 들어오고 지난 시간을 체크
		
		// 계단앞에 대기 시간을 어떻게 구하냐
		// 계단 Queue를 만들어서 사람이 계단에 도착한 시간이 계단사이즈보다 작으면 대기시간 0
		// Queue사이즈가 계단 사이즈보다 작아지면 사람 또 투입
		
		// 도착해있는 사람 리스트를 만들어서 계단 내려갈수 있을때 뺴?
		
		
	}
	
	public static class Stair{
		int r;
		int c;
		int floor;
		public Stair(int r, int c, int floor) {
			super();
			this.r = r;
			this.c = c;
			this.floor = floor;
		}
	}
	
	public static class Person{
		int r;
		int c;
		int stairTime;
		int arrivalTiem;
		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

