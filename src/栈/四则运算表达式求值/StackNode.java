package 栈.四则运算表达式求值;

public class StackNode {
	private Object data;
	private StackNode next;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	
}
