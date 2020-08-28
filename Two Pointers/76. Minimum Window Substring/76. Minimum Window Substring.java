public String minWindow(String s, String t) {
        int i=0;
        int left = 0;
        //int right = 0;
        int counter = t.length();
        int len = Integer.MAX_VALUE;
        int[] count = new int[128];
        
        for (int j=0; j<t.length(); j++){
            ++count[t.charAt(j)];
        }
        
        for (int j=0; j<s.length(); j++){
            if (count[s.charAt(j)]>0){
                counter-=1;
            }
            --count[s.charAt(j)];
            
            while (counter==0){
                if (j-i<len) {
                    len = j-i+1;
                    left = i;
                    //right = j;
                }
                ++count[s.charAt(i)];
                if (count[s.charAt(i)]>0) counter++;
                i++;
            }
        }
        return len==Integer.MAX_VALUE? "" : s.substring(left, left+len);
        
    }
