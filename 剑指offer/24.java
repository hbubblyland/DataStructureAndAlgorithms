/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
	
    public ListNode ReverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode pNode = head;
		ListNode pPre = null;
		ListNode pNext = null;
		ListNode pReverseNode = null;
		while(pNode != null){
			pNext = pNode.next;
			if(pNext == null)
				pReverseNode = pNode;
			pNode.next = pPre;
			pPre = pNode;
			pNode = pNext;
		}
		return pReverseNode;
    }
	
	
	public ListNode ReverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode pre = null;
		ListNode next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}