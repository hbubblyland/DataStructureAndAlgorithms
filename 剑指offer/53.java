public class Solution {
    //二分查找法(测试没通过)
	public int GetNumberOfK(int [] array , int k) {
       if(array == null)
		   return 0;
	   int first = getFirstK(array, k, 0, array.length-1);
	   int last = getLastK(array, k, 0, array.length-1);
	   int result = 0;
	   if(first != -1 && last != -1)
		   result = last - first +1;
	   return result;
    }
	
	public int getFirstK(int array[], int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start+end)/2;
		if(array[mid] == k){
			if((array[mid-1] != k && mid > 0) || mid == 0)
				return mid;
			else
				end = mid-1;
		}else if(array[mid] > k){
			end = mid -1;
		}else{
			start = mid + 1;
		}
		return getFirstK(array,k,start,end);
	}
	
	public int getLastK(int array[], int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start+end)/2;
		if(array[mid] == k){
			if((array[mid+1] != k && mid < array.length-1) || mid == array.length-1)
				return mid;
			else
				start = mid+1;
		}else if(array[mid] > k){
			end = mid-1;
		}else{
			start = mid+1;
		}
		return getLastK(array,k,start,end);
	}
}