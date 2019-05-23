import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers){
		if(numbers == null || numbers.length != 5)
			return false;
		int numOfZero = 0;
		int numOfGap = 0;
		java.util.Arrays.sort(numbers);
		for(int i=0; i<numbers.length; i++){
			if(numbers[i] == 0){
				numOfZero++;
				continue;
			}
			if(i < numbers.length-1 && numbers[i] == numbers[i+1])
				return false;
			if(i < numbers.length-1)
				numOfGap += numbers[i+1]-numbers[i]-1;
		}
		if(numOfGap <= numOfZero)
			return true;
		return false;
	}
}