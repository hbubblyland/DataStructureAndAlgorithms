/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Stack;

public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null)
			return;
		if(root.left == null && root.right == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
    }
	
	//栈实现非递归
	public void Mirror(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node.left != null || node.right != null){
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
			}
			if(node.left != null)
				stack.push(node.left);
			if(node.right != null)
				stack.push(node.right);
		}
	}
}