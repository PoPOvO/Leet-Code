public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode current = res;
		ListNode prev = res;
		int carry = 0;
		
		while (l1 != null || l2 != null || carry != 0) {
			int add = (l1 != null && l2 != null) ? l1.val + l2.val : 0;          //add在有三种情况:
			if ((l1 == null || l2 == null) && l1 != l2) {                        //1、l1和l2都不为null，为其和
				l1 = (l1 != null) ? l1 : l2;                                     //2、l1或l2中一个为null，则add为非null链表的元素
				if (l1 == l2) l2 = null;                                         //3、l1和l2都为null，但存在进位，则该次add为0
				add = l1.val;
			}
			
			if (current == null) prev.next = current = new ListNode(0);
			prev = current;
			current.val = (add + carry) % 10;
			carry = (add + carry) / 10;
			
			if (l1 != null && l2 != null) l2 = l2.next;
			else if (l1 == null && l2 == null) break;                            //l1和l2都为null，但该次为进位
			l1 = l1.next;
			current = null;
		}
		return res;
	}
}

class ListNode {
	int val;
	ListNode next;
 	ListNode(int x) {
 		val = x;
 	}
}