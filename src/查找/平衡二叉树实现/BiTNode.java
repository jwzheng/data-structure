package 查找.平衡二叉树实现;

/**
 * 二叉链表结点
 * @author jw_zheng
 *
 */
public class BiTNode {
	/**
	 * 结点数据
	 */
	public int data;
	/**
	 * 结点平衡因子
	 */
	public int bf;
	/**
	 * 结点左孩子 
	 */
	public BiTNode lchild;
	/**
	 * 结点右孩子
	 */
	public BiTNode rchild;
	/**
	 * 结点双亲
	 */
	public BiTNode parent;
}
