package 二叉树.四种遍历;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("ABD##E##C##");
		
		BTree tree = new BTree();
		tree.createTree(null, null, sb);
		tree.preOrderTraverse(tree.getRoot());
//		tree.inOrderTraverse(tree.getRoot());
//		tree.levelOrderTraverse(tree.getRoot());
//		tree.postOrderTraverse(tree.getRoot());
	}

}
