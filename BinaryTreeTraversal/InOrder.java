import java.util.*;
class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val){
		this.val = val;
	}
}
public class InOrder{
	//递归
	public static void inOrder1(TreeNode node){
		if(node == null)
			return;
		preOrder1(node.left);
		System.out.print(node.val);
		preOrder1(node.right);
	}
	
	//非递归
	public static void inOrder2(TreeNode node){
		Stack<TreeNode> stack = new Stack<>();
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			if(!stack.isEmpty()){
				node = stack.pop();
				System.out.print(node.val);
				node = node.right;
			}
		}
	}
}