import java.util.ArrayList;
import java.util.Comparator;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
		if(numbers == null)
			return null;
		if(numbers.length == 0)
			return "";
		String str[] = new String[numbers.length];
		for(int i=0; i<numbers.length; i++){
			str[i] = String.valueOf(numbers[i]);
		}
		java.util.Arrays.sort(str,new Comparator<String>(){
			public int compare(String s1,String s2){
				String c1 = s1+s2;
				String c2 = s2+s1;
				return c1.compareTo(c2);
			}
		});
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length; i++)
			sb.append(str[i]);
		return sb.toString();
    }
}