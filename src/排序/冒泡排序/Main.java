package 排序.冒泡排序;

import java.util.Arrays;

import common.Array;

public class Main {

	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
//		bubbleSort1(num);
//		bubbleSort2(num);
		bubbleSort(num);
		Array.show(num);
	}
	
	/**
	 * 改进的冒泡排序
	 * 增加flag，每次开始新的循环前设为false，循环过程中要是发生了交换，flag设为true
	 * 避免了有序的情况下无意义的循环判断
	 * @param num
	 */
	private static void bubbleSort(int[] num) {
		boolean flag = true;
		for(int i = 0; i < num.length - 1 && flag; ++i){
			flag = false;
			for(int j = num.length - 1; j > i; --j){
				if(num[j] < num[j-1]){
					Array.swap(num, j, j-1);
					flag = true;
				}
			}
		}
	}

	/**
	 * 正确的冒泡排序
	 * 重点在相邻的两个数比较
	 * @param num
	 */
	private static void bubbleSort2(int[] num) {
		for(int i = 0; i < num.length - 1; ++i){
			for(int j = num.length - 1; j > i; --j){
				if(num[j] < num[j-1]){
					Array.swap(num, j, j-1);
				}
			}
		}
	}

	/**
	 * 冒泡排序初级版
	 * 其实并不是冒泡排序
	 * 会把小的数排在后面造成性能降低
	 * @param num
	 */
	private static void bubbleSort1(int[] num) {
		for(int i = 0; i < num.length - 1; ++i){
			for(int j = i + 1; j < num.length; ++j){
				if(num[i] > num[j]){
					Array.swap(num, i, j);
				}
			}
		}
	}

	

}
