import java.util.Stack;

public class Reverse {
	public int reverse1(int x) {
		if(x > 0) {
			StringBuffer sb = new StringBuffer(x + "");
			return Integer.parseInt(sb.reverse().toString());
		} else {
			StringBuffer sb = new StringBuffer((0 - x) + "");
			return 0 - Integer.parseInt(sb.reverse().toString());
		}
    }
	
	
	public int reverse2(int x) {
		String xstr = Math.abs(x) + "";
		char[] array = xstr.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : array) {
			stack.push(c);
		}
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		if(x > 0) {
			return Integer.parseInt(sb.toString());
		} else {
			return 0 - Integer.parseInt(sb.toString());
		}
    }
	
	public int reverse3(int x) {
		String xstr = Math.abs(x) + "";
		int length = xstr.length();
		int i = 0;
		int y = 0;
		int reverse = 0;
		while((y = (int) (x % Math.pow(10, ++ i))) != 0) {
			x = (int) (x / Math.pow(10, i));
			reverse += (int) (y * Math.pow(10, length - i));
		}
		return reverse;
	}
	
	public static void main(String[] args) {
		System.out.println(new Reverse().reverse3(32));
	}
}
