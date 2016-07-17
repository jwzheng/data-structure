package 线性表.静态链表;

import java.util.Arrays;

import common.Array;

public class Main {

	public static void main(String[] args) {
		StaticLinkList staticArray = new StaticLinkList();
		staticArray.init();
		
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		for(int i = 0; i < num.length; ++i)
		{
			staticArray.insert(i+1, num[i]);
		}
		
		staticArray.show();
		
//		System.out.println(staticArray.deleteElem(3));
		System.out.println(staticArray.insert(5, 100));
		staticArray.show();

	}
}
