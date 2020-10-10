//similar template as Q297. Serialize and Deserialize Binary Tree
//Difference:
//BST: use upper and lower boundaries to check whether we should add null
//Binary Tree: use upper and lower boundaries to check whether we should add null

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb){
        if (root ==null) return;
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       // String[] s = data.split(",");
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
        return buildTree(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public TreeNode buildTree(Queue<String> q, int min, int max){
        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.valueOf(s);
        if (val<min || val>max) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = buildTree(q, min, val);
        root.right = buildTree(q, val, max);
        return root;
    }
}
