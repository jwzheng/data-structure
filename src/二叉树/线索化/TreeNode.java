package 二叉树.线索化;

public class TreeNode {
	private char data;
	private TreeNode lchild;
	private TreeNode rchild;
	private boolean ltag;
	private boolean rtag;
	
	public boolean isLtag() {
		return ltag;
	}
	public void setLtag(boolean ltag) {
		this.ltag = ltag;
	}
	public boolean isRtag() {
		return rtag;
	}
	public void setRtag(boolean rtag) {
		this.rtag = rtag;
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public TreeNode getLchild() {
		return lchild;
	}
	public void setLchild(TreeNode lchild) {
		this.lchild = lchild;
	}
	public TreeNode getRchild() {
		return rchild;
	}
	public void setRchild(TreeNode rchild) {
		this.rchild = rchild;
	}
	
}
