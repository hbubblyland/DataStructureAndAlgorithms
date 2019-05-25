public class InsertionSort{
	public void InsertionSort0(int array[]){
		for(int i=1; i<array.length; i++){//从第一个数后面开始插入
			int j = i;
			int target = array[i];
			while(j > 0 && array[j] < array[j-1]){
				array[j] = array[j-1];
				j--;
			}
			array[j] = target;
		}
	}
}