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
import java.util.*;
public class Solution {
    //题目一：求二叉树的深度
	public int TreeDepth(TreeNode root) {
        if(root == null)
			return 0;
		int leftDepth = TreeDepth(root.left);
		int rightDepth = TreeDepth(root.right);
		return Math.max(leftDepth,rightDepth)+1;
    }
	
	//非递归
	public int TreeDepth(TreeNode root){
		if(root == null)
			return 0;
		int depth = 0;
		int count = 0;
		int nextCount = 1;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(queue.size() != 0){
			TreeNode node = queue.poll();
			count++;
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			if(count == nextCount){
				depth++;
				count = 0;
				nextCount = queue.size();
			}
		}
		return depth;
	}
	
	//题目二：判断二叉树是否是平衡二叉树
	public boolean IsBalanced_Solution(TreeNode root){
		return isBalance(root,new int[1]);
	}
	
	public boolean isBalance(TreeNode root, int depth[]){
		if(root == null){
			depth[0] = 0;
			return true;
		}
		boolean left = isBalance(root.left, depth);
		int leftDepth = depth[0];
		boolean right = isBalance(root.right, depth);
		int rightDepth = depth[0];
		depth[0] = Math.max(leftDepth,rightDepth)+1;
		if(left && right && Math.abs(leftDepth-rightDepth)<=1)
			return true;
		return false;	
	}
}