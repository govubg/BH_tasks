package BH;

import java.util.Scanner;

public class armstrong_to_user {
	
		public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Please enter the Number to check for Arm Strong");
		    int number=sc.nextInt();
		    boolean result = is_Arm_Strong_Number(number);
		    if(result==true) {
		        System.out.println("Yes number is Arm Strong number");
		    }
		    else
		        System.out.println("No number is not an Arm Storng number");
		}
		public static boolean is_Arm_Strong_Number(int number) {
		    int armTest=0;
		    int count=count_Digits_In_Number(number);
		    System.out.println(count+" it is digit count of number");
		    System.out.println();
		    int originalNumber=number;
		    while(number>0) {
		        int Lastdigit=number%10;
		        int poweredDigit=power_Of_Digit(Lastdigit, count);
		        System.out.println(poweredDigit+" is the power of digit "+Lastdigit+"  with power to "+count);
		        armTest=armTest+poweredDigit;
		        number=number/10;
		    }
		    System.out.println();
		    System.out.println(armTest+" is obtained by Arm Strong test");
		    System.out.println(originalNumber+" is original number");
		    System.out.println();
		    if(armTest==originalNumber) {
		    return true;
		    }
		    else {
		    return false;
		    }
		}
		public static int count_Digits_In_Number(int number) {
		    int count=0;
		    while(number>0) {
		        int Lastdigit=number%10;
		        number=number/10;
		        count++;
		    }
		    return count;
		}
		public static int power_Of_Digit(int number,int count) {
		    int power=1;
		    while(count>0) {
		        power=power*number;
		        count--;
		    }
		    return power;
		}
}
