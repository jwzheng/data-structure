package 查找.平衡二叉树实现;

import java.util.ArrayDeque;

public class BiTree {
	/**
	 * 左高
	 */
	public static final int LH = 1;
	/**
	 * 等高
	 */
	public static final int EH = 0;
	/**
	 * 右高
	 */
	public static final int RH = -1;
	
	/**
	 * 头结点，根存在头结点的左孩子上
	 */
	private BiTNode head = new BiTNode();
	/**
	 * 树的深度有无增加的标志
	 */
	private Boolean taller;            
	
	/**
	 * LL型，右旋操作
	 * @param P
	 * @return L 返回该子树新的根
	 */
	private BiTNode rRotate(BiTNode P){
		if(P == null){
			return null;
		}
		
		BiTNode L = P.lchild;
		P.lchild = L.rchild;
		L.rchild = P;
		
		return L;
	}
	
	/**
	 * RR型，左旋操作
	 * @param P
	 * @return R 返回该子树新的根
	 */
	private BiTNode lRotate(BiTNode P){
		if(P == null){
			return null;
		}
		
		BiTNode R = P.rchild;
		P.rchild = R.lchild;
		R.lchild = P;
		
		return R;
	}
	
	/**
	 * 子树根的平衡因子大于1时执行
	 * 左平衡旋转处理
	 * @param T
	 */
	private void leftBalance(BiTNode T){
		BiTNode L = T.lchild;             //需要做左平衡旋转处理，说明左子树高于右子树
		BiTNode Lr = null;
		
		switch(L.bf){                     //判断当前结点左子树的平衡因子，确定是什么类型的失衡
		case BiTree.LH:                   //LL型 
			T.bf = L.bf = BiTree.EH;      //可以确定调整过后左子树根和当前根平衡因子为0
			processParent(T, L);		  //调整当前结点左孩子的双亲
			T.parent = rRotate(T);        //进行右旋转操作
			break;
		case BiTree.RH:                   //LR型
			Lr = L.rchild;                //找到右子树的根
			switch(Lr.bf){         		  //根据右子树因子判断平衡后的因子
			case BiTree.LH:               //右子树因子为1时，根据LR型推测出恢复平衡后L和T的因子
				T.bf = BiTree.RH;
				L.bf = BiTree.EH;
				break;
			case BiTree.EH:           	   //同上
				T.bf = L.bf = BiTree.EH;
				break;
			case BiTree.RH:				   //同上
				T.bf = BiTree.EH;
				L.bf = BiTree.LH;
				break;
			}
			Lr.bf = BiTree.EH;
			processParent(L, Lr);
			L.parent = lRotate(L);        //LR型先左旋后右旋
			
			L = T.lchild;
			processParent(T, L);
			T.parent = rRotate(T);
		}
	}

	private void processParent(BiTNode T, BiTNode L) {
		L.parent = T.parent;
		if(L.parent.lchild == T){
			L.parent.lchild = L;
		}else{
			L.parent.rchild = L;
		}
	}
	
	/**
	 * 右平衡旋转处理
	 * @param T
	 */
	private void rightBalance(BiTNode T) {
		BiTNode Rl = null;
		BiTNode R = T.rchild;
		switch(R.bf){
		case BiTree.RH:
			T.bf = R.bf = BiTree.EH;
			processParent(T, R);
			T.parent = lRotate(T);
			break;
		case BiTree.LH:
			Rl = R.lchild;
			switch(Rl.bf){
			case BiTree.RH:
				T.bf = BiTree.LH;
				R.bf = BiTree.EH;
				break;
			case BiTree.EH:
				T.bf = R.bf = BiTree.EH;
				break;
			case BiTree.LH:
				T.bf = BiTree.EH;
				R.bf = BiTree.RH;
				break;
			}
			Rl.bf = BiTree.EH;
			processParent(R, Rl);
			R.parent = rRotate(R);
			
			R = T.rchild;
			processParent(T, R);
			T.parent = lRotate(T);
		}
	}
	
	/**
	 * 
	 * @param parent 当前结点的双亲
	 * @param child 当前结点
	 * @param isleft 如果要新增新结点，true作为parent的左孩子，false作为parent的右孩子
	 * @param e 结点数据
	 * @return true则插入新结点成功，反之失败
	 */
	private boolean insertAVL(BiTNode parent, BiTNode child, Boolean isleft, int e){
		if(child == null){              //为空新增新结点
			child = new BiTNode();
			child.data = e;
			child.bf = BiTree.EH;
			child.parent = parent;
			if(parent == head){
				parent.lchild = child;
			}else{
				if(isleft){
					parent.lchild = child;
				}else{
					parent.rchild = child;
				}
			}
			taller = true;              //树深度增加
		}else{
			if(e == child.data){        //已有该结点数据，树深度不增加，返回false
				taller = false;
				return false;
			}
			
			if(e < child.data){         //数据小于当前结点，遍历左子树，数据有可能向左子树增加
				if(!insertAVL(child, child.lchild, true, e)){
					return false;       //左子树增加结点失败，返回false
				}
				
				if(taller){            
					switch(child.bf){      //新结点在左子树增加成功，查看当前结点的平衡因子
					case BiTree.LH:        //增加结点前，平衡因子为1，说明当前树失衡，需要做左平衡旋转处理
						leftBalance(child);
						taller = false;       //重新恢复平衡，树的深度恢复
						break;
					case BiTree.EH:           //增加结点前，平衡因子为0，说明当前树不失衡
						child.bf = BiTree.LH;   //当前结点因子设为1
						taller = true;
						break;
					case BiTree.RH:           //增加结点前，平衡因子为-1，说明当前结点右子树比左子树
						child.bf = BiTree.EH;   //左子树高度增加1后，当前结点因子设为0
						taller = false;
						break;
					}
				}
			}else{
				if(!insertAVL(child, child.rchild, false, e)){  //数据大于当前结点，遍历右子树，数据有可能向右子树增加
					return false;
				}
				
				if(taller){                 //分析同上
					switch(child.bf){
					case BiTree.LH:
						child.bf = BiTree.EH;
						taller = false;
						break;
					case BiTree.EH:
						child.bf = BiTree.RH;
						taller = true;
						break;
					case BiTree.RH:
						rightBalance(child);
						taller = false;
						break;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 添加结点的唯一方法
	 * @param num
	 */
	public void insert(int[] num){
		taller = false;     //初始化taller
		
		for(int i = 0; i < num.length; ++i){
			insertAVL(head, head.lchild, null, num[i]);
		}
	}
	
	/**
	 * 层次遍历平衡二叉树
	 */
	public void show(){
		BiTNode last = null;
		BiTNode	nlast = null;
		ArrayDeque<BiTNode> queue = new ArrayDeque<>();
		
		last = head.lchild;
		queue.offerLast(head.lchild);
		
		while(!queue.isEmpty()){
			BiTNode bt = queue.pollFirst();
			
			System.out.print(bt.data+" ");
			if(bt.lchild != null){
				queue.offerLast(bt.lchild);
				nlast = bt.lchild;
			}
			if(bt.rchild != null){
				queue.offerLast(bt.rchild);
				nlast = bt.rchild;
			}
			if(last == bt){
				System.out.println("");
				last = nlast;
			}
		}
	}

}
