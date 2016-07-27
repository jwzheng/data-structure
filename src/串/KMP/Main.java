package 串.KMP;

/**
 * KMP算法，可以通过举几个例子观察得出大串下标可以不回溯，小串下标通过next数组指导回溯。
 * next数组的构建，有递归的思想在里面。
 * next数组中，0下标规定为-1。在小串第一个元素匹配失败，根据朴素模式匹配，大串下标和小串下标都得加1，因此，为-1时大小串下标加1。
 * 			1下标很容易可以得出为0，小串1下标之前只有一个元素，没有前后缀的概念，此时小串下标应该回溯到第一个下标即0。
 * 推导next数组，可以从前缀下标i=1,后缀下标j=0开始。在推导小串某下标以前的前后缀时，可以看成是利用朴素模式匹配去匹配相同的两个小串。
 * 			T[i]==T[j],根据朴素可以知道需要++i，++j。此时i来到了要求前后缀的下标中，根据next的含义可以知道该下标对应的next为j
 * 			要是T[i]!=T[j],利用已经构建好的一部分next数组，查找到此时j应该为多少，继续比较。
 * 个人看法：next数组的构建是通过朴素模式匹配的方法，加上递归
 * @author jw_zheng
 */
public class Main {

	public static void main(String[] args) {
		String sStr = "abcjs";
		String bStr = "acbsabcjaabcjsabasde";
		
		System.out.println(KMP(bStr, sStr, 0));
		
	}
	
	private static int KMP(String bStr, String sStr, int pos) {
		int[] next = new int[sStr.length()];
		int j = 0;
		
		getNext(sStr, next);
		
		while(pos < bStr.length() && j < sStr.length()){
			if(j == -1 || bStr.charAt(pos) == sStr.charAt(j)){
				++pos;
				++j;
			}else{
				j = next[j];
			}
		}
		
		if(j >= sStr.length()){
			return pos-sStr.length();
		}
		return -1;
	}

	private static void getNext(String s, int[] next){
		next[0] = -1;
		int i = 0;      //后缀下标
		int j = -1;		//前缀下标
		
		while(i < s.length()-1){
			if(j == -1 || s.charAt(i) == s.charAt(j)){
				++i;
				++j;
				if(s.charAt(i) != s.charAt(j)){     //如果相等，再找下一位
					next[i] = j;
				}else{
					next[i] = next[j];
				}
			}else{
				j = next[j];
			}
		}
	}

}
