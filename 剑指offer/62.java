public class Solution {
    public int LastRemaining_Solution(int n, int m){
		if(n < 1 || m < 1)
			return -1;
		int arr[] = new int[n];
		int index = -1;
		int step = 0;
		int count = n;
		while(count > 0){
			index++;
			if(index >= n)
				index = 0;
			if(arr[index] == -1)
				continue;
			step++;
			if(step == m){
				arr[index] = -1;
				step = 0;
				count--;
			}
		}
		return index;
	}
}