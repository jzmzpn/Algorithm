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
}
