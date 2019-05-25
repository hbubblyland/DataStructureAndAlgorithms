public class BubbleSort{
	public void BubbleSort0(int array[]){
		if(array == null || array.length == 0)
			return;
		for(int i = 0; i < array.length-1; i++){//外层循环控制进行多少趟排序
			for(int j = 0; j < array.length-1-i; j++){//内层循环控制每一趟的排序次数
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	//优化
	public void BubbleSort1(int array[]){
		for(int i=0; i<array.length-1; i++){
			boolean flag = true;
			for(int j=0; j<array.length-1-i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if(flag)
				break;
		}
	}
}