package string;

public class ReversalOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Utkal Keshari Sahu";
		// String input =null;
		// String input ="";
		System.out.println(ReversalOfString.reverseString(input));
	}

	public static String reverseString(String input) {
		if (null != input && input.length() != 0) {
			StringBuilder result = new StringBuilder();
			for (int i = input.length() - 1; i >= 0; i--) {
				result.append(input.charAt(i));
			}
			return result.toString();
		} else {
			throw new NullPointerException("Please Provide an Value");
		}
	}

}
