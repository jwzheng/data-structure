package 栈.四则运算表达式求值;

public class Count2 {
	private Count2(){}
	
	public static int count(String houzui) {
		LinkStack intStack = new LinkStack();
		char[] ch = houzui.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < ch.length; ++i){
			if(ch[i] == '#'){
				intStack.push(Integer.parseInt(sb.toString()));
				sb.delete(0, sb.length());
				continue;
			}
			if(ch[i] < 48 || ch[i] > 57){
				try {
					Operation op = OperationFactory.getMap(ch[i]);
					op.cal(ch[i], intStack);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}else{
				sb.append(ch[i]);
			}
		}
		
		return (int) intStack.pop();
	}
}
