package 排序.快速排序;

import java.util.Arrays;

import common.Array;

/**
 * 快速排序
 * 是目前排序算法里面最快的
 * 不过当数组元素数量小的时候，效率反倒没有直插排序高
 * @author jw_zheng
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		
		quickSort(num);
		Array.show(num);
	}

	private static void quickSort(int[] num) {
//		qSort1(num, 1, num.length);
		qSort2(num, 1, num.length);
	}

	/**
	 * 改进版
	 * @param num
	 * @param low
	 * @param high
	 */
	private static void qSort2(int[] num, int low, int high) {
		while(low < high){
			int pivot = partition2(num, low, high);
			qSort2(num, low, pivot-1);
			low = pivot+1;                         //改进为尾递归，减少一层递归深度
		}
	}
	
	/**
	 * 基础版
	 * @param num
	 * @param low
	 * @param high
	 */
	private static void qSort1(int[] num, int low, int high) {
		if(low < high){
			int pivot = partition1(num, low, high);
			qSort1(num, low, pivot-1);
			qSort1(num, pivot+1, high);
		}
	}

	/**
	 * 改进版选取中心点
	 * @param num
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition2(int[] num, int low, int high) {
		int m = low + (high-low)/2;             //获取序列中心下标
		if(num[low-1] > num[high-1]){           //跟m， high相比，将low下标的元素调整为最小，避免选取到的中心点左右失衡，降低性能
			Array.swap(num, low-1, high-1);     //相当于随机选取3个元素，取中值，可以避免low的元素为最小或最大
		}
		if(num[m-1] > num[high-1]){
			Array.swap(num, high-1, m-1);
		}
		if(num[low-1] < num[m-1]){
			Array.swap(num, low-1, m-1);
		}
		
		int temp = num[low-1];
		
		while(low < high){
			while(low < high && temp < num[high-1]){
				--high;
			}
			num[low-1] = num[high-1];
			while(low < high && num[low-1] < temp){
				++low;
			}
			num[high-1] = num[low-1];
		}
		num[low-1] = temp;
		return low;
	}

	/**
	 * 基础版选取中心点
	 * @param num
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition1(int[] num, int low, int high) {
		int temp = num[low-1];                   //直接选取序列第一个元素
		
		while(low < high){
			while(low < high && temp < num[high-1]){
				--high;
			}
			Array.swap(num, low-1, high-1);         //采用元素交换的方式降低了效率
			while(low < high && num[low-1] < temp){
				++low;
			}
			Array.swap(num, low-1, high-1);
		}
		
		return low;
	}

}
