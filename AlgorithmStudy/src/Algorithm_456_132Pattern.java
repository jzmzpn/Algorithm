import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 *	Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that 
 *	i < j < k and ai< ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether 
 *	there is a 132 pattern in the list.
 *	Note: n will be less than 15,000.
 *	Example 1:
 *	Input: [1, 2, 3, 4]
 *	Output: False
 *	Explanation: There is no 132 pattern in the sequence.

 *	Example 2:
 *	Input: [3, 1, 4, 2]
 *	Output: True
 *	Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

 *	Example 3:
 *	Input: [-1, 3, 2, 0]
 *	Output: True
 *	Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].	
 *
 */
public class Algorithm_456_132Pattern {
	
	public static void main(String[] args) {
		Integer[] array = {-2, 3, 2, 0, -1};
		_132Pattern(array);
	}
	
	public static void _132Pattern(Integer[] array) {
		if(array == null || array.length < 3) {
			System.out.println("Input: " + array);
			System.out.println("Output: False");
			System.out.println("Explanation: There is no 132 pattern in the sequence.");
			return;
		}
		List<String> explanations = new ArrayList<String>();
		List<Integer> list = Arrays.asList(array);
		int size = list.size();
		list.forEach(integer1 -> {
			int indexOf = list.indexOf(integer1);
			for (int i = indexOf + 1; i < size; i++) {
				Integer integer2 = list.get(i);
				
				for(int j = 1; i != size - j && size - j > 0; j ++) {
					Integer integer3 = list.get(size - j);
					
					if(integer1 < integer3 && integer2 > integer3) {
						Integer[] explanation = {integer1, integer3, integer2};
						explanations.add(Arrays.asList(explanation).toString());
					}
				}
			}
		});
		if(explanations.size() == 0) {
			System.out.println("Input: " + list.toString());
			System.out.println("Output: False");
			System.out.println("Explanation: There is no 132 pattern in the sequence.");
		} else {
			System.out.println("Input: " + list.toString());
			System.out.println("Output: True");
			StringBuffer sb = new StringBuffer();
			for (String str : explanations) {
				sb.append(str + ",");
			}
			sb.setLength(sb.length() - 1);
			System.out.println("Explanation: There is a 132 pattern in the sequence: " + sb.toString() +".");
		}
	}
}
