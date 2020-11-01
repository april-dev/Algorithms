public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            map.put(arr[i], i);
        }
        for (int[] piece: pieces){
            if (!map.containsKey(piece[0])) return false;
            int idx = map.get(piece[0]);
            for (int i=1; i<piece.length; i++){
                if (!map.containsKey(piece[i]) || map.get(piece[i])!=idx+1) return false;
                idx++;
            }
        }
        return true;
    }
