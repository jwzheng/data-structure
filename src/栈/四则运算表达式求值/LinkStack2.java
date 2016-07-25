package 栈.四则运算表达式求值;

public class LinkStack2 {
	private StackNode2 top;
	
	public StackNode2 getTop() {
		return top;
	}

	public void setTop(StackNode2 top) {
		this.top = top;
	}

	public void push(StackDate sd){
		StackNode2 sn = new StackNode2();
		sn.setData(sd);
		if(top == null){
			top = sn;
		}else{
			sn.setNext(top);
			top = sn;
		}
	}
	
	public StackDate pop(){
		if(top == null){
			return null;
		}
		
		StackDate data = top.getData();
		top = top.getNext();
		
		return data;
	}
	
	public boolean isEmpty(){
		return top == null ? true : false;
	}
	
}
