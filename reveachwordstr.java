package BH;


	class reveachwordstr {
	    public static void reverseEachWordInString(String givenstr) {
	        System.out.println("The given string is: " + givenstr);
	        String gvnstrsplit[] = givenstr.split(" ");
	        String revString = "";
	        for (int i = 0; i < gvnstrsplit.length; i++) {
	            String word = gvnstrsplit[i];
	            String reverseWord = "";
	            for (int j = word.length() - 1; j >= 0; j--) {
	                reverseWord = reverseWord + word.charAt(j);
	            }
	            revString = revString + reverseWord + " ";
	        }
	        System.out.println("The string reversed word by word is: "+revString);
	    }
	    public static void main(String[] args) {
	        reverseEachWordInString("This is a test string");
	    }
}
