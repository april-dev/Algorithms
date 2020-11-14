//4000 is the furtherest point it can get, 
// 4000 = max(x) + max(max(a), max(b)) = 2000 + 2000, since 0<=x, a, b<=2000

/*
Two Case: a>b and b>a

if a>b, since we can go backward only 1 time,if x pass certain limit, after we do pos-b, the next step is always pos+a, which will increase the position further, 
the pos will only keep increasing and we can never go back
if b>a, in this case, since the backward is larger, we can go back by at most (b-a). Let's say out current pos is Y(Y>x,if not, just go forward).
We want to reach x and (Y-x)%(b-a)=0.We may do (Y-x)/(b-a) steps. Y=(b-a)*x. We can see at some point, we can bound the Y
*/

public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x==0) return 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int point:forbidden) set.add(point);
        
        q.add(new int[]{0, 1});
        visited.add("0,1");
        int jump = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.remove();
                int pos = cur[0];
                int dir = cur[1];
                if (pos==x) return jump;
                int forward = pos+a;
                int backward = pos-b;
                if (visited.add(forward+",1") && !set.contains(pos+a) && pos+a<4000) q.add(new int[]{pos+a, 1});
                if (dir!=-1 && pos-b>=0 && visited.add(backward+",-1") &&  !set.contains(pos-b)) q.add(new int[]{pos-b, -1});
            }
            jump++;
        }
        return -1;
    }
