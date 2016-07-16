package 排序.归并排序;

import java.util.Arrays;

import common.Array;

/**
 * 归并排序
 * 将几个记录都看成一个有序表，两两合并，再两两合并...
 * 效率高，稳定，但比较占内存，时间复杂度和堆排序一样
 * @author jw_zheng
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		
		mergeSort(num);
		Array.show(num);
	}

	/**
	 * 递归版归并排序
	 * @param num
	 */
	private static void mergeSort(int[] num) {
		mSort(num, num, 1, num.length);
	}

	/**
	 * 
	 * @param sr 
	 * @param tr 
	 * @param s 
	 * @param t 
	 */
	private static void mSort(int[] sr, int[] tr, int s, int t) {
		if(s == t){
			tr[s-1] = sr[s-1];
		}else{
			int[] tr2 = new int[sr.length];
			int m = (s+t)/2;
			mSort(sr,tr2,s,m);
			mSort(sr,tr2,m+1,t);
			merge(tr2,tr,s,m,t);
		}
	}

	/**
	 * 合并两个有序表
	 * @param sr
	 * @param tr
	 * @param s
	 * @param m
	 * @param t
	 */
	private static void merge(int[] sr, int[] tr, int s, int m, int t) {
		int i,k;
		for(i = m+1, k = s; s <= m && i <= t; ++k){
			if(sr[s-1] < sr[i-1]){
				tr[k-1] = sr[s-1];
				++s;
			}else{
				tr[k-1] = sr[i-1];
				++i;
			}
		}
		
		if(s <= m){
			for(int j = 0; j <= m-s; ++j){
				tr[k-1+j] = sr[s-1+j];
			}
		}
		
		if(i <= t){
			for(int j = 0; j <= t-i; ++j){
				tr[k-1+j] = sr[i-1+j];
			}
		}
	}

}
