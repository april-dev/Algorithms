public String countAndSay(int n) {
        if (n==1) return "1";
        String prev = countAndSay(n-1);
        char cur = prev.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<prev.length(); i++){
            if (prev.charAt(i)!=cur){
                sb.append(count);
                sb.append(cur);
                count = 1;
                cur = prev.charAt(i);
            }else{
                count++;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }
