package 栈.四则运算表达式求值;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OperationFactory {
	private static Map<Character, Operation> map;
	private static Properties props;
	
	static{
		map = new HashMap<Character, Operation>();
		props = new Properties();
		try {
			props.load(new FileInputStream("operation.properties"));     //相对地址是项目的根目录
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private OperationFactory(){};          //禁止实例化
	
	public static Operation getMap(Character ch){
		if(!map.containsKey(ch)){
			try {
				map.put(ch, (Operation) Class.forName(props.getProperty(ch+"")).newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}
		return map.get(ch);
	}

}
