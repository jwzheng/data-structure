package 栈.四则运算表达式求值;

public class RPar implements Operation {
	private static final char RPAR = ')';

	@Override
	public void processStack(StringBuilder sb, LinkStack2 stack) {
		while(!stack.isEmpty() && stack.getTop().getData().getDate() != '('){
			sb.append(stack.getTop().getData().getDate());
			stack.pop();
		}
		
		if(!stack.isEmpty()){
			stack.pop();
		}
	}

	@Override
	public void cal(char ch, LinkStack intStack) {
		return;
	}

}
