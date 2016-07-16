package 排序.直接插入排序;

import java.util.Arrays;

import common.Array;

/**
 * 直接插入排序
 * 基本操作是将一个记录插入到已经排好序的有序表中，从而得到一个新的，记录数增加1的有序表
 * 性能比冒泡和选择好一点
 * @author jw_zheng
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		
		insertSort(num);
		Array.show(num);
	}

	/**
	 * 直接插入排序
	 * @param num
	 */
	private static void insertSort(int[] num) {
		for(int i = 1; i < num.length; ++i){
			if(num[i] < num[i-1]){
				int temp = num[i];
				int j;
				for(j = i - 1; j >= 0 && temp < num[j] ; --j){
					num[j+1] = num[j];
				}
				num[j+1] = temp;
			}
		}
	}

}
