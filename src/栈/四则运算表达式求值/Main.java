package 栈.四则运算表达式求值;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String zhongzui = sc.nextLine();
		String houzui = Convert2.convert(zhongzui);   //中缀转后缀
		
		System.out.println(houzui);
		System.out.println(Count2.count(houzui));     //计算后缀
		
	}

}
