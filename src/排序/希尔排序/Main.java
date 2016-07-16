package 排序.希尔排序;

import java.util.Arrays;

import common.Array;

/**
 * 希尔排序
 * 直插排序的改良
 * 采取跳跃分割的策略，将相距某个增量的记录组成一个子序列
 * @author jw_zheng
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		
		shellSort(num);
		Array.show(num);
	}

	/**
	 * 希尔排序
	 * @param num
	 */
	private static void shellSort(int[] num) {
		int increment = num.length;
		do{
			increment = increment / 3 + 1;          //“3”根据实际情况确定，本例共有9个元素，所以分3组
			for(int i = increment; i < num.length; ++i){     //分别对每组进行直插
				if(num[i] < num[i - increment]){
					int temp = num[i];
					int j;
					for(j = i - increment; j >= 0 && temp < num[j]; j -= increment){
						num[j + increment] = num[j];
					}
					num[j + increment] = temp;
				}
			}
		}while(increment > 1);                 //最后increment会等于1，对整个序列进行直插
	}

}
