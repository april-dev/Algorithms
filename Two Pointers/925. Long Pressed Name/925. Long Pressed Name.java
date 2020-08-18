public boolean isLongPressedName(String name, String typed) {
        int i=0, j=0;
        while(j<typed.length()){
            if (i<name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if (i>0 && typed.charAt(j)== name.charAt(i-1)){
                j++;
            }else{
                return false;
            }
        }
        return i==name.length();
    }  

//Alternative
public boolean isLongPressedName(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j)
            if (i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        return i == m;
    }
