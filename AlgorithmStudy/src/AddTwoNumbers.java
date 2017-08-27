import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(0);
		int i = 0;
		List<ListNode> list = new ArrayList<>();
		
		while(l1 != null || l2 != null) {
			int val1 = 0;
			int val2 = 0;
			if(l1 != null) val1 = l1.val;
			if(l2 != null) val2 = l2.val;
			int temp = i;
			int val = val1 + val2 + temp;
			i = val / 10;
			val = val % 10;
			list.add(new ListNode(val));
			if(l1 == null) l1 = null;
			else
			l1 = l1.next;
			if(l2 == null) l2 = null;
			else
			l2 = l2.next;
		}
		if(i != 0) {
			list.add(new ListNode(i));
		}
		listNode = list.get(0);
		ListNode next = listNode;
		int size = list.size();
		for (int j = 1; j < size; j++) {
			if(j == 1) {
				next = list.get(j);
				listNode.next = next;
				continue;
			}
			next.next = list.get(j);
			next = next.next;
			
		}
		return listNode;
	}
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int pow = 0;
		BigDecimal val1 = new BigDecimal(0);
		while(l1 != null) {
			BigDecimal decimal = new BigDecimal(l1.val);
			for(int i = 0; i < pow; i ++) {
				decimal = decimal.multiply(new BigDecimal(10));
			}
			val1 = val1.add(decimal);
			pow ++;
			l1 = l1.next;
		}
		pow = 0;
		BigDecimal val2 = new BigDecimal(0);
		while(l2 != null) {
			BigDecimal decimal = new BigDecimal(l2.val);
			for(int i = 0; i < pow; i ++) {
				decimal = decimal.multiply(new BigDecimal(10));
			}
			val2 = val2.add(decimal);
			pow ++;
			l2 = l2.next;
		}
		val1 = val1.add(val2);
		System.out.println(val1);
		BigDecimal[] decimals = val1.divideAndRemainder(new BigDecimal(10));
		BigDecimal quotient = decimals[0];
		BigDecimal remainder = decimals[1];
		
		ListNode listNode = new ListNode(remainder.intValue());
		ListNode next = new ListNode(0);
		while(quotient != null && quotient.compareTo(BigDecimal.ZERO) != 0) {
			System.out.println(quotient + "," + remainder);
			decimals = quotient.divideAndRemainder(new BigDecimal(10));
			quotient = decimals[0];
			remainder = decimals[1];
			if(listNode.next == null) {
				next.val = remainder.intValue();
				listNode.next = next;
				continue;
			}
			next.next = new ListNode(remainder.intValue());
			next = next.next;
			
		}
		return listNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node11 = new ListNode(5);
		ListNode node12 = new ListNode(4);
		node11.next = node12;
		ListNode node13 = new ListNode(7);
		node12.next = node13;
		
		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		node21.next = node22;
		ListNode node23 = new ListNode(4);
		node22.next = node23;
//		while(node11 != null) {
//			System.out.println(node11.val);
//			node11 = node11.next;
//		}
//		while(node21 != null) {
//			System.out.println(node21.val);
//			node21 = node21.next;
//		}
		ListNode node = new AddTwoNumbers().addTwoNumbers2(node11, node21);
		while(node != null) {
			System.out.println(node.val );
			node = node.next;
		}
		
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}