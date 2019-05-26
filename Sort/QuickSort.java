public class QuickSort{
	public static void quickSort(int array[], int start, int end){
		if(start >= end)
			return;
		int pivot = array[start];
		int i = start;
		int j = end;
		while(i < j){
			while(i < j && array[j] >= temp)
				j--;
			while(i < j && array[i] <= temp)
				i++;
			if(i < j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[start] = array[i];
		array[i] = pivot;
		quickSort(array, start, i-1);
		quickSort(array, i+1, end);
	}
}