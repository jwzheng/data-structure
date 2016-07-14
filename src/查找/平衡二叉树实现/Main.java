package 查找.平衡二叉树实现;

public class Main {

	public static void main(String[] args) {
		int[] a = {62,88,58,47,35,73,51,99,37,93};   //要加入平衡二叉树的结点数据
		
		BiTree bt = new BiTree();           //平衡二叉树
		bt.insert(a);
		
		bt.show();
	}
	
}
