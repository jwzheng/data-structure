package 栈.四则运算表达式求值;

public interface Operation {
	
	public void processStack(StringBuilder sb, LinkStack2 stack);
	public void cal(char ch, LinkStack intStack);
}
