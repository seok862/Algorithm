import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex{
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[] arr= {'a','b','c','d','e'};
	public static void main(String[] args) {
//		makePermutation(0,new char[3], new boolean[arr.length]);
		
//		makeCombination(0, new char[3], 0);
		
		powerSet(0, new boolean[arr.length]);
	}
	
	static void makePermutation(int lv, char[] choosed, boolean[] check ) {
		if(lv == choosed.length) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				choosed[lv] = arr[i];
				check[i] = true;
				makePermutation(lv+1, choosed, check);
				check[i] = false;
			}
		}
	}
	
	static void makeCombination(int lv, char[] choosed, int startIdx) {
		if(lv == choosed.length) {
			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for(int i=startIdx; i<arr.length; i++) {
			choosed[lv] = arr[i];
			makeCombination(lv+1,choosed,i+1);
		}
	}
	
	static void powerSet(int lv, boolean[] check) {
		if(lv == check.length) {
			for(int i=0; i<check.length; i++) {
				if(check[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		check[lv] = true;
		powerSet(lv+1, check);
		check[lv] = false;
		powerSet(lv+1, check);
	}
}