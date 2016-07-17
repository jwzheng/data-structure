package 线性表.单链表;

/**
 * 单链表
 * @author jw_zheng
 *
 */
public class LinkList {
	private Node head = new Node();

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * 获取结点
	 * @param i
	 * @return
	 */
	public Integer getElem(int i){
		Node p = head.next;
		int count = 1;
		while(p != null && count < i){   //i要是大于链表长度，p=null
			p = p.next;
			++count;
		}
		
		if(p == null || count > i){     //count>i是为了避免i=0的情况
			return null;
		}
		
		return p.data;
	}
	
	/**
	 * 插入结点
	 * @param i
	 * @param e
	 * @return
	 */
	public boolean insert(int i, int e){
		Node p = head;                   //指向头结点，i相当于原来的i-1
		int count = 1;
		while(p != null && count < i){   //i可以等于链表长度+1，此时p为最后一个结点
			p = p.next;
			++count;
		}
		
		if(p == null || count > i){     //count>i是为了避免i=0的情况
			return false;
		}
		
		Node s = new Node();
		s.data = e;
		s.next = p.next;
		p.next = s;
		
		return true;
	}
	
	/**
	 * 删除结点
	 * @param i
	 * @return
	 */
	public Integer deleteElem(int i){
		Node p = head;                   //指向头结点，i相当于原来的i-1
		int count = 1;
		while(p != null && count < i){   
			p = p.next;
			++count;
		}
		
		if(p.next == null || count > i){   //count>i是为了避免i=0的情况,p.next=null避免i=链表长度+1的情况
			return null;
		}
		
		int temp = p.next.data;
		p.next = p.next.next;
		
		return temp;
	}
	
	/**
	 * 头插法创建链表
	 * @param num
	 */
	public void createListhead(int[] num){
		for(int i = 0; i < num.length; ++i){
			Node s = new Node();
			
			s.data = num[i];
			s.next = head.next;
			head.next = s;
		}
	}
	
	/**
	 * 尾插法创建链表
	 * @param num
	 */
	public void createListTail(int[] num){
		Node tail = head;
		for(int i = 0; i < num.length; ++i){
			Node s = new Node();
			
			s.data = num[i];
			tail.next = s;
			tail = s;
		}
	}
	
	/**
	 * 遍历打印链表
	 */
	public void show(){
		Node p = head.next;
		while(p != null){
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println();
	}
	
}
