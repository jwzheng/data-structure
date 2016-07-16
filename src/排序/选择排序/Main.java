package 排序.选择排序;

import java.util.Arrays;

import common.Array;

/**
 * 选择排序
 * 在排序的时候找到合适的关键字再做交换，只移动一次就完成相应关键字的排序定位
 * 性能比冒泡好一点
 * @author jw_zheng
 *
 */
public class Main {
	
	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		simpleSelectSort(num);
		
		Array.show(num);
	}

	/**
	 * 简单选择排序
	 * @param num
	 */
	private static void simpleSelectSort(int[] num) {
		for(int i = 0; i < num.length - 1; ++i){
			int min = i;
			for(int j = i + 1; j < num.length; ++j){
				if(num[j] < num[min]){
					min = j;
				}
			}
			if(min != i){
				Array.swap(num, min, i);
			}
		}
	}
	
}
