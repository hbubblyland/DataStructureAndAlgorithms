import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
		if(num == null || size > num.length || size <= 0)
			return result;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0; i<num.length; i++){
			while(!list.isEmpty() && num[i] > num[list.getLast()]){
				list.removeLast();
			}
			list.addLast(i);
			if(i >= size-1){
				if(i-list.getFirst()+1>size)
					list.removeFirst();
				result.add(num[list.getFirst()]);
			}
		}
		return result;
    }
}