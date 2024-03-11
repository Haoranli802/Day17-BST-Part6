class Solution {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(pre != null && root.val <= pre.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
//O(N), O(N) 递归指针

class Solution {
    List<Integer> in;
    public boolean isValidBST(TreeNode root) {
        in = new ArrayList<>();
        if(root == null) return true;
        inorder(root);
        if(in.size() == 1) return true;
        for(int i = 1; i < in.size(); i++){
            if(in.get(i) <= in.get(i - 1)) return false;
        }
        return true;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);
    }
}

//O(N), O(N)  递归中序遍历
