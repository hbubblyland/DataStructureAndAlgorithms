import java.util.Map;
import java.util.LinkedHashMap;
public class Solution {
    //方法一：快排找到第n/2大的数字，没过测试
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
			return 0;
		}
		int start = 0;
		int end = array.length-1;
		int mid = array.length>>1;
		int index = Partition(array, 0, array.length-1);
		while(index != mid){
			if(index > mid){
				index = Partition(array, start, end-1);
			}else{
				index = Partition(array, index+1, end);
			}
		}
		int num = array[index];
		int times = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] == num)
				times++;
		}
		if(times < (array.length>>1)+1)
			return 0;
		else
			return num;
    }
	
	public int Partition(int array[], int start, int end){
		int povit = array[start];
		while(start < end){
			while(start < end && array[end] > povit)
				end--;
			array[start] = array[end];
			while(start < end && array[++start] < povit){}
			array[end] = array[start];
		}
		array[start] = povit;
		return start;
	}
	
	//方法二：根据数组特点
	public int MoreThanHalfNum_Solution(int [] array){
		if(array == null || array.length == 0){
			return 0;
		}
		int num = array[0];
		int times = 1;
		for(int i=1; i< array.length; i++){
			if(times == 0){
				num = array[i];
				times = 1;
			}else if(array[i] == num){
				times++;
			}else{
				times--;
			}
		}
		
		times = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] == num)
				times++;
		}
		if(times > array.length/2)
			return num;
		else
			return 0;
	}
	
	//方法三：hashmap
	public int MoreThanHalfNum_Solution(int [] array){
		if(array == null || array.length == 0){
			return 0;
		}
		if(array.length == 1)
			return array[0];
		Map<Integer,Integer> map = new LinkedHashMap<>();
		for(int i=0; i<array.length; i++){
			if(map.containsKey(array[i])){
				map.put(array[i], map.get(array[i])+1);
				if(map.get(array[i]) > (array.length/2))
					return array[i];
			}else{
				map.put(array[i], 1);
			}
		}
		return 0;
	}
}