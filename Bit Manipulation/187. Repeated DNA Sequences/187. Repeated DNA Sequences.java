/*
If two objects have same hash it means that they may or may not be equal (though two equal objects are required to have same hash). 
So hashing is not enough here (like calling just "AACCCCCGGG".hashCode() and storing it in the map), because there can be another (different) 
string with same hash and the program will output wrong result.

We also cannot store the 10-letter substrings themselves because they consume too much memory and the program will exceed memory limit.

So, instead of hashing or storing strings themselves the solution converts 10 letter string into 4-bytes integer (which is much smaller than 
string in terms of consumed memory). This would not be possible if the string could contain all 26 letters of English alphabet for example. 
But it is possible for our case, because there can be only 'A', 'C', 'G' and 'T' letters.

*/

public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        int val = 0;
        for (int i=0; i<s.length(); i++){
            val = (val<<2);
            val |= map[s.charAt(i) - 'A'];
            val &= 0xfffff;   //0xfffff is 20 '1's, aka Window of 10 2bits, the bits exceed 20 bits will be 0.
            if (i<9) continue;
            if (!word.add(val) && secondWord.add(val)) res.add(s.substring(i-9, i+1));
        }
        return res;
    }
    
    
 //version 2
 public List<String> findRepeatedDnaSequences(String s) {
    	if(s.length() < 11) return new ArrayList<>();
        Set<Integer> words1 = new HashSet<>();
        Set<Integer> words2 = new HashSet<>();
        List<String> res = new ArrayList<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int val = 0;
        
        for(int i = 0; i < 10; i++){  // first value
    		val = val << 2;
    		val = val | map[s.charAt(i) - 'A'];
		}
		words1.add(val);

        for(int i = 1; i < s.length() - 9; i++){ 
    		val &= ~(3 << 18);  //~(3<<18) = ~(11000000000000000000) = 00111111111111111111
    		val = val << 2;
    		val = val | map[s.charAt(i+9) - 'A'];
        	if(!words1.add(val) && words2.add(val)){
        		res.add(s.substring(i, i + 10));
        	}
        }
        return res;
    }
