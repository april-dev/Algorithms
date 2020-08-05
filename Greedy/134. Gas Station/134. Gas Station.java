/*
1. If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station that A can not reach.)
2. If the total number of gas is bigger than the total number of cost. There must be a solution.

Proof for point 2 by induction:
We want to show, if gas(1) + gas(2) + ... + gas(n) >= cost(1) + cost(2) + ...+ cost(n) then there is a path that goes though all stations.
Base case: n = 2, obviously it's correct.
Now, suppose for n = k, the proposition holds. Then for n = k + 1, its difference from n = k case is just adding gas(k+1) on the left hand side, 
and cost(k+1) on the right hand side. We know for n = k there is the path, so for n = k + 1 there is a path too. Thus proof is done.
*/


class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int start(0),total(0),tank(0);
        //if car fails at 'start', record the next station
        for(int i=0;i<gas.size();i++) if((tank=tank+gas[i]-cost[i])<0) {start=i+1;total+=tank;tank=0;}
        return (total+tank<0)? -1:start;
    }
};
