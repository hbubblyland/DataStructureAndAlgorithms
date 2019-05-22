import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
	int count = 0;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,new Comparator<Integer>(){
		public int compare(Integer o1,Integer o2){
			return o2-o1;
		}
	});
    public void Insert(Integer num) {
		if(count %2 != 0){
			minHeap.add(num);
			maxHeap.add(minHeap.poll());
		}else{
			maxHeap.add(num);
			minHeap.add(maxHeap.poll());
		}
		count++;
    }

    public Double GetMedian() {
        if(count %2 != 0){
			return new Double(minHeap.peek());
		}else{
			return new Double((maxHeap.peek()+minHeap.peek()))/2;//注意先转换为double，再除以2，不然小数会被约去
		}
    }


}