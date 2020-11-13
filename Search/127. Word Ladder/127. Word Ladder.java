/*
avoid visited words is necessary. see example below.
"hit"
"cog"
["hot","dot","dog","lot","log"]
*/

/*
Time O(nL), n is the number of the words in the wordList, and L is the length of the each word.
Because, the worst case is that each word needs to enqueue and dequeue. And each time the we need to loop of L times, 
to check if it exits in the wordList. And the find function is O(1) and to change number is O(1). so the finally time complexity is O(nL).
*/
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList); //, vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        for (int len = 1; !q.isEmpty(); len++) {
            for (int i = q.size(); i > 0; i--) {
                String w = q.poll();
                if (w.equals(endWord)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb)) q.offer(nb);
                    }
                }
            }
        }
        return 0;
    }
