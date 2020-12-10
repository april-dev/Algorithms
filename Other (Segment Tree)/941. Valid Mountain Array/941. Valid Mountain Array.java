public boolean validMountainArray(int[] arr) {
        if (arr.length<=2 || arr[0] >= arr[1]) return false;
        boolean down = false;
        for (int i=2; i<arr.length; i++){
            if (arr[i] < arr[i-1]) down = true;
            //concise and faster: else if (arr[i] == arr[i-1] || down == true) return false;
            else if (arr[i] == arr[i-1] || arr[i] > arr[i-1] && down == true) return false;
        }
        return down;
    }
