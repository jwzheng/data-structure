package 线性表.静态链表;

public class StaticLinkList {
	public static final int MaxSize = 1000;
	
	/**
	 * 数组最后一个元素的游标用来存放链表第一个结点下标
	 * 数组第一个元素的游标用来存放链表第一个备用链表结点下标
	 * 最后一个已用结点的cur为0
	 * 第一个元素cur为0，说明链表没有空间了
	 */
	StaticLinkListNode[] array = new StaticLinkListNode[MaxSize];
	
	public void init(){
		for(int i = 0; i < MaxSize-2; ++i){
			StaticLinkListNode s = new StaticLinkListNode();
			s.cur = i+1;               //数组第一个元素游标指向第一个备用链表结点，第一个备用链表结点指向第二个，以此类推
			array[i] = s;
		}
		StaticLinkListNode s = new StaticLinkListNode();
		array[MaxSize-1] = s;    //数组最后一个元素的游标指向第一个元素
		s = new StaticLinkListNode();
		array[MaxSize-2] = s;       //最后一个备用链表结点cur应指向第一个元素
	}
	
	/**
	 * 提供空间
	 * @return
	 */
	public int malloc(){
		int i = array[0].cur;    //拿到备用链表第一个结点
		if(array[0].cur != 0){   
			array[0].cur = array[i].cur;    //更新指向备用链表第一个结点的游标
		}
		
		return i;
	}
	
	/**
	 * 计算链表长度
	 * @return
	 */
	public int length(){
		int count = 0;
		int i = array[MaxSize-1].cur;
		while(i != 0){
			i = array[i].cur;
			count++;
		}
		
		return count;
	}
	
	/**
	 * 插入结点
	 * @param i
	 * @param e
	 * @return
	 */
	public boolean insert(int i, int e){
		if(i < 1 || i > length() + 1){
			return false;
		}
		
		int j = malloc();
		if(j != 0){
			array[j].data = e;
			int k = MaxSize-1;
			for(int l = 1; l <= i-1; ++l){
				k = array[k].cur;
			}
			array[j].cur = array[k].cur;
			array[k].cur = j;
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 删除结点
	 * @param i
	 * @return
	 */
	public Integer deleteElem(int i){
		if(i < 1 || i > length()){
			return null; 
		}
		
		int k = MaxSize-1;
		for(int j = 1; j <= i-1; ++j){
			k = array[k].cur;
		}
		int p = array[k].cur;
		array[k].cur = array[p].cur;
		
		array[p].cur = array[0].cur;    //将删除掉的结点回收，加进备用链表
		array[0].cur = p;
		
		return array[p].data;
	}
	
	/**
	 * 遍历打印静态链表
	 */
	public void show(){
		int i = array[MaxSize-1].cur;
		while(i != 0){
			System.out.print(array[i].data+" ");
			i = array[i].cur;
		}
	}
}
