/*
Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. 
Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, 

This is an implicit bfs solution. i == curEnd means you visited all the items on the current level. 
Incrementing jumps++ is like incrementing the level you are on. And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
*/

public int jump(int[] A) {
	int jumps = 0, curEnd = 0, curFarthest = 0;
	for (int i = 0; i < A.length - 1; i++) {
		curFarthest = Math.max(curFarthest, i + A[i]);
		if (i == curEnd) {
			jumps++;
			curEnd = curFarthest;
		}
	}
	return jumps;
}
