/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead){
		ListNode meetingNode = FindMeetingNode(pHead);
		if(meetingNode == null)
			return null;
		//得到环中节点的个数
		int nodesInLoop = 1;
		ListNode p1 = meetingNode;
		while(p1.next != meetingNode){
			p1 = p1.next;
			nodesInLoop++;
		}
		//找到环的入口
		p1 = pHead;
		for(int i=0; i<nodesInLoop; i++){
			p1 = p1.next;
		}
		ListNode p2 = pHead;
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	//采用一快一慢指针确定表中是否有环，并返回相遇节点
	public static ListNode FindMeetingNode(ListNode head){
		if(head == null)
			return null;
		ListNode slow = head.next;
		if(slow == null)
			return null;
		ListNode fast = slow.next;
		while(slow != null && fast != null){
			if(slow == fast)
				return fast;
			//下面的方式可以让俩个指针快点相遇
			slow = slow.next;
			fast = fast.next;
			if(slow != fast)
				fast = fast.next;
		}
		return null;
	}
}