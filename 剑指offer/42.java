public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)
			return 0;
		int curSum = array[0];
		int maxSum = array[0];
		for(int i=1; i<array.length; i++){
			if(curSum < 0){
				curSum = array[i];
			}else{
				curSum += array[i];
			}
			if(curSum > maxSum)
				maxSum = curSum;
		}
		return maxSum;
    }
}