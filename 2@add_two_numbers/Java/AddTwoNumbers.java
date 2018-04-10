public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode current = res;
		ListNode prev = res;
		
		while (l1 != null && l2 != null) {
			int add = l1.val + l2.val;

			if (current == null) 
				prev.next = current = new ListNode(0);
			prev = current;                                             //prev用于连接链表
			if (add > 9) {
				current.next = new ListNode(add / 10); 			//相加最高18，取余后为8，不会爆10
				current.val += add % 10;
			}
			else {
				current.val += add;
				if (current.val > 9)                                    //低位进位
					dealCarry(current, current.val);
			}
			current = current.next;                                     //若进位了，则当前current不为null，可以进行判断
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if (l1 != null || l2 != null) {
			l1 = (l1 != null) ? l1 : l2;	
			while (l1 != null) {
				if (current == null)
					prev.next = current = new ListNode(0);
				current.val += l1.val;
				if (current.val > 9) 
					dealCarry(current, current.val);
				prev = current;
				current = current.next;
				l1 = l1.next;
			}
		}
		return res;
	}

	private void dealCarry(ListNode node, int value) {
		node.next = new ListNode(value / 10); 			//相加最高18，取余后为8，不会爆10
		node.val = value % 10;
	}
}

class ListNode {
	int val;
	ListNode next;
 	ListNode(int x) {
 		val = x;
 	}
}