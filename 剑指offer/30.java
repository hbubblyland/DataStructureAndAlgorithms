import java.util.Stack;

public class Solution {

    Stack<Integer> data = new Stack<>();
	Stack<Integer> min = new Stack<>();
	Integer temp = null;
    public void push(int node) {
        if(temp == null){
			temp = node;
			data.push(node);
			min.push(node);
		}else{
			if(node < temp){
				temp = node;
				data.push(node);
				min.push(node);
			}else{
				data.push(node);
				min.push(temp);
			}
		}
    }
    
    public void pop() {
        data.pop();
		min.pop();
    }
    
    public int top() {
       return data.peek(); 
    }
    
    public int min() {
        return min.peek();
    }
}