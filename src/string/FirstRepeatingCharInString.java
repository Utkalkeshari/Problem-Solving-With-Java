package string;

import java.util.ArrayList;
import java.util.List;

public class FirstRepeatingCharInString {
	public static void main(String[] args) {
		char result = FirstRepeatingCharInString.findRepeatedChar("ehdiwheilf");
		if (result == 'F') {
			System.out.println("No Repetation");
		} else {
			System.out.println("The repeating char is:" + result);
		}
	}

	public static char findRepeatedChar(String input) {
		if (null != input) {
			String trimmedInput = input.trim();
			if (trimmedInput.length() != 0) {
				List<Character> charList = new ArrayList();
				for (int i = 0; i < trimmedInput.length() - 1; i++) {
					if (charList.contains(trimmedInput.charAt(i))) {
						return trimmedInput.charAt(i);
					} else {
						// add unique charecters to the list
						charList.add(trimmedInput.charAt(i));
					}
				}
				return 'F';
			} else {
				throw new NullPointerException("Please Provide an Input");
			}
		} else {
			throw new NullPointerException("Please Provide an Input");
		}
	}
}
