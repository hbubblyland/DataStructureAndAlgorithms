public class MergeSort{
	public void mergeSort(int array[], int low, int high){
		if(low >= high)
			return;
		int mid = (low+high)/2;
		mergeSort(array, low, mid);
		mergeSort(array, mid+1, high);
		merge(array, low, mid, high);
	}
	
	//非递归
	public void mergeSort1(int array[]){
		for(int i=1; i<array.length; i*=2){
			for(int j=0; j<=array.length-2*i+1; j += i*2)
				merge(array, j, j+i-1, j+2*i-1);
			if(j < array.length - i+1)//保证那些长度不足的子序列也能merge
				merge(array, j, j+i-1, array.length-1);
		}
	}
	
	public void merge(int array[], int low, int mid, int high){
		int temp[] = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		while(i <= mid && j <= high){
			if(array[i]<=array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		while(i <= mid)
			temp[k++] = array[i++];
		while(j <= high)
			temp[k++] = array[j++];
		for(int m=0; m<temp.length; m++)
			array[low+m] = temp[m];
	}
}