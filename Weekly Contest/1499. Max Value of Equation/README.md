Since the target to be optimized is yi + yj + |xi - xj| (aka xj + yj + yi - xi given j > i), the value of interest is yi - xi. While we loop through the array with index j, we want to keep track of the largest yi - xi under the constraint that xj - xi <= k.

We could use a priority queue for this purpose. Since Python provides min-heap, we would stuff (xj - yj, xj) to the queue such that top of the queue has points with largest y-x and x could be used to verify if the constraint is met.

