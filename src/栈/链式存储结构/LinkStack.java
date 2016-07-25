package 栈.链式存储结构;

public class LinkStack {
	
	public StackNode top;
	
	public void push(int data){
		StackNode sn = new StackNode();
		sn.data = data;
		
		if(top == null){
			top = sn;
		}else{
			sn.next = top;
			top = sn;
		}
	}
	
	public Integer pop(){
		if(top == null){
			return null;
		}
		
		int data = top.data;
		top = top.next;
		
		return data;
	}
	
}