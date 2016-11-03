package algorithms.concepts;

public class RegexImpl {

	public static void main(String[] args) {
		String EXAMPLE_TEST="this is the mai n , t heme";
		String pattern = "(\\w)(\\s+)([\\.,])";
		System.out.println(EXAMPLE_TEST.replaceAll(pattern, "$1$3"));
	}

}
