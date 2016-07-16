package 排序.堆排序;

import java.util.Arrays;

import common.Array;

/**
 * 堆排序
 * 堆：一种完全二叉树。每个节点的值都大于或等于左右孩子结点值，称为大顶堆，或者每个结点值都小于等于左右孩子结点值，称为小顶堆。
 * 将无序序列看成一棵完全二叉树的中序遍历结果，对这棵树进行堆构建，再将根移到最后一个结点，去除该结点重新对根进行堆构建，直到树结点树为1。
 * 性能比希尔排序好
 * 不适合用在元素少的序列上
 * @author jw_zheng
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] num = Arrays.copyOf(Array.num, Array.num.length);
		
		heapSort(num);
		Array.show(num);
	}

	/**
	 * 堆排序
	 * 此堆排序使用大顶堆
	 * @param num
	 */
	private static void heapSort(int[] num) {
		for(int i = num.length / 2; i > 0; --i){
			heapAdjust(num, i, num.length);
		}
		
		for(int i = num.length; i > 1; --i){
			Array.swap(num, 0, i-1);
			heapAdjust(num, 1, i-1);
		}
	}

	/**
	 * 堆构建的方法
	 * @param num 
	 * @param s 需要进行堆构建的子树的根
	 * @param m 当前树的结点数
	 */
	private static void heapAdjust(int[] num, int s, int m) {
		int temp = num[s-1];                  //数组是从下标0开始的，所以所有数组操作下标都减1
		for(int i = s * 2; i <= m; i *= 2){
			if(i < m && num[i-1] < num[i]){
				++i;
			}
			if(temp >= num[i-1])
				break;
			num[s-1] = num[i-1];
			s = i;
		}
		num[s-1] = temp;
	}

}
