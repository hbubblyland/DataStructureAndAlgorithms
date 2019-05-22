public class Solution {
    public int InversePairs(int [] array) {
		if(array == null || array.length <= 1)
			return 0;
		int copy[] = new int[array.length];
		for(int i=0; i<array.length; i++){
			copy[i] = array[i];
		}
		return InversePairsCore(array, copy, 0, array.length-1);
	}
	
	public int InversePairsCore(int array[], int copy[], int low, int high){
		if(low == high)
			return 0;
		int mid = (low+high)>>1;
		int leftCount = InversePairsCore(array,copy,low,mid);
		int rightCount = InversePairsCore(array,copy,mid+1,high);
		int count = 0;
		int i = mid;
		int j = high;
		int locCopy = high;
		while(i >= low && j > mid){
			if(array[i] >= array[j]){
				count += j-mid;
				copy[locCopy--] = array[i--];
			}else{
				copy[locCopy--] = array[j--];
			}
		}
		for(; i>=low; i--)
			copy[locCopy--] = array[i];
		for(; j>mid; j--)
			copy[locCopy--] = array[j];
		for(int m=low; m<=high; m++)
			array[m] = copy[m];
		return leftCount+rightCount+count;
	}
}