import java.util.ArrayList;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
		if(index <= 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		while(list.size() < index){
			int m2 = list.get(index2)*2;
			int m3 = list.get(index3)*3;
			int m5 = list.get(index5)*5;
			int min = Math.min(m2,Math.min(m3,m5));
			list.add(min);
			if(min == m2)
				index2++;
			if(min == m3)
				index3++;
			if(min == m5)
				index5++;
		}
		return list.get(index-1);
	}
}