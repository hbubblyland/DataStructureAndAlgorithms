public class HeapSort{
	public static void heapSort(int array[]){
		for(int i=array.length/2-1; i>=0; i--){
			adjustHeap(array, i, array.length-1);
		}
		for(int j=array.length-1; j>=0; j--){
			int temp = array[0];
			array[0] = array[j];
			array[j] = temp;
			adjustHeap(array, 0, j-1);
		}
	}
	
	public static void adjustHeap(int array[], int i, int len){
		int temp, j;
		temp = a[i];
		for(j=2*i+1; j<=len; j=2*j+1){
			if(j<len && array[j]<array[j+1])
				++j;
			if(temp >= array[j])
				break;
			a[i] = a[j];
			i = j;
		}
		a[i] = temp;
	}
}