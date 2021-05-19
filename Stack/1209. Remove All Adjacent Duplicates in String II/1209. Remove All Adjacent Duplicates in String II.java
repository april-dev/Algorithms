public String removeDuplicates(String s, int k){
    int len=s.length();
    Stack<Node> stack = new Stack<>();
    for(char c : s.toCharArray()){
        //compare prev with cur
        if(!stack.isEmpty() && stack.peek().c == c){
            stack.peek().count++;
        }else{
            //not repeat
            stack.push(new Node(c,1));
        }
        //remove when num of dup == k
        if(stack.peek().count==k) stack.pop();
    }
    //build result
    StringBuilder sb = new StringBuilder();
    for(Node node : stack){
        for(int i=0;i<node.count;i++){
            sb.append(node.c);
        }
    }
    return sb.toString();
}

class Node{
    char c;
    int count;
    public Node(char c, int count){
        this.c=c;
        this.count=count;
    }
}
