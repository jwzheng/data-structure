package 递归.斐波那契数;

public class Main {

	public static void main(String[] args) {
		System.out.println(f(12));
	}

	private static int f(int i) {
//		if(i == 0){
//			return 0;
//		}
//		if(i == 1){
//			return 1;
//		}
		
		if(i < 2){
			return i == 0 ? 0 : 1;
		}
		
		return f(i-1)+f(i-2);
	}

}
