package arraysutil;

import java.util.Arrays;

public class Issue {

	public static void main(String[] args) {

		String[] s = { "D", "G", "A", "K" };

		Arrays.sort(s);

		int result = Arrays.binarySearch(s, "A");
		System.out.println(result);
	}

}
