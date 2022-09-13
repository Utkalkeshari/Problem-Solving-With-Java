package string;

public class ReversalOfEachWordInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Utkal Keshari Sahu";
		// String input =null;
		// String input ="";
		System.out.println(ReversalOfEachWordInString.reverseEachWordInString(input));
	}

	public static String reverseEachWordInString(String input) {
		if (null != input && input.length() != 0) {
			StringBuilder result = new StringBuilder();
			String[] words = input.split(" ");
			for (int i = words.length - 1; i >= 0; i--) {
				if (i != 0) {
					result.append(words[i] + " ");
				} else {
					result.append(words[i]);
				}
			}
			return result.toString();
		} else {
			throw new NullPointerException("Please Provide an Value");
		}
	}
}
