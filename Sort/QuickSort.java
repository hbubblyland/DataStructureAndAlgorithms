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
	
	//优化：1，随机获取start和end之间的pivot，解决了对于基本有序的数组排列时的问题，但还是个随机情况
	//2，三数取中，取三个数先进行排序，将中间数作为枢轴，一般取左端，右端，中间三个数。从概率上讲，取三个数均为最小或最大的可能性是微乎其微
	//3，优化不必要的交换，如上已经是优化过后的，只在最后对pivot和array[i]交换。交换次数减少了一半
	/*
	原本，一直在对枢轴进行交换，而上面的方法只在最后进行交换。
	while(i < j){
			while(i < j && array[j] >= temp)
				j--;
			swap(array,start,end);
			while(i < j && array[i] <= temp)
				i++;
			swap(array,start,end);
		}
		当前low即为枢轴
	*/
	//4，如果数组非常小，快排反而不如一些简单的排序方法来的快，因为它用到了递归操作，在大量数据排序时，这点性能影响相对于整体算法优势而言可以忽略
	//当数组元素非常小时，可以考虑直接插入排序。
	//5，优化递归操作，在函数尾部有两次递归操作，如果待排序的序列划分极端不平衡，递归深度将趋近于n，而不是平衡时的log2n。栈的大小是有限的，
	//每次递归调用会耗费一定的栈空间，函数的参数越多，每次递归耗费的空间越多，因此如果能减少递归，将会大大提高性能。
	/*
while(start<end){ 因采取迭代而不是递归的方法可以缩减堆栈深度，提高整体性能。
	pivot = partition(array,start,end);
	quickSort(array,start,pivot-1); 此时low已经没用了
	low = pivot+1;    
}
	*/
}