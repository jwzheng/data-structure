package 栈.四则运算表达式求值;

public class Div extends BaseOperation{
	private static final char DIV = '/';
	private static final int level = 3;
	
	@Override
	public void convert(StringBuilder sb, LinkStack2 stack) {
		StackDate sd = new StackDate();
		sd.setDate(DIV);
		sd.setLevel(level);
		stack.push(sd);
	}

	@Override
	protected int getLevel() {
		return level;
	}

	@Override
	public void cal(char ch, LinkStack intStack) {
		int secondNum = Integer.parseInt(intStack.pop()+"");
		int firstNum = Integer.parseInt(intStack.pop()+"");
		
		intStack.push(firstNum/secondNum);
	}

}
