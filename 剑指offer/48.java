class solution{
	public static int longestSubstring(String str){
		if(str == null)
			return 0;
		int arr[] = new int[26];
		for(int i=0; i<26; i++)
			arr[i] = -1;
		int curLength = 0;
		int maxLength = 0;
		for(int i=0; i<str.length(); i++){
			if(arr[i] = -1 || i-arr[str.charAt(i)-'a']>curLength){
				curLength++;
			}else{
				curLength = i-arr[str.charAt(i)-'a'];
				if(curLength>maxLength)
					maxLength = curLength;
			}
		}
		return maxLength;
	}
}