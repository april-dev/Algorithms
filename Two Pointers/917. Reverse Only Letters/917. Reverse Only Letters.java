public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i=0, j=arr.length-1;
        while(i<j){
            if (!Character.isLetter(arr[i])){
                i++;
            }else if (!Character.isLetter(arr[j])){
                j--;
            }else{
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }
    
    //Using StringBuilder
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j;) {
            if (!Character.isLetter(sb.charAt(i))) {
                ++i;
            } else if (!Character.isLetter(sb.charAt(j))) {
                --j;
            } else {
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j--, S.charAt(i++));
            }
        }
        return sb.toString();
    }
