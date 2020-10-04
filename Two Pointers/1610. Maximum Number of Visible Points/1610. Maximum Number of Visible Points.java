public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int common = 0;
        for (List<Integer> p:points){
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx==0 && dy==0) {
                common++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) / Math.PI * 180);
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d:angles) tmp.add(d+360);
        int res = 0;
        for (int i=0, j=0; i<tmp.size(); i++){
            while (j<tmp.size() && tmp.get(j) - tmp.get(i)<=(double)angle) j++;
            res = Math.max(res, j-i);
        }
        return res+common;
    }
