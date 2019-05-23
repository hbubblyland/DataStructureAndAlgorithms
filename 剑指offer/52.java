/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
		if(pHead1 == null || pHead2 == null)
			return null;
		int len1 = getLen(pHead1);
		int len2 = getLen(pHead2);
		if(len1 > len2){
			int len = len1 - len2;
			while(len > 0){
				pHead1 = pHead1.next;
				len--;
			}
		}else if(len1 < len2){
			int len = len2 - len1;
			while(len > 0){
				pHead2 = pHead2.next;
				len--;
			}
		}
		
		while(pHead2 != pHead1){
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}
	
	public int getLen(ListNode node){
		int len = 0;
		while(node != null){
			len++;
			node = node.next;
		}
		return len;
	}
}