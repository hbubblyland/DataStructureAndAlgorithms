/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
		if(pHead == null)
			return null;
		RandomListNode node = pHead;
		while(node != null){
			RandomListNode cloned = new RandomListNode(node.label);
			cloned.next = node.next;
			node.next = cloned;
			node = cloned.next;
		}
		
		node = pHead;
		while(node != null){
			if(node.random != null)
				node.next.random = node.random.next;
			node = node.next.next;
		}
		
		node = pHead;
		RandomListNode cloned = null;
		RandomListNode clonedHead = node.next;
		while(node.next != null){
			cloned = node.next;
			node.next = cloned.next;
			node = cloned;
		}
		return clonedHead;
	}
}