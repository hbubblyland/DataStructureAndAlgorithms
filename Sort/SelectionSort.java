public class SelectionSort{
	public void SelectionSort0(int array[]){
		for(int i=0; i<array.length-1; i++){//n-1趟
			int minIndex = i;
			for(int j=i+1; j<array.length; j++){
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			if(minIndex != i){
				int temp = array[minIndex];
				array[minIndex] array[i];
				array[i] = temp;
			}
		}
	}
}