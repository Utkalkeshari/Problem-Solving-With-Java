package string;

import java.util.ArrayList;
import java.util.List;

public class PalindromeProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String input = "12221";
		String input = "aBcba";
		System.out.println("Input is Palidrome :" + PalindromeProgram.determinePalindrome(input));
	}

	public static boolean determinePalindrome(String input) {

		if (null != input) {
			String trimmedInput = input.trim();
			if (trimmedInput.length() != 0) {
				StringBuilder reversedInput = new StringBuilder();
				for (int i = input.length() - 1; i >= 0; i--) {
					reversedInput.append(input.charAt(i));
				}
				if (reversedInput.toString().equalsIgnoreCase(input)) {
					return true;
				} else {
					return false;
				}

			} else {
				throw new NullPointerException("Please Provide an Input");
			}
		} else {
			throw new NullPointerException("Please Provide an Input");
		}

	}

}
