package 串.朴素的模式匹配;

public class Main {

	public static void main(String[] args) {
		String bStr = "tobeornottobe";
		String sStr = "toee";
		
		System.out.println(index(bStr, sStr, 0));
	}

	/**
	 * 朴素的模式匹配
	 * @param bStr 大串
	 * @param sStr 小串
	 * @param start 大串开始的下标
	 * @return 返回大串中第一个匹配的子串的第一个字符下标，找不到则返回-1
	 */
	private static int index(String bStr, String sStr, int start) {
		int i = 0;
		
		while(start < bStr.length() && i < sStr.length()){    //循环条件：大串小串下标不出界
			if(bStr.charAt(start) == sStr.charAt(i)){
				++i;
				++start;
			}else{
				start = start - i + 1;   //大串下标归位并移到下一位
				i = 0;                   //小串下标归位
			}
		}
		
		if(i >= sStr.length()){          //循环结束后,若小串下标出界，则说明匹配成功
			return start - i;			 //计算匹配到的子串的第一个下标
		}else{
			return -1;
		}
	}

}
