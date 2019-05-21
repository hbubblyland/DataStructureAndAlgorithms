import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> result = new ArrayList<String>();
	   if(str != null && str.length() > 0){
		   PermutationCore(str.toCharArray(), 0, result);
		   Collections.sort(result);
	   }
	   return result;
    }
	
	public void PermutationCore(char chars[], int i, ArrayList<String> list){
		if(i == chars.length-1){
			list.add(String.valueOf(chars));
		}else{
			Set<Character> charSet = new HashSet<>();
			for(int j = i; j < chars.length; j++){
				if(!charSet.contains(chars[j])){
					charSet.add(chars[j]);
					swap(chars, i, j);
					PermutationCore(chars, i+1, list);
					swap(chars, j, i);
				}
			}
		}
	}
	
	public void swap(char cs[], int i, int j){
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}
}