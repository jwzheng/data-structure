package common;

public class Array {
	
	public static int[] num = {0,8,3,2,7,5,9,1,4,6};
	
	/**
	 * 交换数组元素
	 * @param num
	 * @param i
	 * @param j
	 */
	public static void swap(int[] num, int i, int j){
		int temp;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	/**
	 * 遍历打印数组
	 * @param num
	 */
	public static void show(int[] num){
		for(int i = 0; i < num.length; ++i){
			System.out.print(num[i] + " ");
		}
	}
}
