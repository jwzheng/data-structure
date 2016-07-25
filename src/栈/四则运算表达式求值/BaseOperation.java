package 栈.四则运算表达式求值;

public abstract class BaseOperation implements Operation {

	@Override
	public void processStack(StringBuilder sb, LinkStack2 stack) {
		while(!stack.isEmpty() && (char)stack.getTop().getData().getDate() != '(' && stack.getTop().getData().getLevel() >= getLevel()){
			sb.append(stack.getTop().getData().getDate());
			stack.pop();
		}
		convert(sb, stack);
	}
	
	protected abstract int getLevel();
	protected abstract void convert(StringBuilder sb, LinkStack2 stack);

}
