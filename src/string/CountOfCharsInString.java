package string;

import java.util.HashMap;
import java.util.Map;

public class CountOfCharsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcfcbauccaaaab";
		//String input = " ";
		Map<Character, Integer> output = CountOfCharsInString.countChars(input);
		output.forEach((K, V) -> System.out.println("Key is :" + K + ", " + "Count is :" + V));
	}

	public static Map<Character, Integer> countChars(String input) {
		input = input.trim();
		if (input.length() != 0 && null != input) {
			Map<Character, Integer> map = new HashMap();
			for (int i = 0; i < input.length(); i++) {
				Integer count = 1;
				if (map.containsKey(input.charAt(i))) {
					map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
				} else {
					map.put(input.charAt(i), count);
				}
			}
			return map;
		} else {
			throw new NullPointerException("Provide an input Value");
		}
	}

}
