public class Solution {
    public String ReverseSentence(String str) {
        if(str == null)
			return null;
		if(str.trim().equals(""))
			return str;
		char ch[] = str.toCharArray();
		int start = 0;
		int end = str.length()-1;
		reverseWord(ch,start,end);
		int low = 0;
		for(int i=0; i<str.length(); i++){
			if(ch[i] == ' '){
				int high = i-1;
				reverseWord(ch,low,high);
				low = high+2;
			}
		}
		reverseWord(ch,low,str.length()-1);
		return new String(ch);
	}
	
	public void reverseWord(char ch[], int start, int end){//这里一定要用char
		while(start < end){
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
	}
}