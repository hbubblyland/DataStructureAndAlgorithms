/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0)
			return null;
		ListNode nodeA = head;
		ListNode nodeB = head;
		for(int i=0; i<k-1; i++){
			if(nodeA.next != null) //保证链表有k个节点数
				nodeA = nodeA.next;
			else
				return null;
		}
		while(nodeA.next != null){
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		return nodeB;
    }
}