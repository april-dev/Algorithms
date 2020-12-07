time complexity is O(N * 4^N * K) where:

N is length of start string
K is number of strings in bank

We are generating mutations by changing each letter in start string. Then, We will have O(4^N) mutations.
Generating a mutation takes O(N) because of toCharArray() and new String()
We will add at most O(K) mutations into queue and there is no duplicate because of set
