class Solution{
	public int maxProfit(int numbers[]){
		if(numbers == null || numbers.length < 2)
			return 0;
		int min = numbers[0];
		int maxDiff = numbers[1] - numbers[0];
		for(int i=2; i<numbers.length; i++){
			if(numbers[i-1] < min)
				min = numbers[i-1];
			int curDiff = numbers[i] - min;
			if(curDiff > maxDiff)
				maxDiff = curDiff;
		}
		return maxDiff;
	}
}