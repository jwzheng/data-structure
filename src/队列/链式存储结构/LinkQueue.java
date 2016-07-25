package 队列.链式存储结构;

public class LinkQueue {
	private QueueNode front = new QueueNode();
	private QueueNode rear = front;

	public QueueNode getFront() {
		return front;
	}
	public void setFront(QueueNode front) {
		this.front = front;
	}
	public QueueNode getRear() {
		return rear;
	}
	public void setRear(QueueNode rear) {
		this.rear = rear;
	}
	
	public boolean isEmpty(){
		return front.getNext() == null;
	}
	
	public void enQueue(int date){
		QueueNode qu = new QueueNode();
		qu.setDate(date);
		rear.setNext(qu);
		rear = qu;
	}
	
	public Integer deQueue(){
		if(isEmpty()){
			return null;
		}
		
		int date = front.getNext().getDate();
		front.setNext(front.getNext().getNext());
		return date;
	}
}
