import java.util.*;
class TreeNode{
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val){
		this.val = val;
	}
}
public class PreOrder{
	//递归
	public static void preOrder1(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.val);
		preOrder1(node.left);
		preOrder1(node.right);
	}
	
	//非递归
	public static void preOrder2(TreeNode node){
		Stack<TreeNode> stack = new Stack<>();
		while(node != null || !stack.isEmpty()){
			while(node != null){
				stack.push(node);
				System.out.print(node.val);
				node = node.left;
			}
			if(!stack.isEmpty()){
				node = stack.pop();
				node = node.right;
			}
		}
	}
}