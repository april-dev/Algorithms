time complexity is O(N * N * M * K) where:

N is length of start string
M is number of letters in gene
K is number of strings in bank
My thinking ways were:

We are generating mutations by changing each letter in start string. Then, We will have O(N * M) mutations.
Generating a mutation takes O(N) because of toCharArray() and new String()
We will add at most O(K) mutations into queue and there is no duplicate because of set
