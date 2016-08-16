package 二叉树.线索化;

/**
 * 中序遍历线索化
 * @author jw_zheng
 *
 */
public class ThreadTree {
	private TreeNode pre;      //用来保存上一个处理的结点
	
	private BTree tree;
	
	public ThreadTree(BTree tree){
		this.tree = tree; 
	}

	public BTree getTree() {
		return tree;
	}
	public void setTree(BTree tree) {
		this.tree = tree;
	}
	
	/**
	 * 使用中序遍历创建线索
	 * @param node
	 */
	public void inThreading(TreeNode node){
		if(node == null){
			return;
		}
		
		inThreading(node.getLchild());
		if(node.getLchild() == null){
			node.setLtag(true);
			node.setLchild(pre);
		}
		if(pre != null && pre.getRchild() == null){
			pre.setRtag(true);
			pre.setRchild(node);
		}
		pre = node;
		inThreading(node.getRchild());
	}
	
	/**
	 * 利用线索进行中序遍历
	 * @param node
	 */
	public void inOrderTraverse_thr(TreeNode node){
		TreeNode n = node;
		
		while(n != null){
			while(!n.isLtag()){
				n = n.getLchild();
			}
			System.out.println(n.getData());
			while(n.isRtag()){
				n = n.getRchild();
				System.out.println(n.getData());
			}
			n = n.getRchild();
		}
	}
}
