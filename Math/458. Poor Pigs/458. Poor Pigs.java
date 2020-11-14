//https://leetcode.com/problems/poor-pigs/discuss/935112/Python-Math-solution-detailed-expanations
public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest/minutesToDie + 1, pigs) < buckets) pigs++;
        return pigs;
    }
