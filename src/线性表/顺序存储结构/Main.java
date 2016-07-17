package 线性表.顺序存储结构;

public class Main {

	public static void main(String[] args) {
		MyArray num = new MyArray();
		num.init();
		num.show();
		
//		System.out.println(num.getElem(1));
//		System.out.println(num.insert(7, 10));
		System.out.println(num.deleteElem(6));
		num.show();
	}

}
