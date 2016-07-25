package 栈.四则运算表达式求值;

public class LinkStack {
	private StackNode top;
	
	public StackNode getTop() {
		return top;
	}

	public void setTop(StackNode top) {
		this.top = top;
	}

	public void push(Object data){
		StackNode sn = new StackNode();
		sn.setData(data);
		
		if(top == null){
			top = sn;
		}else{
			sn.setNext(top);
			top = sn;
		}
	}
	
	public Object pop(){
		if(top == null){
			return null;
		}
		
		Object data = top.getData();
		top = top.getNext();
		
		return data;
	}
	
	public boolean isEmpty(){
		return top == null ? true : false;
	}
	
}
