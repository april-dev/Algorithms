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

//cleaned version
Stack<Node> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            if (stack.isEmpty() || stack.peek().c!=s.charAt(i)){
                stack.add(new Node(s.charAt(i)));
            }else{           
                stack.peek().count++;
                if (stack.peek().count==k) stack.pop();
            
            }           
        }
        StringBuilder sb = new StringBuilder();
        for (Node n: stack){
            for (int i=0; i<n.count; i++){
                sb.append(n.c);
            }
        }
        return sb.toString();
    }
    class Node {
        Character c;
        int count;
        public Node(char c){
            this.c = c;
            count = 1;
        }



//My solution
public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            Node cur = new Node(c);
            while (!stack.isEmpty() && stack.peek().c==c){
                cur.count = stack.peek().count +1;
                stack.pop();                                              
            }            
            if (cur.count<k) stack.add(cur);           
        }            
        StringBuilder sb = new StringBuilder();
        for (Node n:stack){
            for (int i=0; i<n.count; i++){
                sb.append(n.c);
            }
        }
        return sb.toString();       
    }
    
    class Node{
        char c;
        int count;
        public Node(char c){
            this.c = c;
            count = 1;
        }
    }
