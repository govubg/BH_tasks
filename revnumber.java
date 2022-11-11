package BH;

public class revnumber {

	public static void main(String[] args) {
		int rem, sum = 0, num = 657843;
		System.out.println(num + " < num before reverse");
		while (num > 0) {
			rem = num % 10;
			num = num / 10;
			sum = (sum * 10) + rem;
		}
		System.out.println(sum + " < num after reverse");
	}

}
