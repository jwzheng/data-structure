package 栈.顺序存储结构;

/**
 * 顺序栈
 * @author jw_zheng
 *
 */
public class SqStack {
	public static final int MaxSize = 100;
	
	public int[] num = new int[MaxSize];
	public int top = -1;
	
	/**
	 * 入栈
	 * @param n
	 * @return
	 */
	public boolean push(int n){
		if(top >= MaxSize - 1){
			return false;
		}
		
		num[++top] = n;
		return true;
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public Integer pop(){
		if(top < 0){
			return null;
		}
		
		return num[top--];
	}
}
