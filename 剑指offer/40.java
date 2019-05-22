import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution {
    //快排
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || k <= 0 || k > input.length)
			return list;
		int start = 0;
		int end = input.length-1;
		int index = partition(input,start,end);
		while(index != k-1){
			if(index > k-1){
				index = partition(input, start, index-1);
			}else{
				index = partition(input, index+1, end);
			}
		}
		for(int i= 0; i < k; i++){
			list.add(input[i]);
		}
		return list;
    }
	
	public int partition(int arr[], int start, int end){
		int temp = arr[0];
		while(start < end){
			while(start < end && arr[end] >= temp)
				end--;
			swap(arr,start,end);
			while(start < end && arr[start] <= temp)
				start++;
			swap(arr,start,end);
		}
		return start;
	}
	public void swap(int arr[], int start, int end){
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	//堆排序
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || k <= 0 || k > input.length)
			return list;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2){
				return o2.compareTo(o1);
			}
		});
		for(int i=0; i<input.length; i++){
			if(maxHeap.size() < k){
				maxHeap.offer(input[i]);
			}else{
				if(maxHeap.peek() > input[i]){
					maxHeap.poll();
					maxHeap.offer(input[i]);
				}
			}
		}
		for(Integer integer:maxHeap)
			list.add(integer);
		return list;
	}
}