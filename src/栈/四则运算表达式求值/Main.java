package 栈.四则运算表达式求值;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String zhongzui = sc.nextLine();
		String houzui = Convert.convert(zhongzui);
		
		System.out.println(Count.count(houzui));
		
	}

}
