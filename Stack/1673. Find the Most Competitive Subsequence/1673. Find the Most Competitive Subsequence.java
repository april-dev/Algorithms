/*
Keep a mono incrasing stackas result.
If current element a is smaller then the last element in the stack,
we can replace it to get a smaller sequence.

Before we do this,
we need to check if we still have enough elements after.
After we pop the last element from stack,
we have stack.size() - 1 in the stack,
there are A.size() - i can still be pushed.
if stack.size() - 1 + A.size() - i >= k, we can pop the stack.

Then, is the stack not full with k element,
we push A[i] into the stack.

Finally we return stack as the result directly.
*/

public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]<nums[stack.peek()] && nums.length - i + stack.size()>k){
                stack.pop();
            }
            if (stack.size()<k) stack.push(i);
        } 
        int[] res = new int[k];
        for (int i=k-1; i>=0; i--){
            res[i] = nums[stack.pop()];
        }
        return res;
    }
