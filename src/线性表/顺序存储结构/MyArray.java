package 线性表.顺序存储结构;

public class MyArray {
	/**
	 * 数组总长度
	 */
	public static int MaxSize = 10;
	
	private int[] num = new int[MaxSize+1];
	
	public MyArray(){
		num[0] = 0;           //num[0]用来记录线性表长度
	}
	
	/**
	 * 获取线性表长度
	 * @return
	 */
	public int getLength(){
		return num[0];
	}
	
	/**
	 * 获取元素
	 * @param i
	 * @return
	 */
	public Integer getElem(int i){
		if(getLength() == 0 || i < 1 || i > getLength()){
			return null;
		}
		
		return num[i];
	}
	
	/**
	 * 插入元素
	 * @param i
	 * @param e
	 * @return
	 */
	public boolean insert(int i, int e){
		if(getLength() == MaxSize){        //是否数组满
			return false;
		}
		if(i < 1 || i > getLength() + 1){  //是否越界
			return false;
		}
		
		if(i <= getLength()){
			for(int j = getLength(); j >= i; --j){
				num[j+1] = num[j];
			}
		}
		num[i] = e;
		++num[0];
		
		return true;
	}
	
	/**
	 * 删除元素
	 * @param i
	 * @return
	 */
	public Integer deleteElem(int i){
		if(getLength() == 0 || i < 1 || i > getLength()){
			return null;
		}
		
		int temp = num[i];
		if(i < getLength()){
			for(int j = i+1; j <= getLength(); ++j){
				num[j-1] = num[j];
			}
		}
		--num[0];
		
		return temp;
	}
	
	public void init(){
		for(int i = 1; i <= 5; ++i){
			num[i] = i;
		}
		num[0] = 5;
	}
	
	public void show(){
		for(int i = 1; i <= getLength(); ++i){
			System.out.print(num[i] + " ");
		}
	}

}
