public int minimumDeletions(String s) {
        char[] sarr = s.toCharArray();
        int[][] arr = new int[sarr.length][2];
        if (sarr[0]=='a'){
            arr[0][1] = 1;
        }else{
            arr[0][0] = 1;
        }
        int last = -1;
        for (int i=1; i<arr.length; i++){
            if (sarr[i]==sarr[i-1]){
                if (sarr[i]=='a') {
                    arr[i][0] = arr[i-1][0];
                    arr[i][1] = arr[i-1][1]+1;
                }else{
                    arr[i][0] = arr[i-1][0]+1;
                    arr[i][1] = arr[i-1][1];
                }
            }else if (sarr[i]<sarr[i-1]){
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][1]+1;
            }else{
                
                arr[i][1] = Math.min(arr[i-1][1], arr[i-1][0]);
                arr[i][0] = arr[i-1][0]+1;
            }
        }
        return Math.min(arr[arr.length-1][0], arr[arr.length-1][1]);
    }
