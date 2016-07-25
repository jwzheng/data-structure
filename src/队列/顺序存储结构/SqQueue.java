package 队列.顺序存储结构;

public class SqQueue {
	private static final int QueueSize = 5;
	
	private int[] queue = new int[QueueSize];
	private int front;
	private int rear;
	
	public int[] getQueue() {
		return queue;
	}
	public void setQueue(int[] queue) {
		this.queue = queue;
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}
	
	public int length(){
		return (rear-front+QueueSize)%QueueSize;
	}
	
	public boolean isFull(){
		return (rear+1)%QueueSize == front;
	}
	
	public boolean isEmpty(){
		return rear == front;
	}
	
	public boolean enQueue(int date){
		if(isFull()){
			return false;
		}
		
		queue[rear++] = date;
		return true;
	}
	
	public Integer deQueue(){
		if(isEmpty()){
			return null;
		}
		
		int date = queue[front++];
		return date;
	}
	
}
