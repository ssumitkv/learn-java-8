package javaeight;

import java.util.Scanner;

public class UsingScanner {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		String num1 = scan.nextLine();
		String num2 = scan.nextLine();
		
		System.out.println(message+"\n"+num1+"\n"+num2);
		
	}
		
}
