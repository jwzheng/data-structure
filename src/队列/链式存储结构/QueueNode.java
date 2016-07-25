package 队列.链式存储结构;

public class QueueNode {
	private int date;
	private QueueNode next;

	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public QueueNode getNext() {
		return next;
	}
	public void setNext(QueueNode next) {
		this.next = next;
	}
	
}
