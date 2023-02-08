public class ex {
	static String[] arr = { "a", "b", "c", "d" };
	static String[] choosed = new String[3];
	static boolean[] check = new boolean[4];
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		make(0, 0);

		System.out.println(output.toString());
	}

	public static void make(int lv, int num) {
		if (lv == choosed.length) {
			for (String s : choosed) {
				output.append(s).append(" ");
			}
			output.append("\n");
			return;
		}

		for (int i = num; i < arr.length; i++) {
			choosed[lv] = arr[i];
			make(lv + 1, i + 1);
		}
	}
}
