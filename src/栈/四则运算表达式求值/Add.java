package 栈.四则运算表达式求值;

public class Add extends BaseOperation {
	private static final char ADD = '+';
	private static final int level = 2;
	
	@Override
	protected int getLevel() {
		return level;
	}

	@Override
	protected void convert(StringBuilder sb, LinkStack2 stack) {
		StackDate sd = new StackDate();
		sd.setDate(ADD);
		sd.setLevel(level);
		stack.push(sd);
	}

	@Override
	public void cal(char ch, LinkStack intStack) {
		int secondNum = Integer.parseInt(intStack.pop()+"");
		int firstNum = Integer.parseInt(intStack.pop()+"");
		
		intStack.push(firstNum+secondNum);
	}

}
