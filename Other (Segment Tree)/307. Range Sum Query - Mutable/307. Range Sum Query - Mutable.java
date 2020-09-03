//Time complexity for sumRange operations in segment tree is O(4*log n) exactly 
//because there are O(log n) levels in a segment tree and at max we will have to process 4 nodes per level.
//The time complexity of update is also O(Logn). To update a leaf value, we process one node at every level and number of levels is O(Logn).

public class NumArray {
class segmentNode{
    int start;
    int end;
    int sum;
    segmentNode left;
    segmentNode right;
    public segmentNode(int start,int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}

segmentNode node;
int[] nums;
public NumArray(int[] nums) {
    this.nums = new int[nums.length];
    for(int i=0;i<nums.length;i++)
        this.nums[i]=nums[i];
    this.node = buildtree(nums,0,nums.length-1);
}

void update(int i, int val) {
    int diff = nums[i]-val;
    nums[i]=val;
    if(node!=null)
        nupdate(node,i,diff);
}

public int sumRange(int i, int j) {
    return node==null?0:sum(node,i,j);
}

public segmentNode buildtree(int[] nums,int start,int end){
    if(start>end)   return null;
    segmentNode root = new segmentNode(start,end);
    if(start == end)
        root.sum = nums[start];
    else{
        int mid = start + (end-start)/2;
        root.left = buildtree(nums,start,mid);
        root.right = buildtree(nums,mid+1,end);
        root.sum = root.left.sum+root.right.sum;
    }
    return root;
}
public int sum(segmentNode root, int start, int end){
    if(root==null||start>root.end || end<root.start)    return 0;
    if(start<=root.start && end>=root.end)  return root.sum;
    int left = sum(root.left,start,end);
    int right = sum(root.right,start,end);
    return left+right;
}
public void nupdate(segmentNode root, int index,int diff){
    if(root==null||index>root.end||index<root.start)  return;
    if(index>=root.start && index<=root.end)    root.sum-=diff;
    nupdate(root.left,index,diff);
    nupdate(root.right,index,diff);
}
