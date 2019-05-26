import java.util.*;
class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val){
		this.val = val;
	}
}
public class PostOrder{
	//递归
	public static void postOrder1(TreeNode node){
		if(node == null)
			return;
		preOrder1(node.left);
		preOrder1(node.right);
		System.out.print(node.val);
	}
	
	//非递归
	public static void postOrder2(TreeNode node){
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();//辅助栈，用来判断子节点返回父节点时处于左子节点还是右子节点
		int left = 1;
		int right = 2;
		
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				stack2.push(left);
				node = node.left;
			}
			while(!stack.isEmpty() && stack2.peek() == right){
				stack2.pop();
				System.out.print(stack.pop().val);
			}
			if(!stack.isEmpty() && stack.peek() == left){
				stack2.pop();
				stack2.push(right);
				node = stack.peek().right;
			}
			
		}
	}
}