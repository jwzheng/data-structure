package 队列.顺序存储结构;

public class Main {

	public static void main(String[] args) {
		SqQueue qu = new SqQueue();
		
		qu.enQueue(0);
		qu.enQueue(2);
		qu.enQueue(3);
		qu.enQueue(4);
		qu.enQueue(5);
		qu.enQueue(6);
		
		System.out.println(qu.length());
		System.out.println(qu.deQueue());
		System.out.println(qu.deQueue());
		System.out.println(qu.deQueue());
		System.out.println(qu.deQueue());
		System.out.println(qu.deQueue());
	}

}
