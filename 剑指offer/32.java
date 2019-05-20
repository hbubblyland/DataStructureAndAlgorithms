import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
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
public class Solution {
    //不分行从上到下打印二叉树，同层节点从左到右打印
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
		if(root == null)
			return array;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
			array.add(node.val);
		}
		return array;
    }
	
	//分行从上到下打印二叉树，同一层节点按从左到右顺序打印，每一层打印一行
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
		ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(pRoot == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		int printNum = 0;
		int totalNum = 1;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			list.add(node.val);
			printNum++;
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
			if(printNum == totalNum){
				totalNum = queue.size();
				printNum = 0;
				result.add(list);
				list = new ArrayList<Integer>();
			}
		}
		return result;
	}
	
	//按之字形打印二叉树，即第一行从左到右打印，第二行从右到左打印，第三行从左到右打印，以此类推。
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
		int layer = 1;
		Stack<TreeNode> stack1 = new Stack<>();
		stack1.push(pRoot);
		Stack<TreeNode> stack2 = new Stack<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(pRoot == null)
			return result;
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			if(layer %2 != 0){
				ArrayList<Integer> list = new ArrayList<Integer>();
				while(!stack1.isEmpty()){
					TreeNode node = stack1.pop();
					if(node != null){
						list.add(node.val);
					    stack2.push(node.left);
					    stack2.push(node.right);
					}
				}
				if(!list.isEmpty()){
					result.add(list);
					layer++;
				}
			}else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				while(!stack2.isEmpty()){
					TreeNode node = stack2.pop();
					if(node != null){
						list.add(node.val);
					    stack1.push(node.right);
					    stack1.push(node.left);
					}
				}
				if(!list.isEmpty()){
					result.add(list);
					layer++;
				}
			}
			
		}
		return result;
	}
}