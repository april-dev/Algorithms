public int minCostClimbingStairs(int[] cost) {
        int twoStepBefore = cost[0];
        int oneStepBefore = cost[1];
        int curr = 0;
        for(int i = 2;i< cost.length;i++){
            curr = Math.min(twoStepBefore,oneStepBefore) + cost[i];
            twoStepBefore = oneStepBefore;
            oneStepBefore = curr;
        }
        return Math.min(oneStepBefore,twoStepBefore);
    }




public int minCostClimbingStairs(int[] cost) {
        for (int i=2; i<cost.length; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
