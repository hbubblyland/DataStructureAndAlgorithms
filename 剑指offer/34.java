import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return list;
		Stack<Integer> stack = new Stack<>();
		FindPathCore(root, target, stack, list);
		return list;
    }
	
	public void FindPathCore(TreeNode root,int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> list){
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			if(root.val == target){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int i:path)
					temp.add(i);
				temp.add(root.val);
				list.add(temp);
			}
		}else{
			path.push(root.val);
			FindPathCore(root.left, target-root.val, path, list);
			FindPathCore(root.right, target-root.val, path, list);
			path.pop();
		}
	}
}