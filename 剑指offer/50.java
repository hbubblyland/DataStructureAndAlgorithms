import java.util.LinkedHashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();//有序
		for(int i=0; i<str.length(); i++){
			if(map.containsKey(str.charAt(i))){
				int num = map.get(str.charAt(i));
				map.put(str.charAt(i),++num);
			}else{
				map.put(str.charAt(i),1);
			}
		}
		for(int index=0; index<str.length(); index++){
			if(map.get(str.charAt(index)) == 1)
				return index;
		}
		return -1;
    }
}