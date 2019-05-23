import java.util.ArrayList;
public class Solution {
    //和为s的两个数
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
		if(array == null || array.length == 0)
			return result;
		int start = 0;
		int end = array.length-1;
		while(start < end){
			int curSum = array[start] + array[end];
			if(curSum == sum){
				result.add(array[start]);
				result.add(array[end]);
				return result;
			}else if(curSum > sum){
				end--;
			}else{
				start++;
			}
		}
		return result;
    }
	
	//和为s的连续序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(sum < 3)
			return result;
		int small = 1;
		int big = 2;
		int mid = (sum+1)/2;
		while(small < mid){
			int curSum = sumOfList(small,big);
			if(curSum == sum){
				ArrayList<Integer> list = new ArrayList<>();
				for(int i=small; i<=big; i++)
					list.add(i);
				result.add(list);
				small++;
				big++;
			}else if(curSum < sum){
				big++;
			}else{
				small++;
			}
		}
		return result;
	}
	
	public int sumOfList(int head, int leap){
		int sum = 0;
		for(int i=head; i<=leap; i++)
			sum += i;
		return sum;
	}
}