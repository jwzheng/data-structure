package 栈.四则运算表达式求值;

public class LPar implements Operation {
	private static final char LPAP = '(';

	@Override
	public void processStack(StringBuilder sb, LinkStack2 stack) {
		StackDate sd = new StackDate();
		sd.setDate(LPAP);
		stack.push(sd);
	}

	@Override
	public void cal(char ch, LinkStack intStack) {
		return;
	}

}
