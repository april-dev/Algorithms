public int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits==null || digits.length==0 || n==0) return 0;
        String nStr = Integer.toString(n);
        int numDigits = digits.length;
        int numDigitsN = nStr.length();
        int total = 0;
        
        for (int i=1; i<numDigitsN; i++){
            total += Math.pow(numDigits, i);
        }
        for (int i=0; i < numDigitsN; i++){
            boolean sameNum = false;
            for (String s: digits){
                if (s.charAt(0) < nStr.charAt(i)){
                    total += Math.pow(numDigits, numDigitsN - i - 1);
                }else if(s.charAt(0) == nStr.charAt(i)){
                    sameNum = true;
                }
            }
            if (!sameNum) return total;
        }
        return total+1;
    }
