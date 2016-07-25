package 栈.四则运算表达式求值;

public class Count {
	public static int count(String str){
		LinkStack intStack = new LinkStack();
		char[] ch = str.toCharArray();
		
		for(int i = 0; i < ch.length; ++i){
			int secondNum;
			int firstNum;
			
			switch(ch[i]){
			case '+':
				secondNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				firstNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				intStack.push(firstNum+secondNum);
				break;
			case '-':
				secondNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				firstNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				intStack.push(firstNum-secondNum);
				break;
			case '*':
				secondNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				firstNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				intStack.push(firstNum*secondNum);
				break;
			case '/':
				secondNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				firstNum = Integer.parseInt(intStack.getTop().getData()+"");
				intStack.pop();
				intStack.push(firstNum/secondNum);
				break;
			default:
				intStack.push(Integer.parseInt(ch[i]+""));
			}
		}
		return (int) intStack.getTop().getData();
	}
}
