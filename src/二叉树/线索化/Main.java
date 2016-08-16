package 二叉树.线索化;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("ABDH##I##E##CF##G##");
		
		BTree tree = new BTree();
		tree.createTree(null, null, sb);

		ThreadTree tt = new ThreadTree(tree);
		tt.inThreading(tree.getRoot());
		tt.inOrderTraverse_thr(tree.getRoot());
	}

}
