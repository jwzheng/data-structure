package 查找.平衡二叉树实现;

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
	
	private BiTNode root;
	private Boolean taller;
	
	public BiTNode getRoot() {
		return root;
	}

	public void setRoot(BiTNode root) {
		this.root = root;
	}
	
	public boolean isTaller() {
		return taller;
	}

	public void setTaller(boolean taller) {
		this.taller = taller;
	}

	/**
	 * 右旋操作
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
	 * 左旋操作
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
	 * 左平衡旋转处理
	 * @param T
	 */
	private void leftBalance(BiTNode T){
		BiTNode L, Lr;
		L = T.lchild;        //需要做左平衡旋转处理，说明左子树高于右子树
		switch(L.bf){
		case BiTree.LH:       //左子树根节点平衡因子为1，出现LL型的失衡 
			T.bf = L.bf = BiTree.EH;      //可以确定调整过后左子树根和当前根平衡因子为0
			rRotate(T);                //进行右旋转操作
			break;
		case BiTree.RH:           //左子树根节点平衡因子为-1，出现LR型的失衡 
			Lr = L.rchild;        //找到右子树的根
			switch(Lr.bf){         
			case BiTree.LH:           //右子树因子为1时，根据LR型推测出恢复平衡后L和T的因子
				T.bf = BiTree.RH;
				L.bf = BiTree.EH;
				break;
			case BiTree.EH:           	   //同上
				T.bf = L.bf = BiTree.EH;
				break;
			case BiTree.RH:				    //同上
				T.bf = BiTree.EH;
				L.bf = BiTree.LH;
				break;
			}
			Lr.bf = BiTree.EH;
			lRotate(T.lchild);           //LR型先左旋后右旋
			rRotate(T);
		}
	}
	
	/**
	 * 右平衡旋转处理
	 * @param T
	 */
	private void rightBalance(BiTNode T) {
		BiTNode R, Rl;
		R = T.rchild;
		switch(R.bf){
		case BiTree.RH:
			T.bf = R.bf = BiTree.EH;
			rRotate(T);
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
			rRotate(T.rchild);
			lRotate(T);
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
	public boolean insertAVL(BiTNode parent, BiTNode child, Boolean isleft, int e){
		if(child == null){              //为空新增新结点
			child = new BiTNode();
			child.data = e;
			child.bf = BiTree.EH;
			if(parent != null){         //没有双亲则说明当前结点为root
				if(isleft){
					parent.lchild = child;
				}else{
					parent.rchild = child;
				}
			}else{
				root = child;
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
					switch(child.bf){    //新结点在左子树增加成功，查看当前结点的平衡因子
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
	
	public void insert(int[] num){
		taller = false;     //初始化taller
		
		for(int i = 0; i < 10; ++i){
			insertAVL(null, root, null, num[i]);
		}
	}

}
