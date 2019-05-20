import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      if(pushA == null || popA == null || pushA.length != popA.length || pushA.length == 0 || popA.length == 0)
		  return false;
	  Stack<Integer> stack = new Stack<>();
	  int popIndex = 0;
	  for(int i = 0; i < popA.length; i++){
		  stack.push(pushA[i]);
		  if(!stack.isEmpty() && stack.peek() == popA[popIndex]){
			  stack.pop();
			  popIndex++;
		  }
	  }
	  return stack.isEmpty();
    }
}