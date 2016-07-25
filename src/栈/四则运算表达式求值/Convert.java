package 栈.四则运算表达式求值;

public class Convert {
	
	public static String convert(String zhongzui){
		char[] ch = zhongzui.toCharArray();
		StringBuilder sb = new StringBuilder();
		LinkStack stack = new LinkStack();
		
		for(int i = 0; i < ch.length; ++i){
			switch(ch[i]){
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && (char)stack.getTop().getData() != '(' && level((char)stack.getTop().getData()) >= level((char)ch[i])){
					sb.append(stack.getTop().getData());
					stack.pop();
				}
				stack.push(ch[i]);
				break;
			case ')':
				while(!stack.isEmpty() && (char)stack.getTop().getData() != '('){
					sb.append(stack.getTop().getData());
					stack.pop();
				}
				
				if(!stack.isEmpty()){
					stack.pop();
				}
				break;
			case '(':
				stack.push(ch[i]);
				break;
			default:
				sb.append(ch[i]);
			}
		}
		
		while(!stack.isEmpty()){
			sb.append(stack.getTop().getData());
			stack.pop();
		}
		return sb.toString();
	}

	private static Integer level(char c) {
		if(c == '+' || c == '-'){
			return 1;
		}else if(c == '*' || c == '/'){
			return 2;
		}else{
			return null;
		}
	}
	
	
}
