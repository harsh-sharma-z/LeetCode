class BrowserHistory {
    Stack<String> forward=new Stack<>();
    Stack<String>  backward=new Stack<>();
    String curr;
    public BrowserHistory(String homepage) {
        curr=homepage;
    }
    
    public void visit(String url) {
        backward.push(curr);
        curr=url;
        forward.removeAllElements();
        
    }
    
    public String back(int steps) {
         while(steps>0 && !backward.isEmpty())
         {
             forward.push(curr);
             curr=backward.pop();
             steps--;
         }
        return curr;
    }
    
    public String forward(int steps) {
        
        while(steps>0 && !forward.isEmpty())
        {
            backward.push(curr);
            curr=forward.pop();
            steps--;
        }
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */