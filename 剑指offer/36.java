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
    TreeNode leftHead = null;
	TreeNode rightHead = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
		return leftHead;
    }
	
	public void ConvertSub(TreeNode pRootOfTree){
		if(pRootOfTree == null)
			return;
		ConvertSub(pRootOfTree.left);
		if(rightHead == null){
			leftHead = pRootOfTree;
			rightHead = pRootOfTree;
		}else{
			rightHead.right = pRootOfTree;
			pRootOfTree.left = rightHead;
			rightHead = pRootOfTree;
		}
		ConvertSub(pRootOfTree.right);
	}
}