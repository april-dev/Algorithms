/*
Time: Naive BFS O(2^n) for n instructions

The BFS is memorizing pairs of speed and positions. So the total time complexity will be the number of such pairs formed before we hit the target.
Now, How many different positions are possible to reach to target. In worst case we, could have visited every single position in both the directions i.e. from -target to +target 
so the total no of positions possible are O(target).
Now, to check total no of speeds possible we could go either 1, 2, 4, 8.. or -1, -2, -4 , -8 .. .. upto (target). because we will always reach the target with speed bounded by 
target position. So total no of distinct speeds are 2O(log target)
Hence time complexity= Total distinct positions(=target) * total distinct speeds (=log(target)) = O(targetlog(target)).
*/

/*
We should allow the car to be able to pass the target and then reverse the direction to go to the target. However, there should be an upper bound because there's no point to 
keep accelerating after passing the target.

To find the upper bound, lets' consider an extreme case where the car is always accelerating, the number of acceleration is m, the car with position (2^m) - 1 has not 
reached the target: (2^m)-1 < target. Since the target is an integer, we can rewrite it as: target = (2^m)+k, k >= 0... (1)

In the above extreme case, the car's speed 2^m is the maximum possible speed at the position (2^m)-1. Note that we should allow the car to be able to pass the target, 
which leads to the maximum next position is (2^m)-1 + 2^m... (2)

Combine (1) and (2) we get (2^m)-1+2^m = 2*(2^m)-1 < 2*(2^m)+2*k = 2*target, k >= 0. It says, the upper bound for any position with any possible speed is 2*target
*/
public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(new int[]{0, 1});
        visited.add(0 + "," + 1);
        
        int level = 0;        
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int[] cur = queue.poll();
                if (cur[0]==target) return level;
                
                int[] nxt = {cur[0]+cur[1], cur[1]*2};
                String key = nxt[0] + "," + nxt[1];
                    
                if (nxt[0]<target*2 && nxt[0]>0 && !visited.contains(key)) {
                        queue.offer(nxt);
                        visited.add(key);
                }
                
                nxt = new int[]{cur[0], cur[1]>0?-1:1};
                key = nxt[0] + "," + nxt[1];
                
                if (nxt[0]<target*2 && nxt[0]>0 && !visited.contains(key)) {
                        queue.offer(nxt);
                        visited.add(key);
                }                    
            }
            level++;
        }
        return -1;
    }
