/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	//归并
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return mergeSort(left,right);
    }
	
	public ListNode getMid(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next!=null){ //注意两个条件
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode mergeSort(ListNode left, ListNode right){
		if(left == null)
			return right;
		if(right == null)
			return left;
		//先找到头节点
		ListNode head = null;
		if(left.val>right.val){
			head = right;
			right = right.next;
		}else{
			head = left;
			left = left.next;
		}
		ListNode temp = head;
		while(right != null && left != null){
			if(left.val > right.val){
				temp.next = right;
				right = right.next;
			}else{
				temp.next = left;
				left = left.next;
			}
			temp = temp.next;  //不要忘
		}
		while(right != null){
			temp.next = right;
			right = right.next;
            temp = temp.next;
		}
		while(left != null){
			temp.next = left;
            left = left.next;
            temp = temp.next;
		}
		return head;
	}
	
	//快排，参考https://blog.csdn.net/u010429424/article/details/77776731
	/*
	我们设置两个指针 i，j，其中 i 初始时指向数组的第一个元素，j 初始化为 i+1。 
然后，我们设定 i 指向的元素为基准数字。

我们要做的事情，就是在一趟排序中，把那些比基准数字小的数，移动到前面。 
具体的算法如下：
如果 j 指向的值大于等于基准数字（如果比基准大，直接跳过） 
j ++
如果 j 指向的值小于基准数字，（如果比基准小，交换 i 和 j 位置的值） 
i ++
swap(i， j)
j ++

在交换的时候，为什么要让i先向后移动呢？

这是因为，在整个排序的过程中，i 前面指向的都是小于4的数字，i 后面指向的都是大于4的数字，i 是左右两边的分界线。我们交换的目的是把小于4的交换到前面，把大于4的交换到后面，所以 i 要先向后移动1位，找到后面第一个大于4的数，然后把这个大于4的数，和后面小于4的数交换。

	*/
	public ListNode sortList(ListNode head){
		quickSort(head, null)
		return head;
	}
	public void quickSort(ListNode head, ListNode end){
		if(head != end){
			ListNode temp = partion(head);
			quickSort(head, temp);
			quickSort(temp.next, end);
		}
	}
	public ListNode partion(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null){
			if(fast.val < head.val){
				slow = slow.next;
				int temp = slow.val;
				slow.val = fast.val;
				fast.val = temp;
			}
			fast = fast.next;
		}
		int temp = slow.val;
		slow.val = head.val;
		head.val = temp;
		return slow;
	}
}