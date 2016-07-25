package 栈.四则运算表达式求值;

public class Convert2 {
	private Convert2(){}
	
	public static String convert(String zhongzui){
		char[] ch = zhongzui.toCharArray();
		StringBuilder sb = new StringBuilder();
		LinkStack2 stack = new LinkStack2();
		boolean flag = false;        //给数字打结束标志的标记 
		
		for(int i = 0; i < ch.length; ++i){
			flag = false;
			
			while(i < ch.length && ch[i] >= 48 && ch[i] <= 57){
				flag = true;
				sb.append(ch[i++]);
			}
			if(flag){
				sb.append("#");
			}
			if(i == ch.length){
				break;
			}
			
			try {
				Operation op = OperationFactory.getMap(ch[i]);   //每次遇到运算符都得实例化对象，用完再消掉。改进成只实例化一次
				op.processStack(sb, stack);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		while(!stack.isEmpty()){
			sb.append(stack.getTop().getData().getDate());
			stack.pop();
		}
		return sb.toString();
	}
}
