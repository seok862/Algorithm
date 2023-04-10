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
	static int T,N,personCnt, count, ans, min;
	static int[][] map;
	static ArrayList<Person> person;
	static ArrayList<Stair> stair;
	static ArrayList<Person> inStair;
	static ArrayList<Person> team1;
	static ArrayList<Person> team2;
	static ArrayList<Person> wait;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			output.append("#").append(test_case).append(" ");
			
			N = Integer.parseInt(input.readLine());
			
			person = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			stair = new ArrayList<>();
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					int num = Integer.parseInt(tokens.nextToken());
					
					if(num == 1) person.add(new Person(r,c));
					else if(num != 0) stair.add(new Stair(r,c, num));
				}
			}
			// 부분조합으로 두팀으로 나누기
			makeTeam(0, new boolean[person.size()]);
			
			System.out.println(ans);
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
		ans += min;
		min = 0;
		checkTime(team2, stair.get(1));
		ans += min;
	}
	
	
	// 현재 사람의 지점에서 
	public static void checkTime(ArrayList<Person> team, Stair stair) {
		// 시간이 지날때마다 사람들의 도착시간을 -1
		// 0인 경우 계단에 도착
		// 도착한 사람을 대기자 List에 저장
		// 1초 뒤에 Queue의 size가 3보다 작으면 삽입
		personCnt = team.size();
		inStair = new ArrayList<>();
		wait = new ArrayList<>();
		int nowTime = 1;
		
		while(true) {
			System.out.println("TimeSize:"+team.size());
			System.out.println("wait:"+wait.size());
			System.out.println("personTime:"+personCnt);
			System.out.println(nowTime);
			int size = inStair.size();
			System.out.println(size);
			
			if(personCnt == 0) {
				min = Math.min(min, nowTime);
				return;
			}
			for(int i=size-1; i>=0; i--) {
				Person p = inStair.get(i);
				
				p.stairTime++;
				if(p.stairTime == stair.floor) {
					System.out.println("탈출");
					inStair.remove(i);
					personCnt--;
				}
			}
			
			for(int i=wait.size()-1; i>=0; i--) {
				if(inStair.size() < 3) {
					inStair.add(wait.get(i));
					wait.remove(i);
				}
			}
			
			
			for(int i=team.size()-1; i>=0; i--) {
				if(team.get(i).arrivalTiem == nowTime) {
					wait.add(team.get(i));
					team.remove(i);
				}
			}
			
			nowTime++;
		}
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

