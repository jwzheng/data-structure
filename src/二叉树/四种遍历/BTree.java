package 二叉树.四种遍历;

import java.util.ArrayDeque;

public class BTree {
	private TreeNode root = new TreeNode();

	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	/**
	 * 前序遍历
	 * @param node
	 */
	public void preOrderTraverse(TreeNode node){
		if(node == null){
			return;
		}
		
		System.out.println(node.getData());
		preOrderTraverse(node.getLchild());
		preOrderTraverse(node.getRchild());
	}
	
	/**
	 * 中序遍历
	 * @param node
	 */
	public void inOrderTraverse(TreeNode node){
		if(node == null){
			return;
		}
		
		inOrderTraverse(node.getLchild());
		System.out.println(node.getData());
		inOrderTraverse(node.getRchild());
	}
	
	/**
	 * 后序遍历
	 * @param node
	 */
	public void postOrderTraverse(TreeNode node){
		if(node == null){
			return;
		}
		
		postOrderTraverse(node.getLchild());
		postOrderTraverse(node.getRchild());
		System.out.println(node.getData());
	}
	
	/**
	 * 层次遍历
	 * @param node
	 */
	public void levelOrderTraverse(TreeNode node){
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		
		stack.offerLast(node);
		while(!stack.isEmpty()){
			TreeNode n = stack.pollFirst();
			System.out.println(n.getData());
			if(n.getLchild() != null){
				stack.offerLast(n.getLchild());
			}
			if(n.getRchild() != null){
				stack.offerLast(n.getRchild());
			}
		}
	}
	
	/**
	 * 利用前序遍历得到的线性序列构建二叉树
	 * 可以通过改变递归的调用顺序得到中序和后序方式的构建二叉树
	 * @param parent
	 * @param flag
	 * @param sb
	 */
	public void createTree(TreeNode parent, Boolean flag, StringBuilder sb){
		if(sb.length() <= 0){
			return;
		}
		if(sb.charAt(0) == '#'){
			sb.deleteCharAt(0);
			return;
		}
		
		if(parent == null){
			root.setData(sb.charAt(0));
			sb.deleteCharAt(0);
			createTree(root, true, sb);
			createTree(root, false, sb);
		}else{
			if(flag){
				parent.setLchild(new TreeNode());
				parent.getLchild().setData(sb.charAt(0));
				sb.deleteCharAt(0);
				createTree(parent.getLchild(), true, sb);
				createTree(parent.getLchild(), false, sb);
			}else{
				parent.setRchild(new TreeNode());
				parent.getRchild().setData(sb.charAt(0));
				sb.deleteCharAt(0);
				createTree(parent.getRchild(), true, sb);
				createTree(parent.getRchild(), false, sb);
			}
		}
	}
}
